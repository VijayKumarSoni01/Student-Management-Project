package com.Attendance.AttendanceManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "Username is required")
    @Pattern(
        regexp = "^[a-z]+$",
        message = "Username must contain only lowercase letters"
    )
    private String username;
    @NotBlank(message = "Password is required")
    @Pattern(
        regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/]).{5,}$",
        message = "Password must be at least 5 characters long and contain 1 number and 1 special character"
    )
    private String password;
    private String role;
    private boolean enabled;

}
