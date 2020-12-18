package com.wxj.domain.vo.employee;

import com.wxj.domain.entity.Employee;
import lombok.Data;

import java.util.Date;

/**  
* <p>@ClassName: EmployeeVo </p> 
*<p> @Description: TODO</p>
*<p> @author: wxj  </p>
* <p>@date: 2019年1月1日</p>
* <p>@Tel:18772118541</p>
* <p>@email:18772118541@163.com</p>
*/
@Data
public class EmployeeVo {
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
	private Date createTime;
	/**修改时间*/
	private Date updateTime;
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

	private String slary;
}
