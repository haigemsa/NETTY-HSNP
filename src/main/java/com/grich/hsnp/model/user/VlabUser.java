package com.grich.hsnp.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
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
public class VlabUser {
    /**
     * 用户ID（UUID）
     */
    @Id
    @ApiModelProperty("用户ID（UUID）")
    private String id;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 微信用户唯一标识
     */
    @JsonIgnore
    @ApiModelProperty("微信用户唯一标识")
    private String openId;
    /**
     * 微信会话密钥
     */
    @JsonIgnore
    @ApiModelProperty(value = "微信会话密钥",hidden = true)
    private String sessionKey;

    /**
     * 密码
     */
    @ApiModelProperty(value ="密码",hidden = true)
    @JsonIgnore
    private String password;

    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String realname;

    /**
     * 身份证号码
     */
    @ApiModelProperty(value = "身份证号码",hidden = true)
    @JsonIgnore
    private String idCard;

    /**
     * 账户余额
     */
    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;


    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 头像
     */
    @Column(name = "head_image_url")
    @ApiModelProperty("头像")
    private String headImageUrl;

    /**
     * 出生年月日
     */
    @ApiModelProperty("出生年月日")
    private String birthdate;

    /**
     * 用户类别：0 - 普通用户；1 - 管理员用户
     */
    @ApiModelProperty("用户类别：0 - 普通用户；1 - 管理员用户")
    private Integer userType;

    /**
     * 性别：0 - 女；1 - 男
     */
    @ApiModelProperty("性别：0 - 女；1 - 男")
    private Integer sex;

    /**
     * 状态：0 - 已删除；1 - 正常, 2 - 锁定
     */
    @ApiModelProperty("状态：0 - 已删除；1 - 正常, 2 - 锁定")
    private Integer status;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 上次登录时间
     */
    @Column(name = "last_login_time")
    @ApiModelProperty("上次登录时间")
    private Date lastLoginTime;
}