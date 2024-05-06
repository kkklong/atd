package com.sa.atd.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "soyal")
@Data
public class RawAttendanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private Long uid;
    private LocalDateTime clockAtd;

}
