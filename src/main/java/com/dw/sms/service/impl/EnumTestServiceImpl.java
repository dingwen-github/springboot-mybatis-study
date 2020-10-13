package com.dw.sms.service.impl;

import com.dw.sms.entity.EnumTest;
import com.dw.sms.mapper.EnumTestMapper;
import com.dw.sms.service.EnumTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.EnumMapper;

import java.util.List;

/**
 * @program:
 * @description: EnumTestService 实现类
 * @author: dingwen
 * @create: 2020/10/13 9:34
 **/
@Service
public class EnumTestServiceImpl implements EnumTestService {
    private EnumTestMapper enumTestMapper;

    @Autowired
    EnumTestServiceImpl(EnumTestMapper enumTestMapper) {
        this.enumTestMapper = enumTestMapper;
    }

    @Override
    public int add(EnumTest enumTest) {
        return enumTestMapper.add(enumTest);
    }

    @Override
    public List<EnumTest> findAll() {
        return enumTestMapper.findAll();
    }
}
