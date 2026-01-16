package com.Attendance.AttendanceManagement.dto;

import java.time.LocalDate;

import com.Attendance.AttendanceManagement.entityEnum.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceDTO {

    private Long rollNo;
    private LocalDate date;
    private StatusEnum status;
}
