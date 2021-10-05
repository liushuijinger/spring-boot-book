package com.shuijing.boot.security.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuijing.boot.security.common.Result;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
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
public class CustomerAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws
                    IOException {

        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        if (isAjaxRequest(request)) {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(new ObjectMapper().writeValueAsString(Result.error("请登录！")));
        } else {
            response.setContentType(MediaType.TEXT_HTML_VALUE);
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(requestType);
    }
}
