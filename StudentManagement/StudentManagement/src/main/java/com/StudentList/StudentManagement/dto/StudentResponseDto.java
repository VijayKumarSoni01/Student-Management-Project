package com.StudentList.StudentManagement.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentResponseDto {
    private Long rollNo;
    private String name;
    private String className;
    private String gender;
    private LocalDate date;
    private String fatherName;
    private Long phoneNo;
    private String email;
    private String address;
}
