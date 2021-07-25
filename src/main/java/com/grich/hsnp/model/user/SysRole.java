package com.grich.hsnp.model.user;

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
public class SysRole {
    /**
     * 角色id
     */
    @Id
    @ApiModelProperty("角色id")
    private String id;

    /**
     * 角色名
     */
    @ApiModelProperty("角色名")
    private String name;

    /**
     * 角色的类型，1：管理员角色，2：其他
     */
    @ApiModelProperty("角色的类型，1：管理员角色，2：其他")
    private Integer type;

    /**
     * 状态，1：可用，0：冻结
     */
    @ApiModelProperty("状态，1：可用，0：冻结")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 操作者
     */
    @ApiModelProperty("操作者")
    private String operator;

    /**
     * 最后一次更新的时间
     */
    @Column(name = "operate_time")
    @ApiModelProperty("最后一次更新的时间")
    private Date operateTime;

    /**
     * 最后一次更新者的ip地址
     */
    @Column(name = "operate_ip")
    @ApiModelProperty("最后一次更新者的ip地址")
    private String operateIp;
}