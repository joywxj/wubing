package com.wxj.service;

import java.util.List;

import com.wxj.domain.dto.employee.EmployeeAddDto;
import com.wxj.domain.dto.employee.EmployeeConditionDto;
import com.wxj.domain.dto.employee.EmployeeModifyDto;
import com.wxj.domain.entity.Employee;
import com.wxj.domain.entity.dictionary.Dictionary;
import com.wxj.domain.vo.employee.EmployeeVo;
import com.wxj.util.PageUtils;
import com.wxj.util.ResultObject;

import javax.servlet.http.HttpSession;

public interface EmployeeService {

	/**  
	* @Title: query  
	* @Description: TODO 查询
	* @param emp
	* @return   
	* @return ResultObject
	* @date:2018-12-26 22:30
	*/
	ResultObject query(Employee emp);

	PageUtils<EmployeeVo> queryByPage(EmployeeConditionDto condition);

	/**  
	* @Title: add  
	* @Description: TODO 添加员工
	* @param employee   
	* @date:2019-01-01 13:14
	*/
	int add(EmployeeAddDto employee);

	/**  
	* @Title: modify  
	* @Description: TODO 更新员工贪信息
	* @param employee   
	* @date:2019-01-01 15:47
	*/
	void modify(EmployeeModifyDto employee);

	/**  
	* @Title: querySalaryGrade  
	* @Description: TODO 查询薪资等级集合
	* @return   
	* @date:2019-01-20 14:42
	*/
	List<Dictionary> querySalaryGrade();

	/**  
	* @Title: verifyID  
	* @Description: TODO 校验身份证号
	* @param identity
	* @return   
	* @date:2019-01-20 18:30
	*/
	boolean verifyID(String identity);

	/**  
	* @Title: login  
	* @Description: TODO 登录
	* @param employee
	* @return   
	* @date:2019-03-07 15:35
	*/
	boolean login(Employee employee, HttpSession session);

	/**  
	* @Title: resetPassowrd  
	* @Description: TODO 重置密码
	* @param employee
	* @return   
	* @date:2019-03-07 15:52
	*/
	boolean resetPassowrd(Employee employee);

	/**  
	* @Title: mofifyPassword  
	* @Description: TODO 修改密码
	* @param employee
	* @return   
	* @date:2019-03-07 16:12
	*/
	boolean mofifyPassword(Employee employee,String newPassword) throws Exception ;

	/**  
	* @Title: queryById  
	* @Description: TODO 根据id查询员工信息
	* @param id
	* @return   
	* @date:2019-05-16 09:55
	*/
	Employee queryById(String id);

	/**  
	* @Title: remove  
	* @Description: TODO 根据id删除员工
	* @param id
	* @return   
	* @date:2019-05-19 10:25
	*/
	int remove(String id);

}
