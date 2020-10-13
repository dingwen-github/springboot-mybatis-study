package com.dw.sms.service;

import com.dw.sms.entity.EnumTest;

import java.util.List;

public interface EnumTestService {
    int add(EnumTest enumTest);
    List<EnumTest> findAll();
}
