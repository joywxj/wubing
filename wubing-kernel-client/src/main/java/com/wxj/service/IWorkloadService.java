package com.wxj.service;

import com.wxj.domain.dto.workload.WorkloadAddDto;
import com.wxj.domain.dto.workload.WorkloadConditionDto;
import com.wxj.domain.dto.workload.WorkloadModifyDto;

import com.wxj.domain.vo.workload.WorkloadVO;
import com.wxj.util.PageUtils;

public interface IWorkloadService {
	public PageUtils<WorkloadVO> query(WorkloadConditionDto conditionDto) ;

	public Boolean modify(WorkloadModifyDto modifyDto) ;


	public Boolean add(WorkloadAddDto addDto) ;

	public Boolean remove(String id) ;

	public WorkloadVO get(String id) ;

}
