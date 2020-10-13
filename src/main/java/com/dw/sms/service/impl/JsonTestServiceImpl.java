package com.dw.sms.service.impl;

import com.dw.sms.entity.JsonTest;
import com.dw.sms.mapper.JsonTestMapper;
import com.dw.sms.service.JsonTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:
 * @description: TODO
 * @author: dingwen
 * @create: 2020/10/13 10:38
 **/
@Service
public class JsonTestServiceImpl implements JsonTestService {

    private JsonTestMapper jsonTestMapper;
    @Autowired
    JsonTestServiceImpl(JsonTestMapper jsonTestMapper){
        this.jsonTestMapper = jsonTestMapper;
    }
    @Override
    public int add(JsonTest jsonTest) {
        return jsonTestMapper.add(jsonTest);
    }

    @Override
    public List<JsonTest> findAll() {
        return jsonTestMapper.findAll();
    }
}
