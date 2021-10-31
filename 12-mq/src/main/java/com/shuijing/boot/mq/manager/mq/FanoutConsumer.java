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
public class FanoutConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "fanout", type = "fanout")
    ))
    public void receiveOne(String message) {
        log.info("receiveOne {}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "fanout", type = "fanout")
    ))
    public void receiveTwo(String message) {
        log.info("receiveTwo {}", message);
    }

}
