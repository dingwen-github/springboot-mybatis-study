package com.dw.sms.service.impl;

import com.dw.sms.entity.Role;
import com.dw.sms.mapper.RoleMapper;
import com.dw.sms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:
 * @description: TODO
 * @author: dingwen
 * @create: 2020/10/12 17:44
 **/
@Service
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper;

    @Autowired
    RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }
}
