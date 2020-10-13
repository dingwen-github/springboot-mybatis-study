package com.dw.sms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program:
 * @description: TODO
 * @author: dingwen
 * @create: 2020/10/12 18:00
 **/
@Data
public class EnumTest implements Serializable {
    private Integer id;
    private String brand;
    private Color color;
}
