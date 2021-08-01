package com.grich.hsnp.hsnp;

import com.alibaba.fastjson.JSONObject;
import com.grich.hsnp.annotation.SocketRequestBody;
import com.grich.hsnp.annotation.SocketRequestParam;
import com.grich.hsnp.entity.SocketDataDto;
import com.grich.hsnp.exception.RequestParamException;
import com.grich.hsnp.server.MyServerHandler;
import com.grich.hsnp.utils.SpringContextUtil;
import io.swagger.models.auth.In;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author lucas
 */
@Data
public class HsnpRequestDispatch {
    private Logger logger = LoggerFactory.getLogger(HsnpRequestDispatch.class);

    private HsnpResponse hsnpResponse;
    private HsnpRequest hsnpRequest;
    private Map<String, Method> socketRequestMappingMap;
    private ApplicationContext applicationContext;

    public HsnpRequestDispatch(HsnpRequest hsnpRequest,HsnpResponse hsnpResponse){
        this.hsnpRequest = hsnpRequest;
        this.hsnpResponse = hsnpResponse;
        //获取请求对应关系
        this.socketRequestMappingMap =  ClassHandle.getSocketRequestMappingMap();
        //获取Spring的上下文信息
        this.applicationContext = SpringContextUtil.getApplicationContext();
    }

    public void doDispatch(){
        if (this.socketRequestMappingMap.containsKey(this.hsnpRequest.getUri())){
            Method method = this.socketRequestMappingMap.get(this.hsnpRequest.getUri());
            //获取方法对应的class
            Class<?> declaringClass = method.getDeclaringClass();
            //获取参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();

            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            Object[] parameters = new Object[parameterAnnotations.length];
            for (int i = 0; i < parameterAnnotations.length; i++) {
                Annotation anno = parameterAnnotations[i][0];
                if (anno instanceof SocketRequestBody){
                    if(hsnpRequest.getBody() != null){
                        JSONObject jsonObject = JSONObject.parseObject(hsnpRequest.getBody());
                        Class<?> clazz = parameterTypes[i];
                        parameters[i] = jsonObject.toJavaObject(clazz);
                    }
                    parameters[i] = new Object();
                }else if(anno instanceof SocketRequestParam){
                    SocketRequestParam annotation = (SocketRequestParam) anno;
                    String value = hsnpRequest.getParamMap().get(annotation.value());
                    boolean require = annotation.require();
                    if (require && value == null){
                        throw new RequestParamException(annotation.value() + " param is need input!");
                    }
                    Class<?> clazz = parameterTypes[i];

                    if (clazz == int.class || clazz == Integer.class) {
                        parameters[i] = Integer.parseInt(value);
                    }else if (clazz == String.class || clazz == char.class){
                        parameters[i] = value;
                    }else if (clazz == boolean.class || clazz == Boolean.class){
                        parameters[i] = Boolean.parseBoolean(value);
                    }else if (clazz == float.class || clazz == Float.class){
                        parameters[i] = Float.parseFloat(value);
                    }else if (clazz == double.class || clazz == Double.class){
                        parameters[i] = Double.parseDouble(value);
                    }
                }
            }

            Object bean = applicationContext.getBean(declaringClass);

            try {
                Object result = method.invoke(bean,parameters);

                hsnpResponse.success(result);
            } catch (IllegalAccessException | InvocationTargetException e) {
                logger.error(e.getMessage(),e);
                hsnpResponse.fail(e.getMessage());
            }
            logger.debug("method:{}", method);
        }else {
            hsnpResponse.fail(String.format("resources not found :%d", System.currentTimeMillis()));
        }

    }

}
