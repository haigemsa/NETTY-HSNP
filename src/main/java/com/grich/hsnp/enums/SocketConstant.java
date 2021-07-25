package com.grich.hsnp.enums;


/**
 * @author lucas
 */
public class SocketConstant {
    /**
     * socket连接类型
     *
     * @author lucas
     * @date 2020-10-15
     */
    public enum Type{
        //注册
        register("注册设备",0),
        //启动
        start("启动设备",1),
        //关闭
        close("关闭设备",2),
        //获取用户信息
        userInfo("获取用户信息",3),
        //上传计费信息
        uploadCost("上传计费信息",4),
        //开门
        openGate("开门",8);
        Type(String typeName, int type){
            this.typeName = typeName;
            this.type = type;
        }
        private final String typeName;
        private final int type;
        public int getType() {
            return type;
        }
    }

    /**
     * 设备超时时间
     */
    public static final int FAIL_TIME = 15000;
}
