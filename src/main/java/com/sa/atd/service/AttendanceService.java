package com.sa.atd.service;

import com.sa.atd.repository.AttendanceRepository;
import com.sa.atd.repository.UserInfoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;
    public void clockIn(Long uid,String account, Date clockAd){
        attendanceRepository.save(uid, account, clockAd);
    }
}
