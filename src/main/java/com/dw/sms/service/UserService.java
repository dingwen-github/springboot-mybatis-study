package com.dw.sms.service;

import com.dw.sms.entity.User;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    User add(User user);

    int delete(Long userId);

    User update(User user);

    List<User> queryCondition(String username, Integer age);

    Page<User> findByPaging(Map params);

    List<User> findAllDetail();

    List<User> findAllDetails();
}
