package com.Attendance.AttendanceManagement.mapper;

import com.Attendance.AttendanceManagement.dto.AttendanceDTO;
import com.Attendance.AttendanceManagement.model.Attendance;

public class AttendanceMapper {
    public static AttendanceDTO toDTO(Attendance attendance) {
        AttendanceDTO dto = new AttendanceDTO();
        dto.setRollNo(attendance.getRollNo());
        dto.setDate(attendance.getDate());
        dto.setStatus(attendance.getStatus());
        return dto;
    }
}
