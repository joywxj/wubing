package com.wxj.domain.entity.work;

import lombok.Data;

/**
* <p>@ClassName:  WorkArea</p>
* <p>@Description:TODO</p>
* <p>@Modified:第一版本</p>
* <p>@author: wxj</p>
* <p>@date:2019-3-10 14:48:05</p>
* <p>@email: 18772118541@163.com</p>
*/
@Data
public class Construction{
	/***/
	private String id;
	/**工地名称*/
	private String areaName;
	/**工地描述*/
	private String areaDesc;
	/**工地负责人*/
	private String empId;
	/**项目干系人*/
	private String stakeholder;
	/**项目干系人电话*/
	private String stPhone;
	/**工地状态：1未完工，0完工*/
	private String status;
	/**工地地址*/
	private String areaAddress;
	/**创建时间*/
	private String createTime;
	/**更新时间*/
	private String updateTime;
	/**创建用户*/
	private String createUser;
	/**更新用户*/
	private String updateUser;
}