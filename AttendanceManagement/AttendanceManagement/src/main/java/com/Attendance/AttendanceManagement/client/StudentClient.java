package com.Attendance.AttendanceManagement.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Attendance.AttendanceManagement.dto.StudentResponseDto;

@Service
public class StudentClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String STUDENT_URL =
            "http://localhost:8080/api/students/";

    public StudentResponseDto getStudent(Long rollNo) {
        return restTemplate.getForObject(
                STUDENT_URL + rollNo,
                StudentResponseDto.class
        );
    }
}
