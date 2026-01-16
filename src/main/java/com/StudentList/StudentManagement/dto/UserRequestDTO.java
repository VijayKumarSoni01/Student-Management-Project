package com.StudentList.StudentManagement.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank
    @Pattern(
      regexp = "^[a-z]+$",
      message = "Username must contain only lowercase letters"
    )
    private String username;

    @NotBlank
    @Pattern(
      regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/]).{5,}$",
      message = "Password must be at least 5 characters, 1 number, 1 special char"
    )
    private String password;

    @NotBlank
    private String role;
}