package com.StudentList.StudentManagement.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StudentRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String className;

    @NotBlank
    private String gender;

    @Email
    private String email;
    
    private LocalDate date;

    @NotBlank
    private String fatherName;

    @NotNull(message = "Phone number is required")
    @Digits(integer = 10, fraction = 0, message = "Phone number must be exactly 10 digits")
    private Long phoneNo;


    private String address;
}
