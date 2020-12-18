package com.wxj.dao;

import com.wxj.domain.entity.timesheet.Timesheets;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TimesheetsMapper {
	public List<Timesheets> select(Map<String, Object> paramMap);

	public Timesheets get(String id);
 
	public Integer update(Timesheets bean);

	public Integer insert(Timesheets bean);

	public Integer delete(String id);

    List<Timesheets> queryByPage(Map<String, Object> paramMap);
}