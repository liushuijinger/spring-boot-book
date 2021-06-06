package com.shuijing.boot.exception.service.impl;

import com.shuijing.boot.exception.entity.User;
import com.shuijing.boot.exception.mapper.UserMapper;
import com.shuijing.boot.exception.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @since 2021-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
