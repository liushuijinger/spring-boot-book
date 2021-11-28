package com.shuijing.boot.es;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@EnableScheduling
@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
@MapperScan("com.shuijing.boot.es.mapper")
public class ESApplication {

    public static void main(String[] args) {
        SpringApplication.run(ESApplication.class, args);
    }

}
