package com.sa.atd.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendanceDto {

//    private Long uid;
    private String account;
    private LocalDateTime morningAtd;
    private LocalDateTime eveningAtd;
}
