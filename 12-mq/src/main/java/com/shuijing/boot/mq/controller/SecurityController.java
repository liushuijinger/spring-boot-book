package com.shuijing.boot.mq.controller;

import com.shuijing.boot.mq.common.Result;
import com.shuijing.boot.mq.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @since 2021-08-15
 */
@Slf4j
@RestController
@RequestMapping("/security")
@Api(value = "权限控制",tags = "权限控制")
public class SecurityController {

    @Autowired
    private SysUserService sysUserService;

    // 任何人都可以访问
    @ApiOperation(value = "permitAll 权限")
    @GetMapping(value = "/permitall")
    public Result<String> permitAll() {
        return Result.success("permitAll");
    }

    // 未登录时 可以访问
    @ApiOperation(value = "anonymous 权限")
    @GetMapping(value = "/anonymous")
    public Result<String> anonymous() {
        return Result.success("anonymous");
    }

    // xiaoshui 可以访问
    @ApiOperation(value = "config 权限")
    @GetMapping(value = "/config")
    public Result<String> config() {
      return Result.success("config");
    }

    // xiaojing 可以访问
    @ApiOperation(value = "Secured 权限")
    @GetMapping(value = "/secured")
    @Secured({"ROLE_Secured"})
    public Result<String> secured() {
      return Result.success("Secured");
    }

    // liushuijing 可以访问
    @ApiOperation(value = "PreAuthorize 权限")
    @GetMapping(value = "/preAuthorize")
    @PreAuthorize("hasAnyAuthority('PreAuthorize')")
    public Result<String> preAuthorize() {
      return Result.success("PreAuthorize");
    }

    @ApiOperation(value = "获取当前用户-Principal")
    @GetMapping(value = "/current-user-principal")
    public Result<String> getCurrentUserPrincipal(Principal principal) {
        String userName = principal.getName();
        log.info("userName by Principal: {}", userName);
        return Result.success(userName);
    }

    @ApiOperation(value = "获取当前用户-Authentication")
    @GetMapping(value = "/current-user-authentication")
    public Result<String> getCurrentUserAuthentication(Authentication authentication) {
        String userName = authentication.getName();
        log.info("userName by Authentication: {}", userName);
        return Result.success(userName);
    }

    @ApiOperation(value = "获取当前用户-HttpServletRequest")
    @GetMapping(value = "/current-user-httpServletRequest")
    public Result<String> getCurrentUserHttpServletRequest(HttpServletRequest httpServletRequest) {
        String userName = httpServletRequest.getUserPrincipal().getName();
        log.info("userName by HttpServletRequest: {}", userName);
        return Result.success(userName);
    }

    @ApiOperation(value = "获取当前用户-@AuthenticationPrincipal")
    @GetMapping(value = "/current-user-authenticationPrincipal")
    public Result<String> getCurrentUserAuthenticationPrincipal(@AuthenticationPrincipal UserDetails user) {
        String userName = user.getUsername();
        log.info("userName by @AuthenticationPrincipal: {}", userName);
        return Result.success(userName);
    }

    @ApiOperation(value = "获取当前用户-SecurityContextHolder")
    @GetMapping(value = "/current-user-securityContextHolder")
    public Result<String> getCurrentUserSecurityContextHolder() {
        String userName = sysUserService.getCurrentUser();
        log.info("userName by SecurityContextHolder: {}", userName);
        return Result.success(userName);
    }
}
