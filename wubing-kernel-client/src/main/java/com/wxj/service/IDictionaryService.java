package com.wxj.service;

import com.wxj.domain.dto.dictionary.DictionaryAddDto;
import com.wxj.domain.dto.dictionary.DictionaryConditionDto;
import com.wxj.domain.dto.dictionary.DictionaryModifyDto;
import com.wxj.domain.vo.dictionary.DictionaryVO;
import com.wxj.util.PageUtils;

import java.util.List;

public interface IDictionaryService {
	public PageUtils<DictionaryVO> query(DictionaryConditionDto conditionDto) ;

	public Boolean modify(DictionaryModifyDto modifyDto) ;

	public Boolean add(DictionaryAddDto addDto) ;

	public Boolean remove(String id) ;

	public DictionaryVO get(String id) ;

	List<DictionaryVO> list(DictionaryConditionDto conditionDto);
}
