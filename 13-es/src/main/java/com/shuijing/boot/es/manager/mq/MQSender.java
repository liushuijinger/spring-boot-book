package com.shuijing.boot.es.manager.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-10-24
 */
@Component
public class MQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send() {
        rabbitTemplate.convertAndSend("boot-exchange", "boot.mq", "hello");
    }
}
