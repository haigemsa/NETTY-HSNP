package com.grich.hsnp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: hsnp
 * @description: SocketController
 * @author: lucas
 * @date: 2021-07-30 15:35
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SocketController {
    String value() default "";


}
