package com.abhijits.studentservice.dao;

import com.abhijits.studentservice.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by   : Abhijit Singh
 * On           : 24 September, 2022
 */

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
