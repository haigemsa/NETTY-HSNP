package com.grich.hsnp.utils;

/**
 * redis常量
 * Created by 廖师�?
 * 2017-07-30 16:22
 */
public interface RedisConstant {

    String TOKEN_PREFIX = "vwt_token_%s";
    String USERNAME_PREFIX = "vwt_username_%s";
    
    String USEINFO_PREFIX = "core_userinfo_%s";
    String WECHAT_PREFIX = "core_wechat_%s";

    Integer EXPIRE = 64800; // 18小时
}
