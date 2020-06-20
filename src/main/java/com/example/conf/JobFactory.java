package com.example.conf;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: Tony
 * @Date: 2020年06月19日 15:05
 **/
@Component
public class JobFactory extends AdaptableJobFactory {

    private AutowireCapableBeanFactory capableBeanFactory;

    /**
     * set方法注入
     *
     * @param capableBeanFactory
     */
    @Autowired
    public void setCapableBeanFactory(AutowireCapableBeanFactory capableBeanFactory) {
        this.capableBeanFactory = capableBeanFactory;
    }

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        //进行注入
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
