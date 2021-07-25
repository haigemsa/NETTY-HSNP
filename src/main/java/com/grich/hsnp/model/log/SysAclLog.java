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
public class SysAclLog {
    @Id
    private String id;

    /**
     * 权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系
     */
    @ApiModelProperty("权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系")
    private Integer type;

    /**
     * 基于type后指定的对象id，比如用户、权限、角色等表的主键
     */
    @Column(name = "target_id")
    @ApiModelProperty("基于type后指定的对象id，比如用户、权限、角色等表的主键")
    private String targetId;

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

    /**
     * 当前是否复原过，0：没有，1：复原过
     */
    @ApiModelProperty("当前是否复原过，0：没有，1：复原过")
    private Integer status;

    /**
     * 旧值
     */
    @Column(name = "old_value")
    @ApiModelProperty("旧值")
    private String oldValue;

    /**
     * 新值
     */
    @Column(name = "new_value")
    @ApiModelProperty("新值")
    private String newValue;
}