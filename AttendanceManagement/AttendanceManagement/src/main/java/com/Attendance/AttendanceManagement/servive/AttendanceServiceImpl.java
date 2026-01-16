package com.Attendance.AttendanceManagement.servive;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Attendance.AttendanceManagement.client.StudentClient;
import com.Attendance.AttendanceManagement.dto.AttendanceDTO;
import com.Attendance.AttendanceManagement.dto.AttendanceRecordDto;
import com.Attendance.AttendanceManagement.dto.StudentAttendanceResponseDto;
import com.Attendance.AttendanceManagement.dto.StudentResponseDto;
import com.Attendance.AttendanceManagement.entityEnum.StatusEnum;
import com.Attendance.AttendanceManagement.mapper.AttendanceMapper;
import com.Attendance.AttendanceManagement.model.Attendance;
import com.Attendance.AttendanceManagement.repository.AttendanceRepository;

import jakarta.transaction.Transactional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    @Transactional
    public AttendanceDTO markAttendance(Long rollNo) {

        studentClient.getStudent(rollNo);

        LocalDate today = LocalDate.now();

        Attendance attendance = attendanceRepository
                .findByRollNoAndDate(rollNo, today)
                .orElseGet(() -> {
                    Attendance a = new Attendance();
                    a.setRollNo(rollNo);
                    a.setDate(today);
                    a.setStatus(StatusEnum.ABSENT);
                    return a;
                });

        if (attendance.getStatus() == StatusEnum.ABSENT) {
            attendance.setStatus(StatusEnum.PRESENT);
        }

        Attendance saved = attendanceRepository.save(attendance);
        return AttendanceMapper.toDTO(saved);
    }

    @Override
    public StudentAttendanceResponseDto getStudentAttendance(Long rollNo) {

        StudentResponseDto student = studentClient.getStudent(rollNo);

        List<Attendance> list = attendanceRepository.findByRollNo(rollNo);

        List<AttendanceRecordDto> history = list.stream()
                .map(a -> {
                    AttendanceRecordDto dto = new AttendanceRecordDto();
                    dto.setAttendanceDate(a.getDate());
                    dto.setStatus(a.getStatus());
                    return dto;
                })
                .toList();

        StudentAttendanceResponseDto response = new StudentAttendanceResponseDto();

        response.setRollNo(student.getRollNo());
        response.setStudentName(student.getName());
        response.setClassName(student.getClassName());
        response.setAttendanceHistory(history);

        return response;
    }

    @Override
    public List<StudentAttendanceResponseDto> getAllStudentsAttendance() {
        List<StudentResponseDto> students = studentClient.getAllStudents();

        return students.stream()
                .map(s -> getStudentAttendance(s.getRollNo()))
                .toList();
    }

    @Override
    public AttendanceDTO updateAttendance(Long rollNo) {

        LocalDate today = LocalDate.now();

        Attendance attendance = attendanceRepository
                .findByRollNoAndDate(rollNo, today)
                .orElseThrow(() -> new RuntimeException("Attendance for today not found"));

        if (attendance.getStatus() == StatusEnum.PRESENT) {
            throw new IllegalStateException("Attendance already PRESENT");
        }

        attendance.setStatus(StatusEnum.PRESENT);

        Attendance updated = attendanceRepository.save(attendance);

        return AttendanceMapper.toDTO(updated);
    }

}
