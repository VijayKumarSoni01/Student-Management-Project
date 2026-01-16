package com.StudentList.StudentManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentList.StudentManagement.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByNameIgnoreCaseAndFatherNameIgnoreCase(
            String name,
            String fatherName
    );

    List<Student> findByNameContainingIgnoreCase(String name);
}
