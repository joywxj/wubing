package com.wxj.domain.entity.bank;

import com.wxj.util.PageUtils;
import lombok.Data;

/**
* <p>@ClassName:  BankInfo</p>
* <p>@Description:TODO</p>
* <p>@Modified:第一版本</p>
* <p>@author: wxj</p>
* <p>@date:2019-3-7 16:51:53</p>
* <p>@email: 18772118541@163.com</p>
*/
@Data
public class BankInfo {
	private String id;
	/**银行卡号*/
	private String bankCard;
	/**银行名称*/
	private String bankName;
	/**开户行*/
	private String bankDeposit;
	/**1:常用0，备用*/
	private String sign;
	/**银行地址*/
	private String bankAddress;
	/**员工id*/
	private String emId;
	/**修改时间*/
	private String updateTime;
	/**创建时间*/
	private String createTime;
}