package com.example.job;

import com.example.service.OutService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Tony
 * @Date: 2020年06月19日 09:57
 **/
@Slf4j
public class OutJob implements Job {

    @Autowired
    OutService outService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("输出任务启动！");
        outService.execute();
        log.info("输出任务结束！");
    }
}
