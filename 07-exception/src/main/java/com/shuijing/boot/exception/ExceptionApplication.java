package com.shuijing.boot.exception;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shuijing.boot.exception.mapper")
public class ExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionApplication.class, args);
    }

}
