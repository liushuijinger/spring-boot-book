package com.shuijing.boot.unittest.controller;

import com.shuijing.boot.unittest.entity.User;
import com.shuijing.boot.unittest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-05-16
 */
@Slf4j
@SpringBootTest
class UserControllerTest {

    MockMvc mockMvc;

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    @DisplayName("Test Controller get")
    void get() throws Exception {
        Mockito.when(userService.getById(1)).thenReturn(new User().setName("刘水镜").setEmail("liushuijing@mail.com"));
        BDDMockito.given(userService.getById(1)).willReturn(new User().setName("刘水镜").setEmail("liushuijing@mail.com"));
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1)
                .accept("application/json;charset=UTF-8")
                .contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("刘水镜"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("Test Controller get");
    }
}