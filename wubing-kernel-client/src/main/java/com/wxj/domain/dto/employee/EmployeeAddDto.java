package com.wxj.domain.dto.employee;

import com.wxj.domain.entity.Employee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>@Author: wxj</p>
 * <p>@Description:</p>
 * <p>@commpany: 吴氏集团</p>
 * <p>@Date:Create：in  2020/9/21 0021 下午 10:03</p>
 * <p>@Modified By：wxj</p>
 **/
@Data
@ApiModel("添加员工DTO")
public class EmployeeAddDto  {

    @ApiModelProperty(value="主键")
    private String id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private String age;
    /**电话号码*/
    @ApiModelProperty("电话号码")
    private String phone;
    /**登录用户名*/
    @ApiModelProperty("登录用户名")
    private String userName;
    /**密码*/
    @ApiModelProperty("密码")
    private String password;
    /**薪资等级*/
    @ApiModelProperty("薪资等级")
    private String salaryGrade;
    /**创建时间*/
    @ApiModelProperty("创建时间")
    private String createTime;
    /**修改时间*/
    @ApiModelProperty("修改时间")
    private String updateTime;
    /** 通讯地址*/
    @ApiModelProperty("通讯地址")
    private String commAddress;
    /** 家庭住址 */
    @ApiModelProperty("家庭住址")
    private String homeAddress;
    /** 状态：1在职，0离职 */
    @ApiModelProperty("状态：1在职，0离职")
    private String status;
    /** 身份证号 */
    @ApiModelProperty("身份证号")
    private String identity;
    /** 工地id */
    @ApiModelProperty("工地id")
    private String workId;
}