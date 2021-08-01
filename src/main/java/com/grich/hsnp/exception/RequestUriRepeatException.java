package com.grich.hsnp.exception;

/**
 * @program: hsnp
 * @description: RequestUriRepeatException socket定义的请求地址重复异常
 * @author: lucas
 * @date: 2021-07-30 14:57
 */
public class RequestUriRepeatException extends RuntimeException{
    public RequestUriRepeatException(String message) {
        super(message);
    }
}
