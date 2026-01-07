package com.Attendance.AttendanceManagement.dto;

import lombok.Data;

@Data
public class BulkAttendanceRequestDto {
    private Long rollNo;
    private String status;
}

