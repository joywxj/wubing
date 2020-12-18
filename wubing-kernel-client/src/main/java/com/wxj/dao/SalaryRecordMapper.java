package com.wxj.dao;

import com.wxj.domain.entity.SalaryRecord;
import org.springframework.stereotype.Repository;

/**
* @ClassName:  EmployeeMapper
* @Description:TODO
* @Modified:第一版本
* @author: wxj
* @date:2018-12-26 21:33:48
* @email: 18772118541@163.com
*/
@Repository("salaryRecordMapper")
public interface SalaryRecordMapper{
	public void insertSalaryRecord(SalaryRecord salaryRecord);
}