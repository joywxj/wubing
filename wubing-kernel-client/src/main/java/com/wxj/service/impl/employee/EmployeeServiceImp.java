package com.wxj.service.impl.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.mchange.v1.identicator.IdWeakHashMap;
import com.wxj.domain.dto.employee.EmployeeAddDto;
import com.wxj.domain.dto.employee.EmployeeConditionDto;
import com.wxj.domain.dto.employee.EmployeeModifyDto;
import com.wxj.domain.vo.workload.WorkloadVO;
import com.wxj.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxj.dao.EmployeeMapper;
import com.wxj.dao.SalaryRecordMapper;
import com.wxj.domain.entity.Employee;
import com.wxj.domain.entity.SalaryRecord;
import com.wxj.domain.entity.dictionary.Dictionary;
import com.wxj.domain.vo.employee.EmployeeVo;
import com.wxj.service.EmployeeService;
import com.wxj.common.Contans;
import com.wxj.dao.DictionaryMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * <p>@ClassName: EmployeeServiceImp</p>
 * <p>@Description: TODO 员工管理服务实现类</p>
 * <p>@author: wxj</p>
 * <p>@date: 2018-12-26 22:28</p>
 * <p>@Tel:18772118541</p>
 * <p>@email:18772118541@163.com</p>
 */
@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private SalaryRecordMapper salaryRecordMapper;
	@Autowired
	private DictionaryMapper DictionaryMapper;

	@Override
	public ResultObject query(Employee emp) {
		List<Employee> selectEmployee = employeeMapper.selectEmployee(emp);
		ResultObject result = new ResultObject(selectEmployee.get(0));
		return result;
	}

	@Override
	public PageUtils<EmployeeVo> queryByPage(EmployeeConditionDto condition) {
		PageUtils<EmployeeVo> page = new PageUtils<EmployeeVo>();
		// 参数map
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap = MapUtils.entityToMap(condition, paramMap);
		paramMap = page.removePageInfo(paramMap);
		int totalCount = employeeMapper.selectEmployeeCount(paramMap);
		page.setTotalCount(totalCount);
		page.setPageSize(condition.getSize());
		page.setPageIndex(condition.getPage());
		page.setPageSize(condition.getSize());
		page.setPageInfo(paramMap, page.getBegin(), condition.getSize());
		paramMap = MapUtils.entityToMap(page, paramMap);
		List<Employee> list = employeeMapper.selectEmployeeByPage(paramMap);
		List<EmployeeVo> resultList = new BeanCopyUtils().copyList(list,EmployeeVo.class);
		page.setList(resultList);
		return page;
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
	public int add(EmployeeAddDto addDto) {
		boolean verifyID = verifyID(addDto.getIdentity());
		if(!verifyID) {
			return 0;
		}
		addDto.setPassword(MD5Utils.getMD5(addDto.getPassword()));
		addDto.setStatus("1");
		Employee employee = new Employee();
		BeanUtils.copyProperties(addDto,employee);
		employeeMapper.insertEmployee(employee);
		Integer maxEmId = employeeMapper.selectMaxEmId();
		SalaryRecord record = new SalaryRecord();
		record.setEmId(maxEmId.toString());
		record.setBeforeGreade("0");
		record.setAfterGreade(employee.getSalaryGrade());
		record.setChangeDesc("入职");
		record.setReason("新员工入职！");
		salaryRecordMapper.insertSalaryRecord(record);
		return 1;
	}

	@Override
	public void modify(EmployeeModifyDto modifyDto) {
		Employee em = new Employee();
		em.setId(modifyDto.getId());
		Employee vo = employeeMapper.selectEmployee(em).get(0);

		recordSalaryGrade(modifyDto, vo);
		Employee employee = new Employee();
		BeanUtils.copyProperties(modifyDto, employee);
		employeeMapper.updateEmployee(employee);
	}

	/**
	 * @Title: recordSalaryGrade
	 * @Description: TODO 记录薪资等级
	 * @param employee
	 * @param vo
	 * @date:2019-01-01 15:59
	 */
	private void recordSalaryGrade(EmployeeModifyDto employee, Employee vo) {
		if (!employee.getSalaryGrade().equals(vo.getSalaryGrade())) {
			SalaryRecord record = new SalaryRecord();
			record.setEmId(employee.getId());
			record.setBeforeGreade(vo.getSalaryGrade());
			record.setAfterGreade(employee.getSalaryGrade());
			String changeDesc = getChanageDesc(vo, employee);
			record.setChangeDesc(changeDesc);
			record.setReason(employee.getReason());
			salaryRecordMapper.insertSalaryRecord(record);
		}
	}

	/**
	 * @Title: getChanageDesc
	 * @Description: TODO 根据原薪资等级和修改的薪资等级来判断是涨蒋还是降薪
	 * @param vo
	 * @param employee
	 * @return
	 * @date:2019-01-01 15:55
	 */
	private String getChanageDesc(Employee vo, EmployeeModifyDto employee) {
		String result = "";
		if (Integer.parseInt(vo.getSalaryGrade()) > Integer.parseInt(employee.getSalaryGrade())) {
			result = "降薪";
		} else {
			result = "涨薪";
		}
		return result;
	}

	@Override
	public List<Dictionary> querySalaryGrade() {
		Dictionary dictionary = new Dictionary();
		return null;
//		return DictionaryMapper.select(dictionary);
	}

	@Override
	public boolean verifyID(String identity) {
		Employee employee = new Employee();
		employee.setIdentity(identity);
		List<Employee> selectEmployee = employeeMapper.selectEmployee(employee);
		if(selectEmployee != null&&selectEmployee.size()>0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean login(Employee employee, HttpSession session) {
		String password = MD5Utils.getMD5(employee.getPassword());
		employee.setPassword(password);
		employee.setStatus("1");
		List<Employee> list = employeeMapper.selectEmployee(employee);
		if(list != null && list.size() >0) {
			session.setAttribute("user",list.get(0));
			return true;
		}
		return false;
	}

	@Override
	public boolean resetPassowrd(Employee employee) {
		// TODO 后期需要添加权限验证，即，只要最高超级管理员才能进行重置
		String password = MD5Utils.getMD5(Contans.RESET_PASSWORD);
		employee.setPassword(password);
		employeeMapper.updateEmployee(employee);
		return true;
	}

	@Override
	public boolean mofifyPassword(Employee employee,String newPassword) throws Exception {
		String password = MD5Utils.getMD5(employee.getPassword());
		employee.setPassword(password);
		employee.setStatus("1");
		List<Employee> list = employeeMapper.selectEmployee(employee);
		if(list != null && list.size() >0) {
			password = MD5Utils.getMD5(newPassword);
			employee.setPassword(password);
			employeeMapper.updateEmployee(employee);
		} else {
			throw new Exception("原始密码有误!");
		}
		return false;
	}

	@Override
	public Employee queryById(String id) {
		Employee employee = new Employee();
		employee.setId(id);
		return employeeMapper.selectEmployee(employee).get(0);
	}

	@Override
	public int remove(String id) {
		Employee employee = new Employee();
		employee.setId(id);
		// 删除之前的记录涨薪记录
		return employeeMapper.deleteEmployee(employee);
	}

}
