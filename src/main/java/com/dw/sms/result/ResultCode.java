package com.dw.sms.result;

/**
 * @program:
 * @description: 接口返回规范 状态码
 * @author: dingwen
 * @create: 2020/9/23 11:17
 **/
public enum ResultCode {
    OK(200),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    INTERNAL_SERVER_ERROR(500),
    NOT_IMPLEMENTED(501),
    BAD_GATEWAY(502),
    SERVICE_UNAVAILABLE(503),
    GATEWAY_TIMEOUT(504),
    FALURE(600);

    private final int code;

    private ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return this.code;
    }
}