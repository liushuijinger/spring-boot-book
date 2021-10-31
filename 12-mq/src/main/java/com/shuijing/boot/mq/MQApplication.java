package com.shuijing.boot.mq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@EnableScheduling
@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
@MapperScan("com.shuijing.boot.mq.mapper")
public class MQApplication {

    public static void main(String[] args) {
        SpringApplication.run(MQApplication.class, args);
    }

}
