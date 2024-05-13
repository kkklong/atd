package com.sa.atd.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendance_record")
@Getter
@Setter
public class AttendanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long uid;
    private String account;
    private LocalDateTime morningAtd;
    private LocalDateTime eveningAtd;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "atd_code")
//    private AtdCode atdCode;
}
