package com.shuijing.boot.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2020/11/29
 */
@RestController
public class ParamController {

    @GetMapping("/noannotation")
    public User noAnnotation(User user) {
        return user;
    }

    @GetMapping("/requestparam")
    public User requestParam(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @GetMapping("/pathvariable/{name}/{age}")
    public User pathVariable(@PathVariable String name, @PathVariable int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/requestbody")
    public User requestBody(@RequestBody @Valid User user) {
        return user;
    }

    @PostMapping("/post")
    public String h(String name) {
        return name;
    }
}
