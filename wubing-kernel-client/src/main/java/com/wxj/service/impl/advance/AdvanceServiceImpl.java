package com.wxj.service.impl.advance;

import com.wxj.dao.AdvanceMapper;
import com.wxj.dao.AuditLogMapper;
import com.wxj.dao.EmployeeMapper;
import com.wxj.domain.dto.advance.AdvanceAddDto;
import com.wxj.domain.dto.advance.AdvanceConditionDto;
import com.wxj.domain.dto.advance.AdvanceModifyDto;
import com.wxj.domain.entity.Employee;
import com.wxj.domain.entity.advance.Advance;
import com.wxj.domain.entity.audit.AuditLog;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdvanceServiceImpl implements IAdvanceService {
	@Autowired
	private AdvanceMapper mapper;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private AuditLogMapper auditLogMapper;
	@Override
	public PageUtils<Advance> query(AdvanceConditionDto conditionDto) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		PageUtils<Advance> page = new PageUtils<Advance>();

		paramMap = MapUtils.entityToMap(conditionDto, paramMap);
		List<Advance> list = mapper.select(paramMap);
		page.setTotalCount(list.size());
		page.setPageIndex(conditionDto.getPage());
		page.setPageSize(conditionDto.getSize());
		page.setPageInfo(paramMap, page.getBegin(), conditionDto.getSize());
		list = mapper.select(paramMap);

		for (Advance advance: list) {
			Integer emId = advance.getEmId();
			Employee employee = employeeMapper.selectEmployeeById(emId);
			advance.setEmName(employee.getName());
		}

		page.setList(list);
		return page;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean add(Advance addDto) {
		addDto.setAuditTag("wait");
		mapper.insert(addDto);
		return true;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean modify(Advance modifyDto) {
		mapper.update(modifyDto);
		return true;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean remove(String id) {
		mapper.delete(id);
		return true;
	}
	@Override
	public Advance get(String id) {
		Advance bean =  mapper.get(id);
		return bean;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void audit(Advance modifyDto) {
		String userId = "8";
		AuditLog auditLog = new AuditLog();
		auditLog.setAuditDict("advance");
		auditLog.setAuditMessage(modifyDto.getAuditMessage());
		auditLog.setAuditTag(modifyDto.getAuditTag());
		auditLog.setCreateTime(new Date());
		auditLog.setCreateUser(userId);
		auditLogMapper.insert(auditLog);

		mapper.update(modifyDto);
	}
}