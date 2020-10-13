package com.dw.sms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program:
 * @description: 账户实体
 * @author: dingwen
 * @create: 2020/10/12 16:00
 **/
@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 4010674801542419436L;
    private Long accountId;
    private Long userId;
    private Double money;
    //主表实体应该包含一个从表实体的引用对象
    private User user;
}
