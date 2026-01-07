package com.StudentList.StudentManagement.dto;

import lombok.Data;

@Data
public class StudentResponseDto {
    private Long rollNo;
    private String name;
    private String className;
    private String gender;
    private String fatherName;
}
