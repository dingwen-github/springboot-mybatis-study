package com.dw.sms.result;

import java.sql.Timestamp;

/**
 * @program:
 * @description: 接口返回数据生成
 * @author: dingwen
 * @create: 2020/9/23 11:18
 **/
public class ResultGenerator {
    private static final String DEFAULT_OK = "OK";

    public ResultGenerator() {
    }

    public static Result genOkResult() {
        return (new Result()).setCode(ResultCode.OK).setMessage("OK").setCurrentTime(new Timestamp(System.currentTimeMillis()));
    }

    public static Result genOkResult(Object data) {
        return (new Result()).setCode(ResultCode.OK).setMessage("OK").setData(data).setCurrentTime(new Timestamp(System.currentTimeMillis()));
    }

    public static Result genFailureResult(String message) {
        return (new Result()).setCode(ResultCode.FALURE).setMessage(message).setCurrentTime(new Timestamp(System.currentTimeMillis()));
    }
}
