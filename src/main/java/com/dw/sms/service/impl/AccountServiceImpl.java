package com.dw.sms.service.impl;

import com.dw.sms.entity.Account;
import com.dw.sms.mapper.AccountMapper;
import com.dw.sms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: dingwen
 * @create: 2020/10/12 16:27
 **/
@Service
public class AccountServiceImpl implements AccountService {
    private AccountMapper accountMapper;

    @Autowired
    AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }
}
