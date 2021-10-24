package com.shuijing.boot.mq.config;

import com.shuijing.boot.mq.manager.quartz.MyJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-10-07
 */
//@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(MyJob.class)
                        .withIdentity("myJobDetail", "myJobDetailGroup")
                        .storeDurably()
                        .build();
    }

    @Bean
    public Trigger myTrigger() {
        return TriggerBuilder.newTrigger()
                        .forJob(myJobDetail())
                        .withIdentity("myJobTrigger", "myJobTriggerGroup")
                        .startNow()
                        .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? "))
                        .build();
    }
}
