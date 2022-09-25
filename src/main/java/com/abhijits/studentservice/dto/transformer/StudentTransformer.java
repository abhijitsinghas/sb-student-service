package com.abhijits.studentservice.dto.transformer;

import com.abhijits.studentservice.domain.Student;
import com.abhijits.studentservice.dto.StudentDto;
import org.springframework.stereotype.Component;

/**
 * Created by   : Abhijit Singh
 * On           : 24 September, 2022
 */
@Component
public class StudentTransformer implements Transformer<Student, StudentDto> {

    @Override
    public StudentDto toDto(Student student) {
        return new StudentDto()
                .setUuid(student.getUuid())
                .setFirstName(student.getFirstName())
                .setLastName(student.getLastName())
                .setGender(student.getGender())
                .setAge(student.getAge())
                .setStandard(student.getStandard());
    }

    @Override
    public Student toDomain(StudentDto studentDto) {
        return new Student()
                .setFirstName(studentDto.getFirstName())
                .setLastName(studentDto.getLastName())
                .setAge(studentDto.getAge())
                .setGender(studentDto.getGender())
                .setStandard(studentDto.getStandard());
    }
}
