package com.Attendance.AttendanceManagement.servive;

import java.util.List;

import com.Attendance.AttendanceManagement.dto.StudentAttendanceResponseDto;
import com.Attendance.AttendanceManagement.model.Attendance;

public interface AttendanceService {

    Attendance markAttendance(Long rollNo, String status);

    StudentAttendanceResponseDto getStudentAttendance(Long rollNo);

    List<StudentAttendanceResponseDto> getAllStudentsAttendance();
}
