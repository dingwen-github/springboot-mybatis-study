package com.dw.sms.service;

import com.dw.sms.entity.JsonTest;

import java.util.List;

public interface JsonTestService {
    int add(JsonTest jsonTest);
    List<JsonTest> findAll();
}
