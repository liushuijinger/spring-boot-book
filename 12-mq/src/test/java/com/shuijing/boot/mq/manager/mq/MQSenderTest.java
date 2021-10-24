package com.shuijing.boot.mq.manager.mq;

import org.junit.jupiter.api.Test;
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
    private MQSender mqSender;

    @Test
    void send() {
        mqSender.send();
    }
}