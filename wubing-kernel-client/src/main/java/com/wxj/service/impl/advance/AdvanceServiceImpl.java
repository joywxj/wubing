package com.wxj.service.impl.advance;

import com.wxj.dao.AdvanceMapper;
import com.wxj.domain.dto.advance.AdvanceAddDto;
import com.wxj.domain.dto.advance.AdvanceConditionDto;
import com.wxj.domain.dto.advance.AdvanceModifyDto;
import com.wxj.domain.entity.advance.Advance;
import com.wxj.domain.vo.advance.AdvanceVO;
import com.wxj.service.IAdvanceService;
import com.wxj.util.BeanConvertUtils;
import com.wxj.util.BeanCopyUtils;
import com.wxj.util.MapUtils;
import com.wxj.util.PageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdvanceServiceImpl implements IAdvanceService {
	@Autowired
	private AdvanceMapper mapper;
	@Override
	public PageUtils<AdvanceVO> query(AdvanceConditionDto conditionDto) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		PageUtils<AdvanceVO> page = new PageUtils<AdvanceVO>();

		paramMap = MapUtils.entityToMap(conditionDto, paramMap);
		List<Advance> list = mapper.select(paramMap);
		page.setTotalCount(list.size());
		page.setPageIndex(conditionDto.getPage());
		page.setPageSize(conditionDto.getSize());
		page.setPageInfo(paramMap, page.getBegin(), conditionDto.getSize());
		list = mapper.select(paramMap);
		List<AdvanceVO> resultList = new BeanCopyUtils().copyList(list,AdvanceVO.class);
//		List<AdvanceVO> resultList = BeanConvertUtils.convertListTo(list, AdvanceVO::new);
		page.setList(resultList);
		return page;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean add(AdvanceAddDto addDto) {
		Advance bean = new Advance();
		BeanUtils.copyProperties(addDto, bean);
		mapper.insert(bean);
		return true;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean modify(AdvanceModifyDto modifyDto) {
		Advance bean = new Advance();
		BeanUtils.copyProperties(modifyDto, bean);
		mapper.update(bean);
		return true;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean remove(String id) {
		mapper.delete(id);
		return true;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public AdvanceVO get(String id) {
		Advance bean =  mapper.get(id);
		AdvanceVO result = new AdvanceVO();
		BeanUtils.copyProperties(bean, result);
		return result;
	}
}