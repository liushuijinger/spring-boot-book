package com.shuijing.boot.mq.manager.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-10-31
 */
@Slf4j
@Component
public class DirectConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            key = {"liushuijing", "shuijing"},
            exchange = @Exchange(name = "direct", type = "direct")
    ))
    public void receiveOne(String message) {
        log.info("key: liushuijing、shuijing message: {}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            key = {"liushuijing"},
            exchange = @Exchange(name = "direct", type = "direct")
    ))
    public void receiveTwo(String message) {
        log.info("key: liushuijing message: {}", message);
    }

}
