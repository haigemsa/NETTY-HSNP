package com.grich.hsnp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * socket处理器组件扫描注解
 *
 * @author sysker
 * @version 1.0
 * @date 2021-06-02 20:57
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SocketRequestScan {
    String[] value() ;
}
