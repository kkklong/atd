package com.sa.atd.controller;

import com.sa.atd.model.entity.AttendanceRecord;
import com.sa.atd.service.AttendanceService;
import com.sa.atd.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/atd")
public class AttendanceController {
    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @Autowired
    UserService userService;
    @Autowired
    AttendanceService attendanceService;


    //打卡的部分
    @RequestMapping(value = "/clockin",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView clockin(@RequestParam("uid") Long uid)throws Exception{
        String account = userService.findAccountByUid(uid);
        attendanceService.clockIn(uid,account, LocalDateTime.now());
        ModelAndView model = new ModelAndView("index");
        return model;
    }
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String clock()
    {
        return "AttendanceEnter";
    }

    //查詢的部分
    @GetMapping(value = "/all")
    //@ApiOperation("取得除了當天以外的打卡紀錄(MANAGER)")
    public List<AttendanceRecord> findBetweenAtd(
           // @ApiParam(name = "begin", value = "開始日期(yyyy-mm-dd)", required = false)
            @RequestParam(value = "begin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate begin,
           // @ApiParam(name = "end", value = "結束日期(yyyy-mm-dd)", required = false)
            @RequestParam(value = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

        if (begin != null && end != null) {
            return attendanceService.findAllAttendanceBetween(begin, end);
        } else {
            return attendanceService.findAllAttendance();
        }
    }


}
