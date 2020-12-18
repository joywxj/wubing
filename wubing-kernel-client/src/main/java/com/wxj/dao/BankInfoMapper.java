package com.wxj.dao;

import java.util.List;
import java.util.Map;

import com.wxj.domain.entity.bank.BankInfo;
import com.wxj.domain.vo.bank.BankInfoVO;
import org.springframework.stereotype.Repository;

/**
* <p>@ClassName:  BankInfoMapper</p>
* <p>@Description:TODO</p>
* <p>@Modified:第一版本</p>
* <p>@author: wxj</p>
* <p>@date:2019-3-7 16:51:53</p>
* <p>@email: 18772118541@163.com</p>
*/
@Repository
public interface BankInfoMapper{
	/**
	 *<p>查询BankInfo对象</p>
	 *<p>@param BankInfo 查询条件，通配</p>
	 *<p>@return List<BankInfo></p>
	 */
	public List<BankInfo> selectBankInfo(BankInfo BankInfo);
	/**
	 *<p>插入BankInfo对象</p>
	 *<p>@param BankInfo 插入数据</p>
	 *<p>@return</p>
	 */
	public void insertBankInfo(BankInfo BankInfo);
	/**
	 *<p>删除BankInfo对象</p>
	 *<p>@param BankInfo 删除条件，通配</p>
	 *<p>@return</p>
	 */
	public void deleteBankInfo(BankInfo BankInfo);
	/**  
	* <p>@Title: updateBankInfo  </p>
	* <p>@Description: TODO 修改</p>
	* <p>@param bankInfo   </p>
	* <p>@date:2019-03-07 17:17</p>
	*/
	public void updateBankInfo(BankInfo bankInfo);
	/**  
	* <p>@Title: selectBankInfoByMap  </p>
	* <p>@Description: TODO 条件查询</p>
	* <p>@param map   </p>
	* <p>@date:2019-03-08 10:10</p>
	*/
	public List<BankInfo> selectBankInfoByMap(Map<String, Object> map);

    BankInfoVO selectById(String id);
}