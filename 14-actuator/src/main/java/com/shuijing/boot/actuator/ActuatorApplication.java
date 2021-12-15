package com.shuijing.boot.actuator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@EnableScheduling
@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
@MapperScan("com.shuijing.boot.actuator.mapper")
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }

}
