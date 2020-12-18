package com.wxj.domain.entity.advance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
@ApiModel("员工预支表实体类")
public class Advance {
	@ApiModelProperty("主键")
	private Integer id;

	@ApiModelProperty("员工id")
	private Integer emId;

	@ApiModelProperty("借支金额")
	private BigDecimal money;

	@ApiModelProperty("审核状态：wait--待审核,pass--审核通过,noPass--审核不通过")
	private String auditTag;
	@ApiModelProperty("审核信息")
	private String auditMessage;
	@ApiModelProperty("创建用户")
	private String createUser;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("修改用户，")
	private String modifyUser;

	@ApiModelProperty("修改时间")
	private Date modifyTime;

}