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
    /**
     * 设备类型
     *
     * @author lucas
     * @date 2021-06-13
     */
    public enum AdviceType {
        //洗浴区
        SHOWER("洗浴区", "DS"),
        //烘干区(小中)
        DRY_BIG("烘干区（小中）", "DM"),
        //烘干区(大)
        DRY("烘干区（大）", "DD"),
        //造型区
        ARTS("造型区", "DA"),
        //门锁
        DOOR("门锁", "DG");

        AdviceType(String name, String code) {
            this.name = name;
            this.code = code;
        }

        private final String name;
        private final String code;

        public String getCode() {
            return code;
        }

    }

    /**
     * 订单支付状态
     *
     * @author lucas
     * @date 2021-06-20
     */
    public enum OrderStatus {
        //未支付
        UNPAID("未支付", 0),
        //已支付
        PAID("已支付", 1);

        OrderStatus(String statusName, int status) {
            this.statusName = statusName;
            this.status = status;
        }

        private final String statusName;
        private final int status;

        public int getStatus() {
            return status;
        }
    }

}
