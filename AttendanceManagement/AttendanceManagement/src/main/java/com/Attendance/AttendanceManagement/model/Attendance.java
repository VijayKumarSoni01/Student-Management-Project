package com.Attendance.AttendanceManagement.model;

import java.time.LocalDate;

import com.Attendance.AttendanceManagement.entityEnum.StatusEnum;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long rollNo;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}


