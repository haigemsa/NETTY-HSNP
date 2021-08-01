package com.grich.hsnp.hsnp;


import com.grich.hsnp.annotation.SocketController;
import com.grich.hsnp.annotation.SocketRequestMapping;
import com.grich.hsnp.annotation.SocketRequestScan;
import com.grich.hsnp.exception.RequestUriRepeatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @author lucas
 */
public class ClassHandle {

    private static final Logger logger = LoggerFactory.getLogger(ClassHandle.class);

    /**
     * 项目里所有java class类的集合
     */
    private static final Set<Class<?>> PROJECT_CLASS = new HashSet<>();

    /**
     * Socket请求映射的处理方法 String：请求uri   Method：对应的处理方法
     */
    private static final Map<String, Method> SOCKET_REQUEST_MAPPING_MAP = new HashMap<>();

    public static Map<String, Method> getSocketRequestMappingMap() {
        return SOCKET_REQUEST_MAPPING_MAP;
    }

    /**
     * 扫描指定的包路径，如果无该路径，则默认扫描服务器核心入口所在路径
     *
     * @param aClass
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void componentScanInit(Class aClass) throws IOException, ClassNotFoundException {
        logger.info("componentScanInit start init……");
        logger.info("componentScanInit aClass: {}", aClass);
        Annotation annotation = aClass.getAnnotation(SocketRequestScan.class);
        if (Objects.isNull(annotation)) {
            Package aPackage = aClass.getPackage();
            scanPackage(aPackage.toString(), PROJECT_CLASS);
        } else {
            String[] value = ((SocketRequestScan) annotation).value();
            for (String s : value) {
                scanPackage(s, PROJECT_CLASS);
            }
        }
        logger.info("componentScanInit end, classSet = {}", PROJECT_CLASS);
    }


    /**
     * 扫描指定包名下所有类，并生成classSet
     *
     * @param packageName
     * @param classSet
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void scanPackage(String packageName, Set<Class<?>> classSet)
            throws IOException, ClassNotFoundException {
        logger.info("start to scanPackage, packageName = {}", packageName);
        Enumeration<URL> classes = ClassLoader.getSystemResources(packageName.replace('.', '/'));
        while (classes.hasMoreElements()) {
            URL url = classes.nextElement();
            File packagePath = new File(url.getPath());
            if (packagePath.isDirectory()) {
                File[] files = packagePath.listFiles();
                for (File file : files) {
                    String fileName = file.getName();
                    if (file.isDirectory()) {
                        String newPackageName = String.format("%s.%s", packageName, fileName);
                         scanPackage(newPackageName, classSet);
                    } else {
                        String className = fileName.substring(0, fileName.lastIndexOf('.'));
                        String fullClassName = String.format("%s.%s", packageName, className);
                        classSet.add(Class.forName(fullClassName));
                    }
                }
            } else {
                String className = url.getPath().substring(0, url.getPath().lastIndexOf('.'));
                String fullClassName = String.format("%s.%s", packageName, className);
                classSet.add(Class.forName(fullClassName));
            }
        }
    }

    /**
     * 扫描SocketController的SocketRequestMapping
     */
    public static void initSocketRequestMappingMap() {
        logger.info("start to scanRequestMapping, controllerSet = {}", PROJECT_CLASS);
        if (PROJECT_CLASS.size() == 0) {
            return;
        }
        PROJECT_CLASS.forEach(aClass -> {
            Annotation controller = aClass.getAnnotation(SocketController.class);
            //查看类的SocketRequestMapping注解是否有uri
            SocketRequestMapping controllerReqAnnotation= aClass.getAnnotation(SocketRequestMapping.class);
            String beforeUri = "";
            if (controllerReqAnnotation != null){
                beforeUri =  controllerReqAnnotation.value();
            }
            if (Objects.isNull(controller)) {
                return;
            }
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                SocketRequestMapping annotation = method.getAnnotation(SocketRequestMapping.class);
                if (Objects.nonNull(annotation)) {
                    Method put = SOCKET_REQUEST_MAPPING_MAP.putIfAbsent(beforeUri.trim() + annotation.value().trim(), method);
                    //当有重复的地址对应方法时抛异常
                    if (put != null){
                        throw new RequestUriRepeatException(annotation.value() + " is repeat");
                    }
                }
            }
        });
        logger.info("scanRequestMapping end, requestMappingMap = {}", SOCKET_REQUEST_MAPPING_MAP);
    }
}
