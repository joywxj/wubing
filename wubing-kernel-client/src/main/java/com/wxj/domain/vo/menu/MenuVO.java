package com.wxj.domain.vo.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("菜单表实体类")
public class MenuVO{ 
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

	@ApiModelProperty("")
	private Integer createUser;

	@ApiModelProperty("")
	private Date createTime;

	@ApiModelProperty("")
	private Integer modifyUser;

	@ApiModelProperty("")
	private Date modifyTime;

}