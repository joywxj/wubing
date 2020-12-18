package com.wxj.domain.dto.timesheet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("工时表查询实体类")
public class TimesheetsConditionDto {
	@ApiModelProperty("主键")
	private Integer id;

	@ApiModelProperty("工地名称")
	private String cstName;

	@ApiModelProperty("工地id")
	private Integer cstId;

	@ApiModelProperty("工地name")
	private String emName;

	@ApiModelProperty("员工id")
	private Integer emId;

	@ApiModelProperty("年份")
	private Integer years;

	@ApiModelProperty("月份")
	private Integer months;

	@ApiModelProperty("")
	private String createUser;

	@ApiModelProperty("")
	private Date createTime;

	@ApiModelProperty("")
	private Date modifyTime;

	@ApiModelProperty("")
	private String modifyUser;

	@ApiModelProperty("当前页")
	private Integer page;

	@ApiModelProperty("每页条数")
	private Integer size;

}