package com.wxj.util;

/**  
* @ClassName: ResultObject  
* @Description: TODO 返回结果公共类
* @author: wxj  
* @date: 2018-12-26 22:19
* @Tel:18772118541
* @email:18772118541@163.com
*/
public class ResultObject {
	/** 状态**/
	private Integer status = 1;
	/** 任意对象 **/
	private Object obj;
	
	public ResultObject(Integer status, Object obj) {
		this.status = status;
		this.obj = obj;
	}
	public ResultObject(Integer status) {
		this.status = status;
	}
	public ResultObject(Object obj) {
		this.obj = obj;
	}
	public ResultObject() {
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
