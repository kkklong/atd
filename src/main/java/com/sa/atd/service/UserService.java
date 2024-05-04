package com.sa.atd.service;

import com.sa.atd.model.entity.UserInfo;
import com.sa.atd.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resources;

@Service
public class UserService {
    @Autowired
    UserInfoRepository userInfoRepository;
    public String findAccountByUid(Long uid){
        return userInfoRepository.findAccountByUid(uid);
    }
}
