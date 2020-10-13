package com.dw.sms.mapper;

import com.dw.sms.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    User findById(Long id);

    List<User> findAll();

    int add(User user);

    int delete(Long id);

    int update(User user);

    List<User> queryCondition(@Param("username") String username, @Param("age") Integer age);

    Page<User> findByPaging(Map paras);

    /*一对多*/
    List<User> findAllDetail();

    /*多对多*/
    List<User> findAllDetails();
}
