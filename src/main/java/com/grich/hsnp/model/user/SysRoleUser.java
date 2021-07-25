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
public class SysRoleUser {
    @Id
    private String id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    @ApiModelProperty("角色id")
    private String roleId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    @ApiModelProperty("用户id")
    private String userId;

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