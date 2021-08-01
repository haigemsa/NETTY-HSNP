package com.grich.hsnp.exception;

/**
 * @program: hsnp
     * @description: RequestParamException 请求参数异常
 * @author: lucas
 * @date: 2021-07-30 14:57
 */
public class RequestParamException extends RuntimeException{
    public RequestParamException(String message) {
        super(message);
    }
}
