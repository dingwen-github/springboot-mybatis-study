package com.dw.sms.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/*
  所有属性的get和set方法、toString 方法、hashCode方法、equals方法
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 4734442276615848604L;
    private Long userId;
    private String username;
    private String password;
    private Integer age;
    private List<Account> accountList;
    private List<Role> roleList;
}
