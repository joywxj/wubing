package com.wxj.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wxj.dao.SalaryMapper;
import com.wxj.dao.TimesheetsMapper;
import com.wxj.domain.entity.salary.Salary;
import com.wxj.util.SpringUtils;
/**  
* <p>@ClassName: SalaryJob  </p>
* <p>@Description: TODO 计算薪资的Job</p>
* <p>@author: wxj  </p>
* <p>@date: 2019年3月8日</p>
* <p>@Tel:18772118541</p>
* <p>@email:18772118541@163.com</p>
*/
public class SalaryJob {
	static TimesheetsMapper timeSheetMapper;
	static SalaryMapper salaryMapper;
	static {
		timeSheetMapper = SpringUtils.getBean(TimesheetsMapper.class);
		salaryMapper = SpringUtils.getBean(SalaryMapper.class);
	}
	public void excute() {
		/**
		 * 1:查询上一个月所有有考勤记录的员工的考勤
		 * 2：根据员工的考勤工时去和薪资等级去计算每个员工的工资
		 */
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		//年
		int year = Integer.parseInt( format.format(date));
		format = new SimpleDateFormat("MM");
		//月
		int mounths = Integer.parseInt( format.format(date)) - 1;
		if( mounths == 0) {
			year = year -1;
			mounths = 12;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", year);
		map.put("mounth", mounths);
//		List<Salary> sheetList = timeSheetMapper.selectTimesheetsByTime(map);
//		for (Salary salary : sheetList) {
//			salaryMapper.insertSalary(salary);
//		}
		System.out.println("Job is over");
	}
}
