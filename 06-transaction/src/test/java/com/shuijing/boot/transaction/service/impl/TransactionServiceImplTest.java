package com.shuijing.boot.transaction.service.impl;

import com.shuijing.boot.transaction.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-05-04
 */
@SpringBootTest
class TransactionServiceImplTest {

    @Autowired
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        transactionService.clean();
    }

    // 都能插入
    @Test
    void noTransaction_required_required_externalException() {
        transactionService.noTransaction_required_required_externalException();
    }

    // 小水插入，小镜未插入
    @Test
    void noTransaction_required_requiredException() {
        transactionService.noTransaction_required_requiredException();
    }


    // 都未插入
    @Test
    void transaction_required_required_externalException() {
        transactionService.transaction_required_required_externalException();
    }

    // 都未插入
    @Test
    void transaction_required_requiredException() {
        transactionService.transaction_required_requiredException();
    }

    // 都未插入
    @Test
    void transaction_required_requiredException_try() {
        transactionService.transaction_required_requiredException_try();
    }


    // 小水未插入，小镜插入
    @Test
    void transaction_required_requiredNew_externalException() {
        transactionService.transaction_required_requiredNew_externalException();
    }

    // 小水未插入，小镜插入，水镜未插入
    @Test
    void transaction_required_requiredNew_requiredNewException() {
        transactionService.transaction_required_requiredNew_requiredNewException();
    }

    // 小水插入，小镜插入，水镜未插入
    @Test
    void transaction_required_requiredNewException_try() {
        transactionService.transaction_required_requiredNewException_try();
    }


    // 都未插入
    @Test
    void transaction_nested_nested_externalException() {
        transactionService.transaction_nested_nested_externalException();
    }

    // 都未插入
    @Test
    void transaction_nested_nestedException() {
        transactionService.transaction_nested_nestedException();
    }

    // 小水插入，小镜插入，水镜未插入
    @Test
    void transaction_nested_nestedException_try() {
        transactionService.transaction_nested_nestedException_try();
    }
}