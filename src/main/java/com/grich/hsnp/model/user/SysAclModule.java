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
public class SysAclModule {
    /**
     * 权限模块id
     */
    @Id
    @ApiModelProperty("权限模块id")
    private String id;

    /**
     * 权限模块名称
     */
    @ApiModelProperty("权限模块名称")
    private String name;

    /**
     * 权限模块的编码，需要跟前端路由模块严格对应
     */
    @ApiModelProperty("权限模块的编码，需要跟前端路由模块严格对应")
    private String code;

    /**
     * 上级权限模块id
     */
    @Column(name = "parent_id")
    @ApiModelProperty("上级权限模块id")
    private String parentId;

    /**
     * 权限模块层级
     */
    @ApiModelProperty("权限模块层级")
    private String level;

    /**
     * 权限模块在当前层级下的顺序，由小到大
     */
    @ApiModelProperty("权限模块在当前层级下的顺序，由小到大")
    private Integer seq;

    /**
     * 状态，1：正常，0：冻结
     */
    @ApiModelProperty("状态，1：正常，0：冻结")
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
     * 最后一次操作时间
     */
    @Column(name = "operate_time")
    @ApiModelProperty("最后一次操作时间")
    private Date operateTime;

    /**
     * 最后一次更新操作者的ip地址
     */
    @Column(name = "operate_ip")
    @ApiModelProperty("最后一次更新操作者的ip地址")
    private String operateIp;
}