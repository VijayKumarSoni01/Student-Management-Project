package com.Attendance.AttendanceManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Attendance.AttendanceManagement.dto.BulkAttendanceRequestDto;
import com.Attendance.AttendanceManagement.dto.StudentAttendanceResponseDto;
import com.Attendance.AttendanceManagement.model.Attendance;
import com.Attendance.AttendanceManagement.servive.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/{rollNo}")
    public Attendance markAttendance(
            @PathVariable Long rollNo,
            @RequestParam String status) {

        return attendanceService.markAttendance(rollNo, status);
    }

    @GetMapping("/student/{rollNo}")
    public ResponseEntity<StudentAttendanceResponseDto> getStudentAttendance(@PathVariable Long rollNo) {

        return ResponseEntity.ok(
                attendanceService.getStudentAttendance(rollNo));
    }

    @PostMapping("/allStudents")
    public void markBulkAttendance(
            @RequestBody List<BulkAttendanceRequestDto> requests) {

        requests.forEach(req -> attendanceService.markAttendance(
                req.getRollNo(),
                req.getStatus()));
    }

}
