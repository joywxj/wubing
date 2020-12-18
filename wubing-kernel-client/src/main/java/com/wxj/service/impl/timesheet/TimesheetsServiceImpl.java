package com.wxj.service.impl.timesheet;

import com.wxj.dao.TimesheetsMapper;
import com.wxj.domain.dto.timesheet.TimesheetsAddDto;
import com.wxj.domain.dto.timesheet.TimesheetsConditionDto;
import com.wxj.domain.dto.timesheet.TimesheetsModifyDto;
import com.wxj.domain.entity.timesheet.Timesheets;
import com.wxj.domain.vo.timesheet.TimesheetsVO;
import com.wxj.service.ITimesheetsService;
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
@Service("timesheetsImpl")
public class TimesheetsServiceImpl implements ITimesheetsService {
	@Autowired
	private TimesheetsMapper mapper;

	@Override
	public PageUtils<TimesheetsVO> query(TimesheetsConditionDto conditionDto) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
				PageUtils<TimesheetsVO> page = new PageUtils<TimesheetsVO>();

		paramMap = MapUtils.entityToMap(conditionDto, paramMap);
		List<Timesheets> list = mapper.select(paramMap);
		page.setTotalCount(list.size());
		page.setPageIndex(conditionDto.getPage());
		page.setPageSize(conditionDto.getSize());
		page.setPageInfo(paramMap, page.getBegin(), conditionDto.getSize());
		list = mapper.select(paramMap);
		List<TimesheetsVO> resultList = new BeanCopyUtils().copyList(list,TimesheetsVO.class);
		page.setList(resultList);
		return page;
	} 
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean add(TimesheetsAddDto addDto) {
		Timesheets bean = new Timesheets();
		BeanUtils.copyProperties(addDto, bean);
		mapper.insert(bean);
		return true;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean modify(TimesheetsModifyDto modifyDto) {
		Timesheets bean = new Timesheets();
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
	public TimesheetsVO get(String id) {
		Timesheets bean =  mapper.get(id);
		TimesheetsVO result = new TimesheetsVO();
		BeanUtils.copyProperties(bean, result);
		return result;
	}

	@Override
	public PageUtils<TimesheetsVO> queryByPage(TimesheetsConditionDto conditionDto) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		PageUtils<TimesheetsVO> page = new PageUtils<TimesheetsVO>();

		paramMap = MapUtils.entityToMap(conditionDto, paramMap);
		List<Timesheets> list = mapper.queryByPage(paramMap);
		page.setTotalCount(list.size());
		page.setPageIndex(conditionDto.getPage());
		page.setPageSize(conditionDto.getSize());
		page.setPageInfo(paramMap, page.getBegin(), conditionDto.getSize());
		list = mapper.queryByPage(paramMap);
		List<TimesheetsVO> resultList = new BeanCopyUtils().copyList(list,TimesheetsVO.class);
		page.setList(resultList);
		return page;
	}
}