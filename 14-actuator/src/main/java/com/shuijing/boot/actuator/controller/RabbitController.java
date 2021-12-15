package com.shuijing.boot.actuator.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-10-31
 */
@Api
@Slf4j
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/")
    @ApiOperation("简单消息")
    public void send(String routingKey, String message) {
        rabbitTemplate.convertAndSend(routingKey, message);
    }

    @PostMapping("/work")
    @ApiOperation("Work 模式")
    public void sendWork(String routingKey, String message) {
        for (int i = 1; i <= 10; i++) {
            rabbitTemplate.convertAndSend(routingKey, "第 " + i + " 条消息：" + message);
        }
    }

    @PostMapping("/fanout")
    @ApiOperation("fanout 模式")
    public void sendFanout(String exchange, String message) {
        rabbitTemplate.convertAndSend(exchange, "", message);
    }

    @PostMapping("/direct")
    @ApiOperation("direct 模式")
    public void sendDirect(String exchange, String routingKey, String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
