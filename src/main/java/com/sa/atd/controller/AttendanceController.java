package com.sa.atd.controller;

import com.sa.atd.service.AttendanceService;
import com.sa.atd.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/atd")
public class AttendanceController {
    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @Autowired
    UserService userService;
    @Autowired
    AttendanceService attendanceService;

    @RequestMapping(value = "/clockin",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView clockin(@RequestParam("uid") Long uid)throws Exception{
        String account = userService.findAccountByUid(uid);
        attendanceService.clockIn(uid,account, new Date());
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String clock()
    {
        return "AttendanceEnter";
    }


}
