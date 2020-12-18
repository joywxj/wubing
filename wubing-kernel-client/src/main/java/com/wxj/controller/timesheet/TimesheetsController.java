package com.wxj.controller.timesheet;

import com.wxj.util.PageUtils;
import com.wxj.util.ResultObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wxj.service.ITimesheetsService;
import com.wxj.domain.vo.timesheet.TimesheetsVO;
import com.wxj.domain.dto.timesheet.TimesheetsConditionDto;
import com.wxj.domain.dto.timesheet.TimesheetsModifyDto;
import com.wxj.domain.dto.timesheet.TimesheetsAddDto;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Api(tags = {"工时表API"})
@RequestMapping("/timesheet")
public class TimesheetsController{
	@Autowired
	private ITimesheetsService service;

	@ApiOperation(value = "/query", tags = "查询工时表列表(分页)")
	@RequestMapping(value = "/query", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject query(TimesheetsConditionDto conditionDto) {
		PageUtils<TimesheetsVO> page = service.query(conditionDto);
		ResultObject result = new ResultObject(page);
		return result;
	}

	@ApiOperation(value = "/queryByPage", tags = "查询工时表列表(分页)")
	@RequestMapping(value = "/queryByPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject queryByPage(TimesheetsConditionDto conditionDto) {
		PageUtils<TimesheetsVO> page = service.queryByPage(conditionDto);
		ResultObject result = new ResultObject(page);
		return result;
	}

	@ApiOperation(value = "/modify", tags = "更新工时表信息")
	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject modify(TimesheetsModifyDto modifyDto) {
		service.modify(modifyDto);
		ResultObject result = new ResultObject(1);
		return result;
	}

	@ApiOperation(value = "/remove", tags = "删除工时表信息")
	@RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject remove(String id) {
		service.remove(id);
		ResultObject result = new ResultObject(1);
		return result;
	}

	@ApiOperation(value = "/add", tags = "新增工时表信息")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject add(TimesheetsAddDto addDto) {
		service.add(addDto);
		ResultObject result = new ResultObject(1);
		return result;
	}

	@ApiOperation(value = "/get", tags = "根据id查询工时表信息")
	@RequestMapping(value = "/get", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject get(String id) {
		TimesheetsVO bean = service.get(id);
		ResultObject result = new ResultObject(bean);
		return result;
	}

}