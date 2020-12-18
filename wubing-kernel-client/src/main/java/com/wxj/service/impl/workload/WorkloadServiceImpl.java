package com.wxj.service.impl.workload;

import com.wxj.dao.WorkloadMapper;
import com.wxj.domain.dto.workload.WorkloadAddDto;
import com.wxj.domain.dto.workload.WorkloadConditionDto;
import com.wxj.domain.entity.workload.Workload;
import com.wxj.domain.vo.workload.WorkloadVO;
import com.wxj.service.IWorkloadService;
import com.wxj.util.BeanCopyUtils;
import com.wxj.util.MapUtils;
import com.wxj.util.PageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wxj.domain.dto.workload.WorkloadModifyDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("workloadImpl")
public class WorkloadServiceImpl implements IWorkloadService {
	@Autowired
	private WorkloadMapper mapper;

	@Override
	public PageUtils<WorkloadVO> query(WorkloadConditionDto conditionDto) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		PageUtils<WorkloadVO> page = new PageUtils<WorkloadVO>();

		paramMap = MapUtils.entityToMap(conditionDto, paramMap);
		List<Workload> list = mapper.select(paramMap);
		page.setTotalCount(list.size());
		page.setPageIndex(conditionDto.getPage());
		page.setPageSize(conditionDto.getSize());
		page.setPageInfo(paramMap, page.getBegin(), conditionDto.getSize());
		list = mapper.select(paramMap);
		List<WorkloadVO> resultList = new BeanCopyUtils().copyList(list,WorkloadVO.class);
		page.setList(resultList);
		return page;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean add(WorkloadAddDto addDto) {
		Workload bean = new Workload();
		BeanUtils.copyProperties(addDto, bean);
		mapper.insert(bean);
		return true;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean modify(WorkloadModifyDto modifyDto) {
		Workload bean = new Workload();
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
	public WorkloadVO get(String id) {
		Workload bean =  mapper.get(id);
		WorkloadVO result = new WorkloadVO();
		BeanUtils.copyProperties(bean, result);
		return result;
	}
}