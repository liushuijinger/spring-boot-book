package com.shuijing.boot.security.service;

import com.shuijing.boot.security.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @since 2021-08-15
 */
public interface SysUserService extends IService<SysUser> {

    String getCurrentUser();
}
