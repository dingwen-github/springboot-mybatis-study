package com.dw.sms.mapper;

import com.dw.sms.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program:
 * @description: Account Mapper
 * @author: dingwen
 * @create: 2020/10/12 16:05
 **/
@Repository
public interface AccountMapper {
    /*
     *查询账户下的所有信息，包括用户信息
     * @param []
     * @return java.util.List<com.dw.sms.entity.Account>
     */
    List<Account> findAll();
}
