package com.Attendance.AttendanceManagement.servive;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Attendance.AttendanceManagement.client.StudentClient;
import com.Attendance.AttendanceManagement.dto.AttendanceRecordDto;
import com.Attendance.AttendanceManagement.dto.StudentAttendanceResponseDto;
import com.Attendance.AttendanceManagement.dto.StudentResponseDto;
import com.Attendance.AttendanceManagement.entityEnum.StatusEnum;
import com.Attendance.AttendanceManagement.model.Attendance;
import com.Attendance.AttendanceManagement.repository.AttendanceRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public Attendance markAttendance(Long rollNo, String status) {

        // validate student from StudentManagement
        studentClient.getStudent(rollNo);

        Attendance attendance = new Attendance();
        attendance.setRollNo(rollNo);
        attendance.setDate(LocalDate.now());
        attendance.setStatus(StatusEnum.valueOf(status.toUpperCase()));

        return attendanceRepository.save(attendance);
    }

    @Override
    public StudentAttendanceResponseDto getStudentAttendance(Long rollNo) {

        StudentResponseDto student = studentClient.getStudent(rollNo);

        List<Attendance> list =
                attendanceRepository.findByRollNo(rollNo);

        List<AttendanceRecordDto> history = list.stream()
                .map(a -> {
                    AttendanceRecordDto dto = new AttendanceRecordDto();
                    dto.setAttendanceDate(a.getDate());
                    dto.setStatus(a.getStatus());
                    return dto;
                })
                .toList();

        StudentAttendanceResponseDto response =
                new StudentAttendanceResponseDto();

        response.setRollNo(student.getRollNo());
        response.setStudentName(student.getName());
        response.setClassName(student.getClassName());
        response.setAttendanceHistory(history);

        return response;
    }
}
