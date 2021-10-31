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
public class TopicConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            key = {"liu.shui.jing"},
            exchange = @Exchange(name = "topic", type = "topic")
    ))
    public void receiveOne(String message) {
        log.info("key: liu.shui.jing message：{}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            key = {"liu.shui.*"},
            exchange = @Exchange(name = "topic", type = "topic")
    ))
    public void receiveTwo(String message) {
        log.info("key: liu.shui.* message：{}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            key = {"liu.shui.#"},
            exchange = @Exchange(name = "topic", type = "topic")
    ))
    public void receiveThree(String message) {
        log.info("key: liu.shui.# message：{}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            key = {"liu.#"},
            exchange = @Exchange(name = "topic", type = "topic")
    ))
    public void receiveFour(String message) {
        log.info("key: liu.# message：{}", message);
    }

}
