package com.shuijing.boot.redis.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @GetMapping("/debug")
    public void debug() {
        log.debug("log level debug");
    }

    @GetMapping("/info")
    public void info() {
        log.info("log level info");
    }

    @GetMapping("/warn")
    public void warn() {
        log.warn("log level warn");
    }

    @GetMapping("/error")
    public void error() {
        log.error("log level error");
    }
}