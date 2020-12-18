package com.wxj.dao;

import java.util.List;
import java.util.Map;

import com.wxj.domain.entity.work.Construction;
import com.wxj.domain.vo.KeyValueVo;
import org.springframework.stereotype.Repository;

/**
* <p>@ClassName:  WorkAreaMapper</p>
* <p>@Description:TODO</p>
* <p>@Modified:第一版本</p>
* <p>@author: wxj</p>
* <p>@date:2019-3-10 14:30:08</p>
* <p>@email: 18772118541@163.com</p>
*/
@Repository
public interface ConstructionMapper{
	/**
	 *<p>查询WorkArea对象</p>
	 *<p>@param WorkArea 查询条件，通配</p>
	 *<p>@return List<WorkArea></p>
	 */
	public List<Construction> selectWorkArea(Construction WorkArea);
	/**
	 *<p>插入WorkArea对象</p>
	 *<p>@param WorkArea 插入数据</p>
	 *<p>@return</p>
	 */
	public int insertWorkArea(Construction WorkArea);
	/**
	 *<p>删除WorkArea对象</p>
	 *<p>@param WorkArea 删除条件，通配</p>
	 *<p>@return</p>
	 */
	public int deleteWorkArea(Construction WorkArea);
	/**  
	* <p>@Title: selectWorkDict  </p>
	* <p>@Description: TODO</p>
	* <p>@return   </p>
	* <p>@date:2019-03-10 14:41</p>
	*/
	public List<KeyValueVo> selectWorkDict();
	/**  
	* <p>@Title: updateWorkArea  </p>
	* <p>@Description: TODO update site info</p>
	* <p>@param workAre</p>
	* <p>@return   </p>
	* <p>@date:2019-03-11 09:52</p>
	*/
	public int updateWorkArea(Construction workAre);
	/**  
	* <p>@Title: selectWorkAreaByPage  </p>
	* <p>@Description: TODO query construction site info by page</p>
	* <p>@param workAre</p>
	* <p>@return   </p>
	* <p>@date:2019-03-11 10:07</p>
	*/
	public List<Construction> selectWorkAreaByPage(Map<String, Object> map);
	/**  
	* <p>方法名 queryEmployeeDic </p>
	* <p>方法描述: TODO</p>
	* <p>@return</p>   
	* <p>日期:2019-08-05 09:21</p>
	*/
	public List<KeyValueVo> queryEmployeeDic();
	/**  
	* <p>方法名 queryEmDictByadd </p>
	* <p>方法描述: TODO 添加的时候查询员工</p>
	* <p>@return</p>   
	* <p>日期:2019-08-05 10:18</p>
	*/
	public List<KeyValueVo> queryEmDictByadd();
}