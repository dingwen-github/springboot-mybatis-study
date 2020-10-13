package com.dw.sms.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @program:
 * @description: JSON
 * @author: dingwen
 * @create: 2020/10/13 10:12
 **/
@Data
public class JsonTest implements Serializable {
    private static final long serialVersionUID = -3976563671752386501L;
    private Integer jsonId;
    private Map<String, String> content;
}
