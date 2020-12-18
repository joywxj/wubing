package com.wxj.domain.entity.workload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("工作量表实体类")
public class Workload{ 
	@ApiModelProperty("主键")
	private Integer id;

	@ApiModelProperty("工地ID")
	private Integer conId;

	@ApiModelProperty("长")
	private double length;

	@ApiModelProperty("宽")
	private double width;

	@ApiModelProperty("高")
	private double height;

	@ApiModelProperty("面积 ")
	private double area;

	@ApiModelProperty("体积")
	private double volume;

	@ApiModelProperty("")
	private double price;

	@ApiModelProperty("")
	private double total;

	@ApiModelProperty("创建人")
	private String createUser;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("更新人")
	private String modifyUser;

	@ApiModelProperty("更新时间")
	private Date modifyTime;

}