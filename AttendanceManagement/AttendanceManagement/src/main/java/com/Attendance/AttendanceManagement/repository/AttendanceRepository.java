package com.Attendance.AttendanceManagement.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Attendance.AttendanceManagement.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByRollNo(Long rollNo);

    Optional<Attendance> findByRollNoAndDate(Long rollNo, LocalDate date);
}

