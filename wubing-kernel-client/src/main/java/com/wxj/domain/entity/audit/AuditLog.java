package com.wxj.domain.entity.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("审核记录表实体类")
public class AuditLog{ 
	@ApiModelProperty("")
	private Integer id;

	@ApiModelProperty("审核标识")
	private String auditTag;

	@ApiModelProperty("审核意见")
	private String auditMessage;

	@ApiModelProperty("审核字典:advance--借支")
	private String auditDict;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("创建人")
	private String createUser;

}