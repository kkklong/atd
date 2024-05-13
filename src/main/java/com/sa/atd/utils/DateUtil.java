package com.sa.atd.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
    public static LocalDate convertDateToLocalDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    public static LocalDateTime convertStringToLocalDateTime(String timeStr){
        DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(timeStr, df);
    }

    public static LocalDateTime getTodayStart() {
        return LocalDate.now().atTime(LocalTime.MIN);
    }

    public static LocalDateTime getTodayEnd() {
        return LocalDate.now().atTime(LocalTime.MAX);
    }
}
