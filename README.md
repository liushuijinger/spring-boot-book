# 《Spring Boot 趣味实战课》随书源码

## 软件环境
[![Language](https://img.shields.io/badge/Language-Java_8-007396?color=orange&logo=java)](https://github.com/liushuijinger/spring-boot-book)
[![Framework](https://img.shields.io/badge/Framework-Spring_Boot_2.4.0-6DB33F?logo=spring)](https://github.com/liushuijinger/spring-boot-book)
[![DataBase](https://img.shields.io/badge/DataBase-MySQL-4479A1?logo=MySQL)](https://github.com/liushuijinger/spring-boot-book)
[![Druid](https://img.shields.io/badge/Pool-Druid-29F1FB?logo=Apache-Druid)](https://github.com/liushuijinger/spring-boot-book)
[![API](https://img.shields.io/badge/API-Swagger_2.8.0-85EA2D?logo=swagger)](https://github.com/liushuijinger/spring-boot-book)


## 技术交流
[![QQ群](https://img.shields.io/badge/QQ群-168965372-20B8E5?logo=Tencent-QQ&style=flat)](https://jq.qq.com/?_wv=1027&k=0UCkec2u)
[![博客](https://img.shields.io/badge/博客-我的博客-21759B?style=flat)](https://liushuijinger.blog.csdn.net)
[![微博](https://img.shields.io/badge/微博-@水镜不酷-E6162D?logo=Sina-Weibo&lstyle=flat)](https://weibo.com/liushuijinger)
[![公众号](https://img.shields.io/badge/公众号-做个开发者-07C160?logo=WeChat&lstyle=flat)](https://mp.weixin.qq.com/s/7Q9vb5R7chugkQ39kH6wqw)


<div align=center>
    <a href="https://item.jd.com/13724304.html">
        <img src="https://github.com/liushuijinger/spring-boot-book/blob/master/static/%E5%B0%81%E9%9D%A2.jpg?raw=true" >
    </a>
</div>
<p align="center">
    <a href="https://item.jd.com/13724304.html">京东</a>
    <a href="http://product.dangdang.com/29397296.html">当当</a>
    <a href="https://detail.tmall.com/item.htm?id=673648646503">天猫</a>
</p>

## 内容简介

计算机里的世界是现实世界的映射，或者是基于现实世界的演化。技术都是为了解决生活中的问题而诞生的，可以说一切技术都来源于生活。因此，学好技术要从生活入手。本书始终秉持着「技术来源于生活，更要归于生活」的理念，让书中每一项技术都有生活中原型与之对应。用非常接地气的方式让读者更容易理解书中所讲述的技术。

本书内容极其丰富， 不仅涵盖了 Spring MVC、MyBatis Plus、Spring Data JPA、Spring Security、Quartz 等主流框架，整合了 MySQL、 Druid、 Redis、 RabbitMQ、 Elasticsearch 等互联网常用技术与中间件，还涉及单元测试、异常处理、日志、 Swagger 等技术细节，以及 AOP、 IOC、自动配置、数据库事务、分布式锁等硬核知识。本书从初始化到部署、监控，实现了软件全生命周期一站式打包解决。

本书行文风格深入浅出、 通俗易懂、 风趣幽默、 轻松愉快。 从 Hello World 聊到源码分析，从工具使用讲到内部原理，从日常生活说到设计哲学。同时，本书的内容设计由易到难，图文并茂，再加上丰富的实例，可以让初级人员非常轻松地入门。同时，作者对技术独树一帜的理解还可以让中、高级的技术人员受到很多启发。所以，本书堪称“老少皆宜，居家、旅行必备良品” 。《 Spring Boot 趣味实战课》你值得拥有！

### 本书结构

本书宏观上可以分为三个部分，

- 1-3 章是热身，主要用来让小白能够掌握一些必要的前置知识
- 4-8 章是基础实战，包括 Spring Boot 最基本的使用，以及其内部原理
- 9-14 章是高级用法，主要是 Spring Boot 与其他各种组件配合使用，完成更加复杂的功能。

> 本书各章节之间没有什么严格的先后关系，可以根据自己的兴趣安排阅读顺序。但如果你是小白的话，推荐你从头往后阅读。



### 章节介绍

第一章 是对 Spring Boot 的宏观介绍，主要介绍了 Spring Boot 的现状，以及其简单易用的特点和约定优于配置的设计哲学。

第二章 是一些准备工作，包括对 Maven 的介绍；IDEA 的常用设置及使用技巧，并推荐了一些好用的插件。

第三章 通过一个 HelloWorld 实例引出了 Spring Boot 的工程结构，并对 Starters 和 YAML 进行了详细的讲解。

第四章 主要是对 Spring MVC 的讲解，详细的阐述了 Spring MVC 的各种用法。并对其原理以及源码进行了分析。

第五章 主要是对 HTTP 和 RESTFul 的讲解，每个程序员都该懂一点 HTTP，顺带把 Swagger 的使用进行细致的讲解。

第六章 实战阶段的重头戏，持久化相关的内容都在这里了。MyBatis、Spring Data JPA、Druid、事务隔离级别及传播特性等，内容较多慢慢看。

第七章 包含三方面内容：单元测试、异常处理和日志，这三驾马车可以为你的系统保驾护航，快速定位问题。

第八章 IOC、AOP、自动配置、启动流程，Spring Boot 的核心都在这里了。大量源码分析，掰开揉碎给你整明白。

第九章 Redis 登场，介绍了 Redis 整合 Spring Boot 的各种实战，以及如何使用 Redis 实现分布式锁。

第十章 主要讲解了 Spring Security 的整合、认证和授权，为系统安全提供保障。

第十一章 ，分别用 Spring Task 和 Quartz 做了实例，讲解定时任务三种调度策略。

第十二章 介绍了 RabbitMQ，讲解了它的五种主要工作模式，讨论了 MQ 适用的业务场景。

第十三章 讲解了 Elasticsearch 的核心概念，以及基本用法，阐述了倒排索引的原理。

第十四章 介绍了 Spring Boot 的监控组件 Actuator，并演示了如何与 Spring Boot Admin 整合使用。

第十五章 分享了一些作者多年来关于技术学习的心得。

<div align=center>
<img src="https://github.com/liushuijinger/spring-boot-book/blob/master/static/%E5%85%AC%E4%BC%97%E5%8F%B7.jpg?raw=true">
</div>

