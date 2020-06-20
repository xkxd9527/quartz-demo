package com.example.controller;

import com.example.service.OutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Tony
 * @Date: 2020年06月19日 10:04
 **/
@RestController
public class OutController {

    @Autowired
    OutService outService;

    @GetMapping("/out")
    public String out() {
        return outService.execute();
    }
}
