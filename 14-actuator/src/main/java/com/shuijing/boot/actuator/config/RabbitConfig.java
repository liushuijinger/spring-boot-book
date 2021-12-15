package com.shuijing.boot.actuator.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-11-01
 */
@Configuration
public class RabbitConfig {

    @Bean
    public RabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);

        // MANUAL 手动确认
        // AUTO  消费完自动确认（Spring 确认）
        // NONE  消息分配后就确认（rabbitmq 确认）
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        // 拒绝策略,true 回到队列 false 丢弃，默认为 true
        factory.setDefaultRequeueRejected(true);
        // 默认的 PrefetchCount是 250
        factory.setPrefetchCount(0);
        return factory;
    }

}
