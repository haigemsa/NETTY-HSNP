package com.grich.hsnp.enums;


/**
 * @author Lucas
 */
public class Constants {

    /**
     * 用户账号状态
     *
     * @author lucas
     * @date 2020-10-15
     */
    public enum VlaUserStatus {
        //注销
        DELETE("注销", 0),
        //正常
        NORMAL("正常", 1),
        //冻结
        FROZEN("冻结", 2);

        VlaUserStatus(String statusName, int status) {
            this.statusName = statusName;
            this.status = status;
        }

        private final String statusName;
        private final int status;

        public int getStatus() {
            return status;
        }
    }
    /**
     * 用户类型
     *
     * @author lucas
     * @date 2021-06-27
     */
    public enum VlaUserType {
        //管理员用户
        ADMIN("管理员", 1),
        //微信普通用户
        WE_CHAT("微信普通用户", 0);

        VlaUserType(String name, int type) {
            this.name = name;
            this.type = type;
        }
        private final String name;
        private final int type;
        public int getType() {
            return type;
        }
    }


}
