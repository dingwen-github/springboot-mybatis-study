package com.dw.sms.service.impl;

import com.dw.sms.entity.User;
import com.dw.sms.mapper.UserMapper;
import com.dw.sms.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    /*
    变量方式注入应该尽量避免，使用set方式注入或者构造器注入，这两种方式的选择就要看这个类是强制依赖的话就用构造器方式，选择依赖的话就用set方法注入
     */

    private UserMapper userMapper;

    @Autowired
    UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User add(User user) {
        userMapper.add(user);
        return userMapper.findById(user.getUserId());
    }

    @Override
    public int delete(Long userId) {
        return userMapper.delete(userId);
    }

    @Override
    public User update(User user) {
        userMapper.update(user);
        return userMapper.findById(user.getUserId());
    }

    @Override
    public List<User> queryCondition(String username, Integer age) {
        return userMapper.queryCondition(username,age);
    }

    @Override
    public Page<User> findByPaging(Map params) {
        return userMapper.findByPaging(params);
    }
}
