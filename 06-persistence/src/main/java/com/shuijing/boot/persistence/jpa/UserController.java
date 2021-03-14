package com.shuijing.boot.persistence.jpa;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021/1/24
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userRepository.findById(id).get();
    }

    @ApiOperation(value = "根据名字获取用户信息")
    @GetMapping("/name")
    public List<User> getByName(String name) {
        return userRepository.findByNameContaining(name);
    }

    @ApiOperation(value = "根据生日获取用户信息")
    @GetMapping("/birthday")
    public List<User> getByBirthDay(String birthDay) {
        return userRepository.findByBirthDay(LocalDate.parse(birthDay));
    }

    @ApiOperation(value = "根据生日获取用户信息（native sql）")
    @GetMapping("/native/birthday")
    public List<User> getByBirthDayNative(String birthDay) {
        return userRepository.findByBirthDayNative(birthDay);
    }

    @ApiOperation(value = "获取用户列表")
    @GetMapping
    public Page<User> list(String property, @RequestParam(defaultValue = "asc") String direction,
                           @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(direction), property);

        return userRepository.findAll(pageable);
    }

//    @ApiOperation(value = "获取用户列表）支持模糊查询）")
//    @GetMapping("/page/{name}")
//    public Page<User> queryByName(@PathVariable String name, String direction, Integer page, Integer size) {
//
//        Pageable pageable = PageRequest.of(page, size);
//
//        return userRepository.findByNameContaining(name, pageable);
//    }

    @ApiOperation(value = "创建用户")
    @PostMapping
    @Transactional
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @ApiOperation(value = "删除所有用户")
    @DeleteMapping
    public int delete() {
        return userRepository.delete();
    }

}
