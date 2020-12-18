package com.wxj.controller.dictionary;

import com.wxj.domain.dto.dictionary.DictionaryAddDto;
import com.wxj.domain.dto.dictionary.DictionaryConditionDto;
import com.wxj.domain.dto.dictionary.DictionaryModifyDto;
import com.wxj.domain.vo.dictionary.DictionaryVO;
import com.wxj.service.IDictionaryService;
import com.wxj.util.PageUtils;
import com.wxj.util.ResultObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"字典表API"})
@RequestMapping("/dictionary")
public class DictionaryController{
	@Autowired
	private IDictionaryService service;

	@ApiOperation(value = "/query", tags = "查询字典表列表(分页)")
	@RequestMapping(value = "/query", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject query( DictionaryConditionDto conditionDto) {
		PageUtils<DictionaryVO> page = service.query(conditionDto);
		ResultObject result = new ResultObject(page);
		return result;
	}

	@ApiOperation(value = "/list", tags = "查询字典表列表(不分页)")
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject list(DictionaryConditionDto conditionDto) {
		List<DictionaryVO> page = service.list(conditionDto);
		ResultObject result = new ResultObject(page);
		return result;
	}

	@ApiOperation(value = "/modify", tags = "更新字典表信息")
	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject modify(DictionaryModifyDto modifyDto) {
		service.modify(modifyDto);
		ResultObject result = new ResultObject(1);
		return result;
	}

	@ApiOperation(value = "/remove", tags = "删除字典表信息")
	@RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject remove(String id) {
		service.remove(id);
		ResultObject result = new ResultObject(1);
		return result;
	}

	@ApiOperation(value = "/add", tags = "新增字典表信息")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject add(DictionaryAddDto addDto) {
		service.add(addDto);
		ResultObject result = new ResultObject(1);
		return result;
	}

	@ApiOperation(value = "/get", tags = "根据id查询字典表信息")
	@RequestMapping(value = "/get", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject get(String id) {
		DictionaryVO bean = service.get(id);
		ResultObject result = new ResultObject(bean);
		return result;
	}

}