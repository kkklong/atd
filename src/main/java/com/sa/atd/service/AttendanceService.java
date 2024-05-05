package com.sa.atd.service;

import com.sa.atd.model.entity.AttendanceRecord;
import com.sa.atd.repository.AttendanceRecordDao;
import com.sa.atd.repository.RawAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    RawAttendanceRepository attendanceRepository;
    @Autowired
    private AttendanceRecordDao attendanceRecordDao;

    public void clockIn(Long uid,String account, Date clockAd){
        attendanceRepository.save(uid, account, clockAd);
    }

    public List<AttendanceRecord> findAllAttendance() {
        return attendanceRecordDao.findAll();
    }

    public List<AttendanceRecord> findAllAttendanceBetween(LocalDate begin, LocalDate end) {
        return attendanceRecordDao.findByMorningAtdBetween(begin.atTime(LocalTime.MIN), end.atTime(LocalTime.MAX));
    }

}
