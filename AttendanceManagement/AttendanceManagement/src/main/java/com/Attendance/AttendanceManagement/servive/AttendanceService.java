package com.Attendance.AttendanceManagement.servive;

import com.Attendance.AttendanceManagement.dto.StudentAttendanceResponseDto;
import com.Attendance.AttendanceManagement.model.Attendance;

public interface AttendanceService {

    Attendance markAttendance(Long rollNo, String status);

    StudentAttendanceResponseDto getStudentAttendance(Long rollNo);
}
