package com.shuijing.boot.unittest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-05-23
 */
@Slf4j
public class IntroductionTests {

    @BeforeAll
    static void beforeAll() {
        log.info("===before all===");
    }

    @BeforeEach
    void setUp() {
        log.info("===before each===");
    }

    @Test
    @DisplayName("Test One")
    void testOne() {
        log.info("Test One");
    }

    @Test
    @DisplayName("Test Two")
    void testTwo() {
        log.info("Test Two");
    }

    @ParameterizedTest
    @ValueSource(strings = {"小刘", "小水", "小镜"})
    @DisplayName("Parameterized Test")
    void parameterizedTest(String name) {
        log.info(name);
    }

    @RepeatedTest(3)
    @DisplayName("Repeated Test")
    void testRepeated() {
        log.info("Repeated Test");
    }

    @Test
    @Disabled
    void disable() {
        log.info("disable");
    }

    @Test
    @Timeout(3)
    void timeout() throws InterruptedException {
        Thread.sleep(3000);
    }

    @AfterEach
    void tearDown() {
        log.info("===after each===");
    }

    @AfterAll
    static void afterAll() {
        log.info("===after all===");
    }
}
