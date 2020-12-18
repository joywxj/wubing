package com.wxj.domain.entity.salary;
/**
* @ClassName:  Salary
* @Description:TODO
* @Modified:第一版本
* @author: wxj
* @date:2019-8-22 9:44:03
* @email: 18772118541@163.com
*/
public class Salary{
	/***/
	private String id;
	/***/
	private String emId;
	/**工地id*/
	private String workId;
	/***/
	private String years;
	/***/
	private String months;
	/**工时*/
	private String timesheets;
	/**当月日薪*/
	private String daySalary;
	/**当月核算月薪*/
	private String monthSalary;
	/***/
	private String createTime;
	/***/
	private String updateTime;

	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getEmId(){
		return this.emId;
	}
	public void setEmId(String emId){
		this.emId=emId;
	}
	public String getWorkId(){
		return this.workId;
	}
	public void setWorkId(String workId){
		this.workId=workId;
	}
	public String getYears(){
		return this.years;
	}
	public void setYears(String years){
		this.years=years;
	}
	public String getMonths(){
		return this.months;
	}
	public void setMonths(String months){
		this.months=months;
	}
	public String getTimesheets(){
		return this.timesheets;
	}
	public void setTimesheets(String timesheets){
		this.timesheets=timesheets;
	}
	public String getDaySalary(){
		return this.daySalary;
	}
	public void setDaySalary(String daySalary){
		this.daySalary=daySalary;
	}
	public String getMonthSalary(){
		return this.monthSalary;
	}
	public void setMonthSalary(String monthSalary){
		this.monthSalary=monthSalary;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime=createTime;
	}
	public String getUpdateTime(){
		return this.updateTime;
	}
	public void setUpdateTime(String updateTime){
		this.updateTime=updateTime;
	}
}