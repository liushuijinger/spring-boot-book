package com.shuijing.boot.transaction.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuijing.boot.transaction.entity.User;
import com.shuijing.boot.transaction.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @since 2021-04-22
 */
@RestController
@RequestMapping("/user")
@Api(value = "User对象",tags = "用户信息")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "查询")
    @GetMapping(value = "/{id}")
    public User get(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping
    @ApiOperation("分页查询")
    public Page<User> list(@RequestParam(defaultValue = "1") Integer current,
                           @RequestParam(defaultValue = "10") Integer size) {
        return userService.page(new Page<>(current,size));
    }

    @ApiOperation(value = "新增")
    @PostMapping
    public Boolean add(@RequestBody User user) {
      return userService.save(user);
    }

    @ApiOperation(value = "修改")
    @PutMapping
    public Boolean modify(@RequestBody User user) {
      return userService.updateById(user);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping(value = "/{id}")
    public Boolean remove(@PathVariable Integer id) {
      return userService.removeById(id);
    }
}
