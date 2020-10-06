package com.dw.sms.exception;

import com.dw.sms.vo.RespVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program:
 * @description: 对controller响应结果做统一的异常处理
 * @author: dingwen
 * @create: 2020/10/6 13:27
 **/
@ControllerAdvice
public class ExceptionHandler {
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public RespVO HandleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return RespVO.error(e.getBindingResult().getFieldError().getDefaultMessage());
//        return getMessage(e);
    }

    /**
     * 结合BeanValid，格式化异常信息
     *
     * @param ex
     * @return
     */
    private String getMessage(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder();
        for (FieldError error : bindingResult.getFieldErrors()) {
            String field = error.getField();
            Object value = error.getRejectedValue();
            String msg = error.getDefaultMessage();
            String message = String.format("错误字段：%s，错误值：%s，原因：%s；", field, value, msg);
            sb.append(message);
        }
        return sb.toString();
    }

}
