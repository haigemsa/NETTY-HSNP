package com.grich.hsnp.entity;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel
@Data
public class ChangePassWordDto{

	/**
	 * 旧密码
	 */
	 @ApiModelProperty("旧密码")
	 private String oldPassword;

	/**
	 * 新密码
	 */
	 @ApiModelProperty("新密码")
	 private String newPassword;

	/**
	 * 确认新密码
	 */
	 @ApiModelProperty("确认新密码")
	 private String retypeNewPassword;
	
}
