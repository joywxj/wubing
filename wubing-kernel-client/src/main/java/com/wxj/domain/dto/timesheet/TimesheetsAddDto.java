package com.wxj.domain.dto.timesheet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("工时表查询实体类")
public class TimesheetsAddDto{ 
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

	@ApiModelProperty("工时")
	private double day01;

	@ApiModelProperty("工时")
	private double day02;

	@ApiModelProperty("")
	private double day03;

	@ApiModelProperty("工时")
	private double day04;

	@ApiModelProperty("工时")
	private double day05;

	@ApiModelProperty("工时")
	private double day06;

	@ApiModelProperty("工时")
	private double day07;

	@ApiModelProperty("工时")
	private double day08;

	@ApiModelProperty("工时")
	private double day09;

	@ApiModelProperty("工时")
	private double day10;

	@ApiModelProperty("工时")
	private double day11;

	@ApiModelProperty("工时")
	private double day12;

	@ApiModelProperty("工时")
	private double day13;

	@ApiModelProperty("工时")
	private double day14;

	@ApiModelProperty("工时")
	private double day15;

	@ApiModelProperty("工时")
	private double day16;

	@ApiModelProperty("工时")
	private double day17;

	@ApiModelProperty("工时")
	private double day18;

	@ApiModelProperty("工时")
	private double day19;

	@ApiModelProperty("工时")
	private double day20;

	@ApiModelProperty("工时")
	private double day21;

	@ApiModelProperty("工时")
	private double day22;

	@ApiModelProperty("工时")
	private double day23;

	@ApiModelProperty("工时")
	private double day24;

	@ApiModelProperty("工时")
	private double day25;

	@ApiModelProperty("工时")
	private double day26;

	@ApiModelProperty("工时")
	private double day27;

	@ApiModelProperty("工时")
	private double day28;

	@ApiModelProperty("工时")
	private double day29;

	@ApiModelProperty("工时")
	private double day30;

	@ApiModelProperty("工时")
	private double day31;

	@ApiModelProperty("")
	private String createUser;

	@ApiModelProperty("")
	private Date createTime;

	@ApiModelProperty("")
	private Date modifyTime;

	@ApiModelProperty("")
	private String modifyUser;

}