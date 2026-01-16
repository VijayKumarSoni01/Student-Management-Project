package com.StudentList.StudentManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentList.StudentManagement.dto.StudentResponseDto;
import com.StudentList.StudentManagement.dto.StudentPublicDTO;
import com.StudentList.StudentManagement.dto.StudentRequestDto;
import com.StudentList.StudentManagement.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/admission")
    public StudentResponseDto addStudent(
            @Valid @RequestBody StudentRequestDto dto) {
        return studentService.addStudent(dto);
    }

    // FOR PUBLIC VIEW
    @GetMapping("/public")
    public List<StudentPublicDTO> getPublicStudents() {
        return studentService.getPublicStudents();
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{rollNo}")
    public StudentResponseDto getStudent(@PathVariable Long rollNo) {
        return studentService.getStudentById(rollNo);
    }

    @GetMapping("/search")
    public List<StudentResponseDto> search(@RequestParam String name) {
        return studentService.searchByName(name);
    }

    @PatchMapping("/update/{rollNo}")
    public ResponseEntity<StudentResponseDto> updatePartialStudent(@PathVariable Long rollNo,
            @RequestBody Map<String, Object> update) {
        return ResponseEntity.ok(studentService.updatePartialStudent(rollNo, update));
    }

}