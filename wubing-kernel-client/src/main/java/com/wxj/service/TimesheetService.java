package com.wxj.service;

import com.wxj.domain.entity.timesheet.Timesheets;
import com.wxj.util.PageUtils;

/**  
* <p>类名: TimesheetService  </p>
* <p>描述: TODO 工时服务接口类</p>
* <p>作者:吴兴军</p>
* <p>电话:18772118541</p>
* <p>邮箱:18772118541@163.com</p>
* <p>日期: 2019-06-13 11:50</p>
*/
public interface TimesheetService {

	/**  
	* <p>方法名 modify </p>
	* <p>方法描述: TODO 修改工时信息</p>
	* <p>@param time
	* <p>@return</p>   
	* <p>日期:2019-06-13 11:53</p>
	*/
	int modify(Timesheets time);

	/**  
	* <p>方法名 remove </p>
	* <p>方法描述: TODO 删除工时</p>
	* <p>@param time
	* <p>@return</p>   
	* <p>日期:2019-06-13 14:15</p>
	*/
	int remove(Timesheets time);

	/**  
	* <p>方法名 query </p>
	* <p>方法描述: TODO 查询工时 </p>
	* <p>@param time
	* <p>@param page
	* <p>@return</p>   
	* <p>日期:2019-06-13 14:20</p>
	*/
	PageUtils<Timesheets> query(Timesheets time, PageUtils<Timesheets> page);

}
