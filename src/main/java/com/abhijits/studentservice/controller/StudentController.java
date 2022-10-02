package com.abhijits.studentservice.controller;

import com.abhijits.studentservice.dto.StudentDto;
import com.abhijits.studentservice.dto.transformer.StudentTransformer;
import com.abhijits.studentservice.service.StudentService;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by   : Abhijit Singh
 * On           : 24 September, 2022
 */
@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    private final StudentTransformer transformer;

    public StudentController(StudentService studentService, StudentTransformer transformer) {
        this.studentService = studentService;
        this.transformer = transformer;
    }

    @GetMapping(
            path = "/{uuid}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StudentDto> get(@PathVariable UUID uuid) {
        return ResponseEntity.ok().body(transformer.toDto(studentService.get(uuid)));
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StudentDto> create(@Valid @RequestBody StudentDto studentDto) {
        StudentDto responseStudentDto = transformer.toDto(studentService.create(transformer.toDomain(studentDto)));

        return ResponseEntity.created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).get(responseStudentDto.getUuid())).toUri())
                             .body(responseStudentDto);
    }

    @PatchMapping(
            path = "/{uuid}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StudentDto> update(@PathVariable UUID uuid, @Valid @RequestBody StudentDto studentDto) {
        return ResponseEntity.ok()
                             .body(transformer.toDto(studentService.update(transformer.toDomain(studentDto).setUuid(uuid))));
    }

    @DeleteMapping(
            path = "/{uuid}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity delete(@PathVariable UUID uuid) {
        studentService.delete(uuid);
        return ResponseEntity.ok().build();
    }

}
