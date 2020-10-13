package com.dw.sms.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program:
 * @description: 角色实体类
 * @author: dingwen
 * @create: 2020/10/12 17:13
 **/
@Data
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private List<User> userList;
}
