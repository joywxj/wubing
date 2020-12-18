package com.wxj.domain.entity.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @ClassName:  Dictionary
* @Description:TODO 字典表
* @Modified:第一版本
* @author: wxj
* @date:2020-4-7 8:36:04
* @email: 18772118541@163.com
*/
@Data
@ApiModel("数据字典")
public class Dictionary{
	@ApiModelProperty("主键id")
	private String id;

	@ApiModelProperty("字典类型code")
	private String typeCode;

	@ApiModelProperty("页面上展示的值")
	private String showValue;

	@ApiModelProperty("字典code")
	private String paramCode;

	@ApiModelProperty("存在数据库里面的值")
	private String paramValue;

}