package com.wxj.domain.entity;

import lombok.Data;

/**
* <p>@ClassName: SalaryRecord  </p>
* <p>@Description: TODO 薪资等级记录表</p>
* <p>@author: wxj  </p>
* <p>@date: 2019年1月1日</p>
* <p>@Tel:18772118541</p>
* <p>@email:18772118541@163.com</p>
*/
@Data
public class SalaryRecord {
	/** 主键 */
	private String id;
	/** 原薪资等级  */
	private String beforeGreade;
	/** 更改后的薪资等级 */
	private String afterGreade;
	/** 员工id */
	private Integer emId;
	/** 更新描述 */
	private String changeDesc;
	/** 创建时间*/
	private String createTime;
	/** 变更原因 */
	private String reason;

}
