/**
 * 
 */
package com.wxj.service;

import java.util.List;

import com.wxj.domain.entity.work.Construction;
import com.wxj.domain.vo.KeyValueVo;
import com.wxj.util.PageUtils;

/**  
* <p>@ClassName: WorkService  </p>
* <p>@Description: TODO</p>
* <p>@author: wxj  </p>
* <p>@date: 2019年3月10日</p>
* <p>@Tel:18772118541</p>
* <p>@email:18772118541@163.com</p>
*/
public interface WorkService {

	/**  
	* <p>@Title: getWorkDict  </p>
	* <p>@Description: TODO 查询工地字典</p>
	* <p>@return   </p>
	* <p>@date:2019-03-10 14:40</p>
	*/
	List<KeyValueVo> getWorkDict();

	/**  
	* <p>@Title: add  </p>
	* <p>@Description: TODO 工地信息添加</p>
	* <p>@param workAre</p>
	* <p>@return   </p>
	* <p>@date:2019-03-10 15:00</p>
	*/
	int add(Construction workAre);

	/**  
	* <p>@Title: remove  </p>
	* <p>@Description: TODO delete the contrustion site info</p>
	* <p>@param workAre</p>
	* <p>@return   </p>
	* <p>@date:2019-03-11 09:36</p>
	*/
	int remove(Construction workAre);

	/**  
	* <p>@Title: modify  </p>
	* <p>@Description: TODO modify site info</p>
	* <p>@param workAre</p>
	* <p>@return   </p>
	* <p>@date:2019-03-11 09:50</p>
	*/
	int modify(Construction workAre);

	/**  
	* <p>@Title: query  </p>
	* <p>@Description: TODO query contrustion site info</p>
	* <p>@param workAre</p>
	* <p>@param page</p>
	* <p>@return   </p>
	* <p>@date:2019-03-11 10:02</p>
	*/
	PageUtils<Construction> query(Construction workAre, PageUtils<Construction> page);

	/**  
	* <p>方法名 queryEmployeeDic </p>
	* <p>方法描述: TODO 查询的时候查询员工字典</p>
	* <p>@return</p>   
	* <p>日期:2019-08-05 09:20</p>
	*/
	List<KeyValueVo> queryEmployeeDic();

	/**  
	* <p>方法名 queryEmDictByadd </p>
	* <p>方法描述: TODO 添加的时候查询员工字典</p>
	* <p>@return</p>   
	* <p>日期:2019-08-05 10:17</p>
	*/
	List<KeyValueVo> queryEmDictByadd();

	/**  
	* <p>方法名 queryById </p>
	* <p>方法描述: TODO</p>
	* <p>@param id
	* <p>@return</p>   
	* <p>日期:2019-08-09 19:27</p>
	*/
	Construction queryById(String id);

}
