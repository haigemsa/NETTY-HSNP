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
public class SysRoleAcl {
    @Id
    private String id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    @ApiModelProperty("角色id")
    private String roleId;

    /**
     * 权限id
     */
    @Column(name = "acl_id")
    @ApiModelProperty("权限id")
    private String aclId;

    /**
     * 权限类型：0 - 权限点；1 - 权限模块
     */
    @Column(name = "acl_type")
    @ApiModelProperty("权限类型：0 - 权限点；1 - 权限模块")
    private Integer aclType;

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
     * 最后一次更新者的ip
     */
    @Column(name = "operate_ip")
    @ApiModelProperty("最后一次更新者的ip")
    private String operateIp;
}