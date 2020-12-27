package com.shuijing.boot.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2020/12/19
 */
@Api
@RestController
@RequestMapping("/rest")
public class RestFulController {

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/user/{id}")
    public User get(@PathVariable @ApiParam("用户ID") int id) {
        // 演示代码，实际开发需要与数据库交互
        User user = new User();
        user.setId(id);
        user.setName("ID为"+id+"的用户");
        user.setAge(18);
        user.setEmail("shuijing@mail.com");
        return user;
    }

    @ApiOperation(value = "创建用户")
    @PostMapping("/user")
    public boolean create(@RequestBody User user) {
        // 演示代码，实际开发需要与数据库交互
        if (user != null) {
            return true;
        }
        return false;
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/user")
    public boolean update(@RequestBody User user) {
        // 演示代码，实际开发需要与数据库交互
        if (user != null) {
            return true;
        }
        return false;
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/user/{id}")
    public boolean delete(@PathVariable int id) {
        // 演示代码，实际开发需要与数据库交互
        if (id > 0) {
            return true;
        }
        return false;
    }
}