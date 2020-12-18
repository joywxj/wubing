package com.wxj.domain.entity;

/**  
* <p>@ClassName: SalaryRecord  </p>
* <p>@Description: TODO 薪资等级记录表</p>
* <p>@author: wxj  </p>
* <p>@date: 2019年1月1日</p>
* <p>@Tel:18772118541</p>
* <p>@email:18772118541@163.com</p>
*/
public class SalaryRecord {
	/** 主键 */
	private String id;
	/** 原薪资等级  */
	private String beforeGreade;
	/** 更改后的薪资等级 */
	private String afterGreade;
	/** 员工id */
	private String emId;
	/** 更新描述 */
	private String changeDesc;
	/** 创建时间*/
	private String createTime;
	/** 变更原因 */
	private String reason;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBeforeGreade() {
		return beforeGreade;
	}
	public void setBeforeGreade(String beforeGreade) {
		this.beforeGreade = beforeGreade;
	}
	public String getAfterGreade() {
		return afterGreade;
	}
	public void setAfterGreade(String afterGreade) {
		this.afterGreade = afterGreade;
	}
	public String getEmId() {
		return emId;
	}
	public void setEmId(String emId) {
		this.emId = emId;
	}
	public String getChangeDesc() {
		return changeDesc;
	}
	public void setChangeDesc(String changeDesc) {
		this.changeDesc = changeDesc;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "SalaryRecord [id=" + id + ", beforeGreade=" + beforeGreade + ", afterGreade=" + afterGreade + ", emId="
				+ emId + ", changeDesc=" + changeDesc + ", createTime=" + createTime + ", reason=" + reason + "]";
	}
}
