package com.sa.atd.repository;

import com.sa.atd.model.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    @Query(value = "SELECT account FROM atd.user_info WHERE uid=:uid", nativeQuery = true)
    String findAccountByUid(Long uid);
}
