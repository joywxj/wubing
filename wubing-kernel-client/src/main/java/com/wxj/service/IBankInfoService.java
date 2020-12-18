package com.wxj.service;

import java.util.List;

import com.wxj.domain.dto.bank.BankInfoAddDto;
import com.wxj.domain.dto.bank.BankInfoConditionDto;
import com.wxj.domain.dto.bank.BankInfoModifyDto;
import com.wxj.domain.entity.bank.BankInfo;
import com.wxj.domain.entity.dictionary.Dictionary;
import com.wxj.domain.vo.KeyValueVo;
import com.wxj.domain.vo.bank.BankInfoVO;
import com.wxj.util.PageUtils;

/**  
* @ClassName: BankService  
* @Description: TODO
* @author: wxj  
* @date: 2019年3月7日
* @Tel:18772118541
* @email:18772118541@163.com
*/
public interface IBankInfoService {

	/**  
	* @Title: addBankInfo  
	* @Description: TODO 添加银行卡信息
	* @param bankInfo
	* @return   
	* @date:2019-03-07 17:00
	*/
	boolean addBankInfo(BankInfoAddDto bankInfo);

	/**  
	* @Title: remove  
	* @Description: TODO
	* @param id
	* @return   
	* @date:2019-03-07 17:15
	*/
	boolean remove(String id);

	/**  
	* @Title: modify  
	* @Description: TODO
	* @param bankInfo
	* @return   
	* @date:2019-03-07 17:17
	*/
	boolean modify(BankInfoModifyDto bankInfo);

	/**  
	* @Title: query  
	* @Description: TODO
	* @param bankInfo
	* @return   
	* @date:2019-03-08 10:04
	*/
	PageUtils<BankInfoVO> query(BankInfoConditionDto bankInfo);
	/**
	 * @Title: get
	 * @Description: TODO 查询单条银行信息
	 * @param id
	 * @return
	 * @date:2019-03-08 10:04
	 */
    public BankInfoVO get(String id);
}
