package com.shuijing.boot.unittest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuijing.boot.unittest.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @since 2021-04-22
 */
public interface UserService extends IService<User> {

    @Transactional(propagation = Propagation.REQUIRED)
    void addWithRequired(User user);

    @Transactional(propagation = Propagation.REQUIRED)
    void addWithRequiredAndException(User user);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void addWithRequiredNew(User user);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void addWithRequiredNewAndException(User user);

    @Transactional(propagation = Propagation.NESTED)
    void addWithNested(User user);

    @Transactional(propagation = Propagation.NESTED)
    void addWithNestedAndException(User user);
}
