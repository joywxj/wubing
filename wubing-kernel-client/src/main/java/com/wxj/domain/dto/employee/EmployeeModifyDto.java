package com.wxj.domain.dto.employee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>@Author: wxj</p>
 * <p>@Description:</p>
 * <p>@commpany: 吴氏集团</p>
 * <p>@Date:Create：in  2020/9/21 0021 下午 10:39</p>
 * <p>@Modified By：wxj</p>
 **/
@Data
@ApiModel("员工修改DTO")
public class EmployeeModifyDto {
    @ApiModelProperty(value="主键")
    private Integer id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private String age;

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("登录用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("薪资等级")
    private String salaryGrade;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("修改时间")
    private String updateTime;

    @ApiModelProperty("通讯地址")
    private String commAddress;

    @ApiModelProperty("家庭住址")
    private String homeAddress;

    @ApiModelProperty("状态：1在职，0离职")
    private String status;

    @ApiModelProperty("身份证号")
    private String identity;

    @ApiModelProperty("工地id")
    private String workId;

    @ApiModelProperty("薪资变化理由")
    private String reason;
}