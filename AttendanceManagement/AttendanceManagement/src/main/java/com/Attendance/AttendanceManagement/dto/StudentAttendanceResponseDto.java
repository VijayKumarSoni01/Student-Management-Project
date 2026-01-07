package com.Attendance.AttendanceManagement.dto;

import java.util.List;
import lombok.Data;

@Data
public class StudentAttendanceResponseDto {
    private Long rollNo;
    private String studentName;
    private String className;
    private List<AttendanceRecordDto> attendanceHistory;
}
