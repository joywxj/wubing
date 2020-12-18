package com.wxj.service;

import com.wxj.domain.dto.timesheet.TimesheetsAddDto;
import com.wxj.domain.dto.timesheet.TimesheetsConditionDto;
import com.wxj.domain.dto.timesheet.TimesheetsModifyDto;
import com.wxj.domain.vo.timesheet.TimesheetsVO;
import com.wxj.util.PageUtils;

public interface ITimesheetsService {
	public PageUtils<TimesheetsVO> query(TimesheetsConditionDto conditionDto) ;

	public Boolean modify(TimesheetsModifyDto modifyDto) ;

	public Boolean add(TimesheetsAddDto addDto) ;

	public Boolean remove(String id) ;

	public TimesheetsVO get(String id) ;

	PageUtils<TimesheetsVO> queryByPage(TimesheetsConditionDto conditionDto);
}
