package com.sa.atd.repository;


import com.sa.atd.model.entity.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceRecordDao extends JpaRepository<AttendanceRecord, Long> {

    List<AttendanceRecord> findByMorningAtdBetween(LocalDateTime timeStart, LocalDateTime timeEnd);
//
//    Long deleteByMorningAtdBetween(LocalDateTime timeStart, LocalDateTime timeEnd);
//
//    List<AttendanceRecord> findByUsernameAndMorningAtdBetween(String username, LocalDateTime timeStart, LocalDateTime timeEnd);
//
//    Long countByUsernameAndAtdCodeAndMorningAtdBetween(String username, AtdCode atdCode, LocalDateTime timeStart, LocalDateTime timeEnd);
//
//    boolean existsByMorningAtdBetween(LocalDateTime timeStart, LocalDateTime timeEnd);
}
