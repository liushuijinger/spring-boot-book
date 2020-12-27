package com.shuijing.boot.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2020/12/27
 */
@Api
@RestController
@RequestMapping("/resttemplate")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    @ApiOperation("")
    public User getForObject() {
        return restTemplate.getForObject("http://localhost:8080/rest/user/1", User.class);
    }

}
