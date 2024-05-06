package com.sa.atd.repository;

import com.sa.atd.model.dto.AttendanceDto;
import com.sa.atd.model.entity.RawAttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface RawAttendanceRepository extends JpaRepository<RawAttendanceRecord,Long> {

    @Transactional
    // 註記為資料異動
    @Modifying
    // 使用標準的SQL Insert語法來寫入資料，冒號+名稱來表示要帶入的參數
    @Query(value = "INSERT INTO soyal(uid, account, clockAtd)" +
            " VALUES (:uid, :account, :clockAtd);", nativeQuery = true)
    // 回傳Int表示新增的資料筆數，透過@Param("")來對應SQL語法裡面的參數
    public void save(@Param("uid") Long uid, @Param("account") String account, @Param("clockAtd") LocalDateTime clockAtd);


    @Query(value = "SELECT new com.sa.atd.model.dto.AttendanceDto(r.account, MIN(r.clockAtd), MAX(r.clockAtd)) " +
            "FROM RawAttendanceRecord r WHERE r.clockAtd BETWEEN ?1 AND ?2 " +
            "GROUP BY r.account")
    List<AttendanceDto> findDayAttendance(LocalDateTime timeStart, LocalDateTime timeEnd);

//    @Query("SELECT new com.sa.atd.model.dto.AttendanceDto(r.account, MIN(r.clockAtd), MAX(r.clockAtd)) " +
//            "FROM RawAttendanceRecord r WHERE dateTime BETWEEN MIN(r.clockAtd) AND MAX(r.clockAtd) and account = r.account")
//    AttendanceDto findPersonalDayAttendance(LocalDateTime timeStart, LocalDateTime timeEnd, String account);
}
