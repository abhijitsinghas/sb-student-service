package com.abhijits.studentservice.service;

import com.abhijits.studentservice.dao.StudentRepository;
import com.abhijits.studentservice.domain.Student;
import com.abhijits.studentservice.errorhandling.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by   : Abhijit Singh
 * On           : 24 September, 2022
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student get(UUID uuid) {
        return studentRepository.findById(uuid).orElseThrow(() -> new NotFoundException("Student not found."));
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public void delete(UUID uuid) {
        studentRepository.deleteById(uuid);
    }

    public Student update(Student student) {
        return studentRepository.save(
                get(student.getUuid())
                        .setFirstName(student.getFirstName())
                        .setLastName(student.getLastName())
                        .setGender(student.getGender())
                        .setAge(student.getAge())
                        .setStandard(student.getStandard())
        );
    }
}
