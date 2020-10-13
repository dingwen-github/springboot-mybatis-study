package com.dw.sms.mapper;

import com.dw.sms.entity.EnumTest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program:
 * @description: EnumTest Mapper
 * @author: dingwen
 * @create: 2020/10/12 16:05
 **/
@Repository
public interface EnumTestMapper {
    int add(EnumTest enumTest);
    List<EnumTest> findAll();
}
