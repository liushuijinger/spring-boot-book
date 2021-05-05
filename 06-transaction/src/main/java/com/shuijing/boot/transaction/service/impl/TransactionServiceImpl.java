package com.shuijing.boot.transaction.service.impl;

import com.shuijing.boot.transaction.entity.User;
import com.shuijing.boot.transaction.service.TransactionService;
import com.shuijing.boot.transaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-05-04
 */
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserService userService;

    @Override
    public void clean() {
        userService.remove(null);
    }

    @Override
    public void noTransaction_required_required_externalException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequired(xiaoJing);
        throw new RuntimeException();
    }

    @Override
    public void noTransaction_required_requiredException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequiredAndException(xiaoJing);
    }

    @Override
    @Transactional
    public void transaction_required_required_externalException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequired(xiaoJing);
        throw new RuntimeException();
    }

    @Override
    @Transactional
    public void transaction_required_requiredException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequiredAndException(xiaoJing);
    }


    @Override
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

    @Override
    @Transactional
    public void transaction_required_requiredNew_externalException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequiredNew(xiaoJing);
        throw new RuntimeException();
    }

    @Override
    @Transactional
    public void transaction_required_requiredNew_requiredNewException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        User shuiJing = new User().setName("水镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithRequiredNew(xiaoJing);
        userService.addWithRequiredNewAndException(shuiJing);
    }

    @Override
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

    @Override
    @Transactional
    public void transaction_nested_nested_externalException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithNested(xiaoShui);
        userService.addWithNested(xiaoJing);
        throw new RuntimeException();
    }

    @Override
    @Transactional
    public void transaction_nested_nestedException() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        userService.addWithNested(xiaoShui);
        userService.addWithNestedAndException(xiaoJing);
    }

    @Override
    @Transactional
    public void transaction_nested_nestedException_try() {
        User xiaoShui = new User().setName("小水");
        User xiaoJing = new User().setName("小镜");
        User shuiJing = new User().setName("水镜");
        userService.addWithRequired(xiaoShui);
        userService.addWithNested(xiaoJing);
        try {
            userService.addWithNestedAndException(shuiJing);
        } catch (Exception e) {
            log.error("发生异常，事务回滚！",e);
        }
    }
}
