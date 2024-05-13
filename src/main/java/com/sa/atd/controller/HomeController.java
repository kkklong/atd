package com.sa.atd.controller;


import com.sa.atd.repository.RawAttendanceRepository;
import com.sa.atd.service.AttendanceService;
import com.sa.atd.model.dto.AttendanceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.lang3.StringUtils;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
public class HomeController {

    private final RawAttendanceRepository rawAttendanceRepository;

    private final AttendanceService attendantService;

    @RequestMapping("/")
    public String index(@RequestParam(value = "queryDate", required = false)
                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                        @RequestParam(value = "queryDate2", required = false)
                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                        @RequestParam(value = "account", required = false) String account, Model model) {

        List<AttendanceDto> records = new ArrayList<>();
        LocalDate now = LocalDate.now();

        if (startDate == null) {
            startDate = now;
        }
        if (endDate == null) {
            endDate = now;
        }
        if (account == null) {
            account = "";
        }

        model.addAttribute("queryDate", startDate);
        model.addAttribute("queryDate2", endDate);
        model.addAttribute("username", account);

        if (StringUtils.isNotBlank(account)) {
            while (startDate.isBefore(endDate)) {
                Optional<AttendanceDto> optionalAttendanceDto = attendantService.getRawAttendanceByDateAndUser(startDate.atTime(LocalTime.MIN), startDate.atTime(LocalTime.MAX), account);
                if (optionalAttendanceDto.isPresent()) {
                    records.add(optionalAttendanceDto.get());
                }
                startDate = startDate.plusDays(1);
            }
            records.add(rawAttendanceRepository.findPersonalDayAttendance(endDate.atTime(LocalTime.MIN), endDate.atTime(LocalTime.MAX), account));
            //records.addAll(rawAttendanceRepository.findDayAttendance(endDate.atTime(LocalTime.MIN), endDate.atTime(LocalTime.MAX)));
        } else {
            while (startDate.isBefore(endDate)) {
                records.addAll(rawAttendanceRepository.findDayAttendance(startDate.atTime(LocalTime.MIN), startDate.atTime(LocalTime.MAX)));
                startDate = startDate.plusDays(1);
            }
            records.addAll(rawAttendanceRepository.findDayAttendance(endDate.atTime(LocalTime.MIN), endDate.atTime(LocalTime.MAX)));
        }

        model.addAttribute("records", records);
        return "index";
    }

}