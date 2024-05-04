package com.sa.atd.repository;

import com.sa.atd.model.entity.AttendanceRecord;
import com.sa.atd.model.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceRecord,Long> {

    @Transactional
    // 註記為資料異動
    @Modifying
    // 使用標準的SQL Insert語法來寫入資料，冒號+名稱來表示要帶入的參數
    @Query(value = "INSERT INTO attendance_record(uid, account, clockAtd)" +
            " VALUES (:uid, :account, :clockAtd);", nativeQuery = true)
    // 回傳Int表示新增的資料筆數，透過@Param("")來對應SQL語法裡面的參數
    public void save(@Param("uid") Long uid, @Param("account") String account, @Param("clockAtd") Date clockAtd);
}
