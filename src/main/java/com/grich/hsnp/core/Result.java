package com.grich.hsnp.core;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 统一API响应结果封装
 * @author william
 */
public class Result<T> implements Serializable{
   
	private static final long serialVersionUID = 1L;
	private int code;
    private String message;
    private T data;

    public Result<T> setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String toStringForSocket(){
        return JSON.toJSONString(this) +  "\r\n";
    }
}
