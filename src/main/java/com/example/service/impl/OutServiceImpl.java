package com.example.service.impl;

import com.example.service.OutService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Tony
 * @Date: 2020年06月19日 09:59
 **/
@Service
public class OutServiceImpl implements OutService {

    @Override
    public String execute() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("测试### " + date);
        return date;
    }
}
