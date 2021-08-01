package com.grich.hsnp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: hsnp
 * @description: SocketRequestMapping
 * @author: lucas
 * @date: 2021-07-31 15:42
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SocketRequestMapping {
    String value();
}
