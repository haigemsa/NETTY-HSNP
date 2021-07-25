package com.grich.hsnp.model.log;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2020/05/11
* @author William 
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysLog {
    @Id
    private String id;

    /**
     * 日志类型
     */
    @Column(name = "log_type")
    @ApiModelProperty("日志类型")
    private Integer logType;

    /**
     * 操作者ID
     */
    @Column(name = "operator_id")
    @ApiModelProperty("操作者ID")
    private String operatorId;

    /**
     * 操作者
     */
    @ApiModelProperty("操作者")
    private String operator;

    /**
     * 操作者角色
     */
    @Column(name = "operator_roles")
    @ApiModelProperty("操作者角色")
    private String operatorRoles;

    /**
     * 动作
     */
    @ApiModelProperty("动作")
    private String action;

    /**
     * 动作对应的目标，如用户、角色等
     */
    @ApiModelProperty("动作对应的目标，如用户、角色等")
    private String target;

    /**
     * 操作时间
     */
    @Column(name = "operate_time")
    @ApiModelProperty("操作时间")
    private Date operateTime;

    /**
     * 基于type后指定的对象id,比如用户、权限、角色等表的主键
     */
    @Column(name = "target_id")
    @ApiModelProperty("基于type后指定的对象id,比如用户、权限、角色等表的主键")
    private String targetId;

    /**
     * 旧值ֵ
     */
    @Column(name = "old_value")
    @ApiModelProperty("旧值ֵ")
    private String oldValue;

    /**
     * 新值ֵ
     */
    @Column(name = "new_value")
    @ApiModelProperty("新值ֵ")
    private String newValue;

    /**
     * 操作者的ip地址ַ
     */
    @Column(name = "operate_ip")
    @ApiModelProperty("操作者的ip地址ַ")
    private String operateIp;

    /**
     * 状态：当前是否复原过，0：没有，1：复原过
     */
    @ApiModelProperty("状态：当前是否复原过，0：没有，1：复原过")
    private Integer status;
}