package com.shuijing.boot.mbp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.shuijing.boot.mbp.entity.User;
import com.shuijing.boot.mbp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021/3/28
 */
@SpringBootTest
public class UserServiceImplTests {

    @Autowired
    private UserService service;

    @Test
    public void queryWrapper() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
////        wrapper.eq("name", "刘水镜");
//        wrapper.ge(User::getBirthDay, LocalDate.parse("2011-01-01"));
//        wrapper.between(User::getBirthDay, LocalDate.parse("2011-01-01"), LocalDate.parse("2011-12-31"));
//
//        wrapper.like(User::getName, "刘");
        List<String> nameList = Arrays.asList("小刘", "小水", "小镜");
        nameList = new ArrayList<>();

//        wrapper.in(CollectionUtils.isNotEmpty(nameList),User::getName, nameList);
        wrapper.in(User::getName, nameList);
//        wrapper.select("name, count(*)").groupBy(User::getName);

//        wrapper.orderByDesc(User::getId);
        service.list(wrapper);

        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(User::getBirthDay, LocalDate.parse("2012-01-01")).eq(User::getName, "刘水镜");
//        service.update(updateWrapper);
    }
}
