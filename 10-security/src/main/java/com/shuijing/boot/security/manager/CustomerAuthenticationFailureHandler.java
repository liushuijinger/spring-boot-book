package com.shuijing.boot.security.manager;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuijing.boot.security.common.Result;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author liushuijing (shuijing@shanshu.ai)
 * @date 2021-08-09
 */
@Component
public class CustomerAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws
                    IOException {
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Result<Object> result = Result.error();
        if (e instanceof UsernameNotFoundException) {
            result = Result.error("用户不存在！");
        } else if (e instanceof BadCredentialsException) {
            result = Result.error("密码错误！");
        }
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }

}
