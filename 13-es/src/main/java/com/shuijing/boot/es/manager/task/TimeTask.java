package com.shuijing.boot.es.manager.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-10-07
 */

@Slf4j
//@Component
public class TimeTask {

    private int[] people = {6, 2, 3, 1};

    private int count = 0;

    @Scheduled(fixedDelay = 5000)
    public void fixedDelayTask() throws InterruptedException {
        if (count < 4) {
            int timeConsuming = people[count];
            log.info("fixedDelayTask-----第 {} 个人在 {} 开始如厕，耗时：{} 秒", count + 1,
                    formatTime(),
                    timeConsuming);
            Thread.sleep(timeConsuming * 1000L);
            count++;
        }
    }

    @Scheduled(cron = "0/5 * * * * ? ")
    public void cronTask() throws InterruptedException {
        if (count < 4) {
            int timeConsuming = people[count];
            log.info("cronTask-----第 {} 个人在 {} 开始如厕，耗时：{} 秒", count + 1,
                    formatTime(),
                    timeConsuming);
            Thread.sleep(timeConsuming * 1000L);
            count++;
        }
    }

    @Scheduled(fixedRate = 5000)
    public void fixedRateTask() throws InterruptedException {
        if (count < 4) {
            int timeConsuming = people[count];
            log.info("fixedRateTask-----第 {} 个人在 {} 开始如厕，耗时：{} 秒", count + 1,
                    formatTime(),
                    timeConsuming);
            Thread.sleep(timeConsuming * 1000L);
            count++;
        }
    }

    private String formatTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
