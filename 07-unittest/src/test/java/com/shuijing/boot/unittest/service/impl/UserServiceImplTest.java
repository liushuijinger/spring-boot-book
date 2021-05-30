package com.shuijing.boot.unittest.service.impl;

import com.shuijing.boot.unittest.entity.User;
import com.shuijing.boot.unittest.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-05-16
 */
@SpringBootTest
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserMapper userMapper;

    @Test
    @DisplayName("Test Service getById")
    void getById() {
        Mockito.when(userMapper.selectById(1)).thenReturn(new User().setName("刘水镜").setEmail("liushuijing@mail.com"));
        User user = userService.getById(1);
        Assertions.assertEquals("刘水镜", user.getName());
    }
}