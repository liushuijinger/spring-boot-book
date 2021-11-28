package com.shuijing.boot.es.manager.security;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.shuijing.boot.es.entity.SysUser;
import com.shuijing.boot.es.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-08-07
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
        if (sysUser == null) {
            throw new UsernameNotFoundException(username +" 不存在");
        }
        return User.builder().username(sysUser.getUsername()).password(sysUser.getPassword())
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList(sysUser.getRole())).build();
    }

}
