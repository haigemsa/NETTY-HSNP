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
public class SysAcl {
    /**
     * 权限id
     */
    @Id
    @ApiModelProperty("权限id")
    private String id;

    /**
     * 权限码
     */
    @ApiModelProperty("权限码")
    private String code;

    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    private String name;

    /**
     * 权限所在的权限模块id
     */
    @Column(name = "acl_module_id")
    @ApiModelProperty("权限所在的权限模块id")
    private String aclModuleId;

    /**
     * 请求的url, 可以填正则表达式
     */
    @ApiModelProperty("请求的url, 可以填正则表达式")
    private String url;

    /**
     * 类型，1：菜单，2：按钮，3：其他
     */
    @ApiModelProperty("类型，1：菜单，2：按钮，3：其他")
    private Integer type;

    /**
     * 状态，1：正常，0：冻结
     */
    @ApiModelProperty("状态，1：正常，0：冻结")
    private Integer status;

    /**
     * 权限在当前模块下的顺序，由小到大
     */
    @ApiModelProperty("权限在当前模块下的顺序，由小到大")
    private Integer seq;

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
     * 最后一次更新时间
     */
    @Column(name = "operate_time")
    @ApiModelProperty("最后一次更新时间")
    private Date operateTime;

    /**
     * 最后一个更新者的ip地址
     */
    @Column(name = "operate_ip")
    @ApiModelProperty("最后一个更新者的ip地址")
    private String operateIp;
}