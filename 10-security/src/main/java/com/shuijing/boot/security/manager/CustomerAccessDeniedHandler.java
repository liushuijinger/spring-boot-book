package com.shuijing.boot.security.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuijing.boot.security.common.Result;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-08-09
 */
@Component
public class CustomerAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {

        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

        if (isAjaxRequest(request)) {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(new ObjectMapper().writeValueAsString(Result.error("没有权限！")));
        } else {
            response.setContentType(MediaType.TEXT_HTML_VALUE);
            response.sendRedirect(request.getContextPath() + "/nopermission.html");
        }
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(requestType);
    }
}
