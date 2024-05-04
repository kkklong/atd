package com.sa.atd.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "user_info")
@Data
@ToString
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    @NonNull
    private int rid;
    private String nickName;
    @NonNull
    @Column(unique = true)
    private String account;
    @NonNull
    @JsonIgnore
    private String password;
    private LocalDate entryDate;
    @JsonIgnore
    private String mobileToken;
    @NonNull
    private Boolean notifyEnabled;
    private String email;
}
