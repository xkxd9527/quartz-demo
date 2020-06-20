package com.example.controller;

import com.example.job.HelloJob;
import com.example.job.OutJob;
import com.example.service.IQuartzService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Tony
 * @Date: 2020年06月19日 16:00
 **/
@RestController
public class QuartzController {
    @Resource
    private IQuartzService quartzService;


    @GetMapping("/01")
    public String startNNoQuartz01() {
        quartzService.startJob("0/10 * * * * ? ", "job1", "group1", OutJob.class);
        return "定时器任务开始执行，请注意观察控制台";
    }

    @GetMapping("quartzStart")
    public String startNNoQuartz() {
        quartzService.startJob("0 23 10 * * ? ", "job1", "group1", HelloJob.class);
        return "定时器任务开始执行，请注意观察控制台";
    }

    @GetMapping("pauseJob")
    public String pauseJob() {
        quartzService.pauseJob("job1", "group1");
        return "暂停一个定时器任务，请注意观察控制台";
    }

    @GetMapping("resumeJob")
    public String resumeJob() {
        //shutdown关闭了，或者删除了就不能重启了
        quartzService.resumeJob("job1", "group1");
        return "暂停重启一个定时器任务，请注意观察控制台";
    }

    @GetMapping("deleteJob")
    public String deleteJob() {
        quartzService.deleteJob("job1", "group1");
        return "删除一个定时器任务，请注意观察控制台，删除了，重启就没什么用了";
    }

    @GetMapping("doJob")
    public String doJob() {
        quartzService.doJob("job1", "group1");
        return "根据出发规则匹配任务，立即执行定时任务，暂停的时候可以用";
    }

    @GetMapping("startAllJob")
    public String startAllJob() {
        quartzService.startAllJob();
        return "开启定时器，这时才可以开始所有的任务，默认是开启的";
    }

    @GetMapping("shutdown")
    public String shutDown() {
        quartzService.shutDown();
        return "关闭定时器，则所有任务不能执行和创建";
    }

}
