package com.shuijing.boot.jpa;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021/01/24
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(indexes = {@Index(name = "uk_email",columnList = "email",unique = true)})
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,columnDefinition = "varchar(20) comment '姓名'")
    private String name;

    @Transient
    private int age;

    @Column(nullable = false,length = 50)
    private String email;

    private LocalDate birthDay;

}