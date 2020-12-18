package com.wxj.dao;

import java.util.List;
import java.util.Map;

import com.wxj.domain.entity.salary.Salary;
/**
* @ClassName:  SalaryMapper
* @Description:TODO
* @Modified:第一版本
* @author: wxj
* @date:2019-8-22 9:44:03
* @email: 18772118541@163.com
*/
public interface SalaryMapper{
	/**
	 *查询Salary对象
	 *@param Salary 查询条件，通配
	 *@return List<Salary>
	 */
	public List<Salary> selectSalary(Salary Salary);
	/**
	 *插入Salary对象
	 *@param Salary 插入数据
	 *@return
	 */
	public int insertSalary(Salary Salary);
	/**
	 *删除Salary对象
	 *@param Salary 删除条件，通配
	 *@return
	 */
	public int deleteSalary(Salary Salary);
	/**  
	* <p>方法名 selectSalaryByMap </p>
	* <p>方法描述: TODO</p>
	* <p>@param parms
	* <p>@return</p>   
	* <p>日期:2019-08-23 14:30</p>
	*/
	public List<Salary> selectSalaryByMap(Map<String, Object> parms);
}