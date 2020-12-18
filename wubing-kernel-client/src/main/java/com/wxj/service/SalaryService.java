package com.wxj.service;

import com.wxj.domain.entity.salary.Salary;
import com.wxj.util.PageUtils;

/**  
* <p>类名: SalaryService  </p>
* <p>描述: TODO</p>
* <p>作者:吴兴军</p>
* <p>电话:18772118541</p>
* <p>邮箱:18772118541@163.com</p>
* <p>日期: 2019-08-23 14:07</p>
*/
public interface SalaryService {

	/**  
	* <p>方法名 query </p>
	* <p>方法描述: TODO 查询薪资</p>
	* <p>@param salary
	* <p>@param page
	* <p>@return</p>   
	* <p>日期:2019-08-23 14:09</p>
	*/
	PageUtils<Salary> query(Salary salary, PageUtils<Salary> page);

}
