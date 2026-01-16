package com.StudentList.StudentManagement.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String username;
    private String password;
    private String role;
    private boolean enabled;
}
