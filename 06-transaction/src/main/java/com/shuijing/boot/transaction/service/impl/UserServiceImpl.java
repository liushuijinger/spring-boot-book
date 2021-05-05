package com.shuijing.boot.transaction.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuijing.boot.transaction.entity.User;
import com.shuijing.boot.transaction.mapper.UserMapper;
import com.shuijing.boot.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @since 2021-04-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper mapper;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addWithRequired(User user) {
        mapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addWithRequiredAndException(User user) {
        mapper.insert(user);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addWithRequiredNew(User user) {
        mapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addWithRequiredNewAndException(User user) {
        mapper.insert(user);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addWithNested(User user) {
        mapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addWithNestedAndException(User user) {
        mapper.insert(user);
        throw new RuntimeException();
    }
}
