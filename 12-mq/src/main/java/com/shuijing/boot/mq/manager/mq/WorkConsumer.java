package com.shuijing.boot.mq.manager.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-10-31
 */
@Slf4j
@Component
public class WorkConsumer {

    @RabbitListener(containerFactory = "rabbitListenerContainerFactory", queuesToDeclare = @Queue("work"))
//    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiveOne(String message) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("{} 被 receiveOne 消费", message);
    }


    @RabbitListener(containerFactory = "rabbitListenerContainerFactory", queuesToDeclare = @Queue("work"))
//    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiveTwo(String message) {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("{} 被 receiveTwo 消费", message);
    }

}
