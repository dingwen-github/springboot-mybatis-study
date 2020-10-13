package com.dw.sms.service;

import com.dw.sms.entity.Account;

import java.util.List;

/**
 * @program:
 * @description: Account Services
 * @author: dingwen
 * @create: 2020/10/12 16:25
 **/
public interface AccountService {
    List<Account> findAll();

}
