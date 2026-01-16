package com.Attendance.AttendanceManagement.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Attendance.AttendanceManagement.dto.StudentResponseDto;

@FeignClient(name = "student-service",  url = "http://localhost:8080")
public interface StudentClient {

    @GetMapping("/api/students/{rollNo}")
    StudentResponseDto getStudent(@PathVariable("rollNo") Long rollNo);

    @GetMapping("/api/students")
    List<StudentResponseDto> getAllStudents();
}
