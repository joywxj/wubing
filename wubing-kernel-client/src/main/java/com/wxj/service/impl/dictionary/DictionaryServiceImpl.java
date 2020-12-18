package com.wxj.service.impl.dictionary;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.wxj.dao.DictionaryMapper;
import com.wxj.domain.dto.dictionary.DictionaryAddDto;
import com.wxj.domain.dto.dictionary.DictionaryConditionDto;
import com.wxj.domain.dto.dictionary.DictionaryModifyDto;
import com.wxj.domain.entity.dictionary.Dictionary;
import com.wxj.domain.vo.dictionary.DictionaryVO;
import com.wxj.service.IDictionaryService;
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
@Service("dictionaryImpl")
public class DictionaryServiceImpl implements IDictionaryService {
	@Autowired
	private DictionaryMapper mapper;

	@Override
	public PageUtils<DictionaryVO> query(DictionaryConditionDto conditionDto) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
				PageUtils<DictionaryVO> page = new PageUtils<DictionaryVO>();

		paramMap = MapUtils.entityToMap(conditionDto, paramMap);
		List<Dictionary> list = mapper.select(paramMap);
		page.setTotalCount(list.size());
		page.setPageIndex(conditionDto.getPage());
		page.setPageSize(conditionDto.getSize());
		page.setPageInfo(paramMap, page.getBegin(), conditionDto.getSize());
		list = mapper.select(paramMap);
		List<DictionaryVO> resultList = new BeanCopyUtils().copyList(list,DictionaryVO.class);
		page.setList(resultList);
		return page;
	} 
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean add(DictionaryAddDto addDto) {
		Dictionary bean = new Dictionary();
		BeanUtils.copyProperties(addDto, bean);
		mapper.insert(bean);
		return true;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean modify(DictionaryModifyDto modifyDto) {
		Dictionary bean = new Dictionary();
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
	public DictionaryVO get(String id) {
		Dictionary bean =  mapper.get(id);
		DictionaryVO result = new DictionaryVO();
		BeanUtils.copyProperties(bean, result);
		return result;
	}

	@Override
	public List<DictionaryVO> list(DictionaryConditionDto conditionDto) {
		Map<String,Object> paramMap = new HashMap<>();
		MapUtils.entityToMap(conditionDto,paramMap);
		List<Dictionary> list = this.mapper.select(paramMap);
		List<DictionaryVO> result = BeanCopyUtils.copyList(list, DictionaryVO.class);
		return result;
	}
}