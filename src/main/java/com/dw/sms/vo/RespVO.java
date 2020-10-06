package com.dw.sms.vo;

import lombok.Data;

/**
 * @program:
 * @description: TODO
 * @author: dingwen
 * @create: 2020/10/6 13:24
 **/
@Data
public class RespVO {
    public static RespVO ok(String msg) {
        RespVO respVO = new RespVO();
        respVO.code = "200";
        respVO.setMsg(msg);
        respVO.timestamp = System.currentTimeMillis();
        return respVO;
    }

    public static RespVO error(String msg) {
        RespVO respVO = new RespVO();
        respVO.code = "500";
        respVO.setMsg(msg);
        respVO.timestamp = System.currentTimeMillis();
        return respVO;
    }

    private String code;
    private String msg;
    private Long timestamp;
}
