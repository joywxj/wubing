/**
 * 
 */
package com.wxj.service.impl.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wxj.domain.dto.bank.BankInfoAddDto;
import com.wxj.domain.dto.bank.BankInfoConditionDto;
import com.wxj.domain.dto.bank.BankInfoModifyDto;
import com.wxj.domain.vo.bank.BankInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxj.dao.BankInfoMapper;
import com.wxj.dao.DictionaryMapper;
import com.wxj.domain.entity.bank.BankInfo;
import com.wxj.service.IBankInfoService;
import com.wxj.util.MapUtils;
import com.wxj.util.PageUtils;

/**  
* <p>@ClassName: BankServiceImp  </p>
* <p>@Description: TODO 银行信息管理服务实现类</p>
* <p>@author: wxj  </p>
* <p>@date: 2019年3月7日</p>
* <p>@Tel:18772118541</p>
* <p>@email:18772118541@163.com</p>
*/
@Service
public class BankServiceImp implements IBankInfoService {
	@Autowired
	private BankInfoMapper bankInfoMapper;
	@Override
	public boolean addBankInfo(BankInfoAddDto bankInfo) {
		BankInfo bean = new BankInfo();
		BeanUtils.copyProperties(bankInfo, bean);
		bankInfoMapper.insertBankInfo(bean);
		return true;
	}
	@Override
	public boolean remove(String id) {
		BankInfo info = new BankInfo();
		info.setId(id);
		bankInfoMapper.deleteBankInfo(info);
		return true;
	}
	@Override
	public boolean modify(BankInfoModifyDto bankInfo) {
		BankInfo bean = new BankInfo();
		BeanUtils.copyProperties(bankInfo, bean);
		bankInfoMapper.updateBankInfo(bean);
		return true;
	}
	@Override
	public PageUtils<BankInfoVO> query(BankInfoConditionDto bankInfo) {
		PageUtils<BankInfoVO> page = new PageUtils<BankInfoVO>();
		page.setPageSize(bankInfo.getSize());
		page.setPageIndex(bankInfo.getPage());
		Map<String, Object> map = new HashMap<String, Object>();
		map = MapUtils.entityToMap(bankInfo, map);
		page.removePageInfo(map);
		List<BankInfo> list = bankInfoMapper.selectBankInfoByMap(map);

		//		map = page.setPageInfo(map, page);
		page.setTotalCount(list.size());
		list = bankInfoMapper.selectBankInfoByMap(map);
		ArrayList<BankInfoVO> resultList = new ArrayList<BankInfoVO>();
		for (BankInfo bank: list) {
			BankInfoVO infoVO = new BankInfoVO();
			BeanUtils.copyProperties(bank, infoVO);
			resultList.add(infoVO);
		}
		page.setList(resultList);
		return page;
	}

	/**
	 * @param id
	 * @return
	 * @Title: get
	 * @Description: TODO 查询单条银行信息
	 * @date:2019-03-08 10:04
	 */
	@Override
	public BankInfoVO get(String id) {
		BankInfoVO bean = bankInfoMapper.selectById(id);
		return bean;
	}

}
