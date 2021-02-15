package com.wxj.dao;

import java.util.List;
import java.util.Map;

import com.wxj.domain.entity.Employee;
import com.wxj.domain.vo.employee.EmployeeVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* @ClassName:  EmployeeMapper
* @Description:TODO
* @Modified:第一版本
* @author: wxj
* @date:2018-12-26 21:33:48
* @email: 18772118541@163.com
*/
@Repository
public interface EmployeeMapper{
	/**
	 *查询Employee对象
	 *@param Employee 查询条件，通配
	 *@return List<Employee>
	 */
	public List<Employee> selectEmployee(Employee Employee);
	/**
	 *插入Employee对象
	 *@param Employee 插入数据
	 *@return
	 */
	public void insertEmployee(Employee Employee);
	/**
	 *删除Employee对象
	 *@param Employee 删除条件，通配
	 *@return
	 */
	public Integer deleteEmployee(Employee Employee);
	/**  
	* @Title: selectEmployeeCount  
	* @Description: TODO 条件查询总条数
	* @param parmMap
	* @return   
	* @date:2018-12-28 15:55
	*/
	public int selectEmployeeCount(Map<String, Object> parmMap);
	/**  
	* @Title: selectEmployeeByPage  
	* @Description: TODO
	* @param parmMap
	* @return   
	* @date:2018-12-28 16:00
	*/
	public List<Employee> selectEmployeeByPage(Map<String, Object> parmMap);
	/**  
	* @Title: selectMaxEmId  
	* @Description: TODO 查询最大的员工ID
	* @return   
	* @date:2019-01-01 13:16
	*/
	public Integer selectMaxEmId();
	/**  
	* @Title: updateEmployee  
	* @Description: TODO 更新员工信息
	* @param employee   
	* @date:2019-01-01 16:02
	*/
	public void updateEmployee(Employee employee);
	/**  
	* @Title: updateEmpoyeeByAreaId  
	* @Description: TODO update employee by contrustion info
	* @return  
	* @date:2019-03-11 09:40
	*/
	public int updateEmpoyeeByAreaId(Employee employee);

	/**
	 * 根据主键查询员工信息
	 * @param id
	 * @return
	 */
	Employee selectEmployeeById(@Param("id") Integer id);
}