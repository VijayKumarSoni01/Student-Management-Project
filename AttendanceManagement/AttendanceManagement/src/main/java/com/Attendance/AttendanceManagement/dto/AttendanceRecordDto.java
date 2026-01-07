package com.Attendance.AttendanceManagement.dto;

import java.time.LocalDate;

import com.Attendance.AttendanceManagement.entityEnum.StatusEnum;

import lombok.Data;

@Data
public class AttendanceRecordDto {
    private LocalDate attendanceDate;
    private StatusEnum status;
}
