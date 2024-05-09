package com.sa.atd.service;

import com.sa.atd.model.dto.AttendanceDto;
import com.sa.atd.model.entity.AttendanceRecord;
import com.sa.atd.repository.AttendanceRecordDao;
import com.sa.atd.repository.RawAttendanceRepository;
import com.sa.atd.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    RawAttendanceRepository rawattendanceRepository;
    @Autowired
    private AttendanceRecordDao attendanceRecordDao;

    public void clockIn(Long uid,String account, LocalDateTime clockAd){
        rawattendanceRepository.save(uid, account, clockAd);
    }

//    public List<AttendanceRecord> findAllAttendance() {
//        return attendanceRecordDao.findAll();
//    }
//    public List<AttendanceRecord> findAllAttendanceBetween(LocalDate begin, LocalDate end) {
//        return attendanceRecordDao.findByMorningAtdBetween(begin.atTime(LocalTime.MIN), end.atTime(LocalTime.MAX));
//    }

    public List<AttendanceDto> getAttendanceToday() {
        return rawattendanceRepository.findDayAttendance(DateUtil.getTodayStart(), DateUtil.getTodayEnd());
    }
    public Optional<AttendanceDto> getRawAttendanceByDateAndUser(LocalDateTime timeStart, LocalDateTime timeEnd, String account) {
        AttendanceDto dto = rawattendanceRepository.findPersonalDayAttendance(timeStart, timeEnd, account);
        if (dto.getAccount() == null) {
            return Optional.empty();
        } else {
            return Optional.of(dto);
        }
    }

}
