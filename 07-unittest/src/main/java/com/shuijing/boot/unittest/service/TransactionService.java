package com.shuijing.boot.unittest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-05-04
 */
public interface TransactionService {
    @Transactional
    void transaction_nested_nested_externalException();

    @Transactional
    void transaction_nested_nestedException();

    void clean();

    void noTransaction_required_required_externalException();

    void noTransaction_required_requiredException();

    @Transactional
    void transaction_required_required_externalException();

    @Transactional
    void transaction_required_requiredException();

    @Transactional
    void transaction_required_requiredException_try();

    @Transactional
    void transaction_required_requiredNew_externalException();

    @Transactional
    void transaction_required_requiredNew_requiredNewException();

    @Transactional(propagation = Propagation.REQUIRED)
    void transaction_required_requiredNewException_try();

    @Transactional
    void transaction_nested_nestedException_try();
}
