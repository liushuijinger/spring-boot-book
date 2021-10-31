package com.shuijing.boot.mq.manager.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-10-24
 */
@SpringBootTest
class MQSenderTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void send() {
        rabbitTemplate.convertAndSend("boot-exchange", "boot.mq", "hello");
    }
}