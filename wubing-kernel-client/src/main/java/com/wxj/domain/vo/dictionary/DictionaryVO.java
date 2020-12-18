package com.wxj.domain.vo.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("字典表实体类")
public class DictionaryVO{ 
	@ApiModelProperty("")
	private Integer id;

	@ApiModelProperty("字典类型code")
	private String typeCode;

	@ApiModelProperty("字典code")
	private String paramCode;

	@ApiModelProperty("页面上展示的值")
	private String showValue;

	@ApiModelProperty("数据库中用到的值")
	private String paramValue;

}