package com.dw.sms.mapper;

import com.dw.sms.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program:
 * @description: Role Mapper
 * @author: dingwen
 * @create: 2020/10/12 17:34
 **/
@Repository
public interface RoleMapper {
    List<Role> findAll();
}
