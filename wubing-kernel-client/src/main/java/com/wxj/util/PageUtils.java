package com.wxj.util;

import java.util.List;
import java.util.Map;

import com.wxj.common.Contans;

/**  
* @ClassName: PageUtils  
* @Description: TODO 分页工具类
* @author: wxj  
* @date: 2018-12-26 22:40
* @Tel:18772118541
* @email:18772118541@163.com
*/
public class PageUtils<T> {
	/** 当前页 **/
	private int pageIndex = Contans.PAGE_INDEX;
	/** 总页数 **/
	private int totalPage;
	/** 数据总条数 **/
	private int totalCount;
	/** 开始位置 **/
	private int begin;
	/**页面大小 **/
	private int pageSize = Contans.PAGE_SIZE;
	/** 任意数据的集合 **/
	private List<T> list;
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
		initBegin();
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		initTotalPage();
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		initTotalPage();
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	/**  
	* @Title: initBegin  
	* @Description: TODO  计算初始化开始位置 
	* @return void
	* @date:2018-12-26 22:50
	*/
	public void initBegin(){
		 this.begin = (this.pageIndex -1) * this.pageSize;
	}
	
	/**  
	* @Title: initTotalPage  
	* @Description: TODO  计算总页数 
	* @return void
	* @date:2018-12-26 22:50
	*/
	public void initTotalPage(){
		if(this.totalCount % this.pageSize == 0){
			this.totalPage = this.totalCount / this.pageSize;
		}else{
			this.totalPage = (this.totalCount / this.pageSize) +1;
		}
	}

	public Map<String,Object> removePageInfo(Map<String,Object> paramMap){
		paramMap.remove("begin");
		paramMap.remove("pageSize");
		return paramMap;
	}

	public Map<String,Object> setPageInfo(Map<String,Object> paramMap,Integer begin,Integer pageSize){
		paramMap.put("begin", begin);
		paramMap.put("pageSize",pageSize);
		return paramMap;
	}

}
