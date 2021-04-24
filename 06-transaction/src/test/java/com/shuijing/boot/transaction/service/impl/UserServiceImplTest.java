package com.shuijing.boot.transaction.service.impl;

import com.shuijing.boot.transaction.entity.User;
import com.shuijing.boot.transaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-04-24
 */
@Slf4j
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;


    // 都能插入
    @Test
    public void noTransaction_required_required() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequired(xiaoJing);
        throw new RuntimeException();
    }

    // 小水插入，小镜未插入
    @Test
    public void noTransaction_required_requiredException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequiredAndException(xiaoJing);
    }





    // 都未插入
    @Test
    @Transactional
    public void transaction_required_required() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequired(xiaoJing);
        throw new RuntimeException();
    }

    // 都未插入
    @Test
    @Transactional
    public void transaction_required_requiredException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequiredAndException(xiaoJing);
    }

    // 都未插入
    @Test
    @Transactional
    public void transaction_required_requiredException_try() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithRequired(xiaoShui);
        try {
            userService.addWithRequiredAndException(xiaoJing);
        } catch (Exception e) {
            log.error("发生异常，事务回滚！");
        }
    }




    // 小水未插入，小镜插入
    @Test
    @Transactional
    public void transaction_required_requiredNew() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequiredNew(xiaoJing);
        throw new RuntimeException();
    }

    // 小水未插入，小镜插入，水镜未插入
    @Test
    @Transactional
    public void transaction_required_requiredNew_requiredNewException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        User shuiJing = new User().setName("水镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequiredNew(xiaoJing);
        userService.addWithRequiredNewAndException(shuiJing);
    }

    // 小水未插入，小镜插入，水镜未插入
    @Test
    @Transactional
    public void transaction_required_requiredNewException_try() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        User shuiJing = new User().setName("水镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequiredNew(xiaoJing);
        try {
            userService.addWithRequiredNewAndException(shuiJing);
        } catch (Exception e) {
            log.error("发生异常，事务回滚！");
        }
    }




    // 都未插入
    @Test
    @Transactional
    public void transaction_nested_nested() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithNested(xiaoShui);
        userService.addWithNested(xiaoJing);
        throw new RuntimeException();
    }

    // 都未插入
    @Test
    @Transactional
    public void transaction_nested_nestedException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithNested(xiaoShui);
        userService.addWithNestedAndException(xiaoJing);
    }

    // 都未插入
    @Test
    @Transactional
    public void transaction_nested_nestedException_try() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        User shuiJing = new User().setName("水镜");
        userService.addWithRequired(shuiJing);
        userService.addWithNested(xiaoShui);
        try {
            userService.addWithNestedAndException(xiaoJing);
        } catch (Exception e) {
            log.error("发生异常，事务回滚！");
        }
    }
}