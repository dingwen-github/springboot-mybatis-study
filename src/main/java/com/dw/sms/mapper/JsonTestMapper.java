package com.dw.sms.mapper;

import com.dw.sms.entity.JsonTest;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JsonTestMapper {
    int add(JsonTest jsonTest);
    List<JsonTest> findAll();
}
