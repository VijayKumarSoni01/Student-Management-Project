package com.Attendance.AttendanceManagement.servive;

import java.util.List;

import com.Attendance.AttendanceManagement.dto.AttendanceDTO;
import com.Attendance.AttendanceManagement.dto.StudentAttendanceResponseDto;

public interface AttendanceService {

    AttendanceDTO markAttendance(Long rollNo);

    StudentAttendanceResponseDto getStudentAttendance(Long rollNo);

    List<StudentAttendanceResponseDto> getAllStudentsAttendance();

   AttendanceDTO updateAttendance(Long rollNo);


}
