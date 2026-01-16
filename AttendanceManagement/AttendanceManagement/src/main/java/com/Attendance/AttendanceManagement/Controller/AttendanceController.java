package com.Attendance.AttendanceManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Attendance.AttendanceManagement.dto.AttendanceDTO;
import com.Attendance.AttendanceManagement.dto.BulkAttendanceRequestDto;
import com.Attendance.AttendanceManagement.dto.StudentAttendanceResponseDto;
import com.Attendance.AttendanceManagement.servive.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/{rollNo}")
    public AttendanceDTO markAttendance(@PathVariable Long rollNo) {
        return attendanceService.markAttendance(rollNo);
    }

    @PostMapping("/allStudents")
    public void markBulkAttendance(
            @RequestBody List<BulkAttendanceRequestDto> requests) {

        requests.forEach(req -> attendanceService.markAttendance(
                req.getRollNo()));
    }

    @PatchMapping("/{rollNo}")
    public AttendanceDTO updateAttendance(@PathVariable Long rollNo) {
        return attendanceService.updateAttendance(rollNo);
    }

    @GetMapping("/student/{rollNo}")
    public ResponseEntity<StudentAttendanceResponseDto> getStudentAttendance(@PathVariable Long rollNo) {

        return ResponseEntity.ok(
                attendanceService.getStudentAttendance(rollNo));
    }

    @GetMapping("/allStudents")
    public ResponseEntity<List<StudentAttendanceResponseDto>> getAllStudentsAttendance() {

        return ResponseEntity.ok(
                attendanceService.getAllStudentsAttendance());
    }

}
