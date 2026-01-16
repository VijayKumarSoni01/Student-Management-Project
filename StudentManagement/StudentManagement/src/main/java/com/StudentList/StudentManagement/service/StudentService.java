package com.StudentList.StudentManagement.service;

import java.util.List;
import java.util.Map;

import com.StudentList.StudentManagement.dto.StudentResponseDto;
import com.StudentList.StudentManagement.dto.StudentPublicDTO;
import com.StudentList.StudentManagement.dto.StudentRequestDto;

public interface StudentService {

    StudentResponseDto addStudent(StudentRequestDto dto);

    List<StudentResponseDto> getAllStudents();

    StudentResponseDto getStudentById(Long rollNo);

    List<StudentResponseDto> searchByName(String name);

    StudentResponseDto updatePartialStudent(Long rollNo, Map<String,Object> update);

    List<StudentPublicDTO> getPublicStudents();
}


