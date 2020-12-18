package com.wxj.domain.dto.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("菜单表查询实体类")
public class MenuConditionDto {
	@ApiModelProperty("主键")
	private Integer id;

	@ApiModelProperty("标题")
	private String title;

	@ApiModelProperty("路径")
	private String path;

	@ApiModelProperty("排序")
	private Integer order;

	@ApiModelProperty("父id")
	private Integer pid;

	@ApiModelProperty("用户Ie")
	private Integer emId;

	@ApiModelProperty("当前页")
	private Integer page;

	@ApiModelProperty("每页条数")
	private Integer size;

}