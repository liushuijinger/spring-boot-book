package com.shuijing.boot.es.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuijing.boot.es.entity.User;
import com.shuijing.boot.es.mapper.UserMapper;
import com.shuijing.boot.es.service.UserService;
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
