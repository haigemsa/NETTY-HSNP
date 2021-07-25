package com.grich.hsnp.entity;


import lombok.Data;

/**
 * @Author lucas
 * @ClassName WeChatUserInfo
 * @Description 微信用户信息
 * @Date 2021/5/30 14:14
 * @Version 1.0
 */
@Data
public class WeChatUserInfo {
    /**
     * 微信返回的code
     */
    private String code;
    /**
     * 非敏感的用户信息
     */
    private String rawData;
    /**
     * 签名信息
     */
    private String signature;
    /**
     * 加密的数据
     */
    private String encrypteData;
    /**
     * 加密密钥
     */
    private String iv;
}
