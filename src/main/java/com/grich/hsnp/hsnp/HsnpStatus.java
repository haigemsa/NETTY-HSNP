package com.grich.hsnp.hsnp;

/**
 * hsnp请求状态
 *
 * @author lucas
 */

public enum HsnpStatus {
    //成功
    SUCCESS("成功", 200),
    //失败
    FAIL("失败", 400),
    //请求不存在
    UN_FIND("请求不存在", 404);

    HsnpStatus(String statusName, int status) {
        this.statusName = statusName;
        this.status = status;
    }

    private final String statusName;
    private final Integer status;

    public int getStatus() {
        return status;
    }

    public String getStatusName() {
        return statusName;
    }
}
