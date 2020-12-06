package com.shuijing.boot.mvc;


import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2020/11/29
 */
@Data
public class User {
    @NotBlank(message = "名字不能为空")
    private String name;

    @Min( value = 1,message = "年龄要不能小于 1")
    @Max( value = 120,message = "年龄要不能大于 120")
    private int age;

    @Email(message = "Email格式不正确")
    private String email;

    @Past(message = "生日必须为过去的时间")
    private LocalDate birthDay;
}