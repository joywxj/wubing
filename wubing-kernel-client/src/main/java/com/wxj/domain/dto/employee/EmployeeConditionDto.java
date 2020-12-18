package com.wxj.domain.dto.employee;

import com.wxj.domain.entity.Employee;
import com.wxj.util.PageUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>@Author: wxj</p>
 * <p>@Description:</p>
 * <p>@commpany: 吴氏集团</p>
 * <p>@Date:Create：in  2020/9/17 0017 下午 10:50</p>
 * <p>@Modified By：wxj</p>
 **/
@Data
public class EmployeeConditionDto {
    /***/
    private String id;
    /**姓名*/
    private String name;
    /**年龄*/
    private String age;
    /**电话号码*/
    private String phone;
    /**登录用户名*/
    private String userName;
    /**密码*/
    private String password;
    /**薪资等级*/
    private String salaryGrade;
    /**创建时间*/
    private String createTime;
    /**修改时间*/
    private String updateTime;
    /** 通讯地址*/
    private String commAddress;
    /** 家庭住址 */
    private String homeAddress;
    /** 状态：1在职，0离职 */
    private String status;
    /** 身份证号 */
    private String identity;
    /** 工地id */
    private String workId;
    @ApiModelProperty("当前页")
    private Integer page;
    @ApiModelProperty("当前页面大小")
    private Integer size;
}