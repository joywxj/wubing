package com.wxj.controller.menu;

import com.wxj.domain.vo.menu.MenuTreeVO;
import com.wxj.util.PageUtils;
import com.wxj.util.ResultObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.wxj.service.IMenuService;
import com.wxj.domain.vo.menu.MenuVO;
import com.wxj.domain.dto.menu.MenuConditionDto;
import com.wxj.domain.dto.menu.MenuModifyDto;
import com.wxj.domain.dto.menu.MenuAddDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"菜单表API"})
@RequestMapping("/menu")
public class MenuController{
	@Autowired
	private IMenuService service;

	@ApiOperation(value = "/query", tags = "查询菜单表列表(分页)")
	@RequestMapping(value = "/query", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject query( MenuConditionDto conditionDto) {
		PageUtils<MenuVO> page = service.query(conditionDto);
		ResultObject result = new ResultObject(page);
		return result;
	}

	@ApiOperation(value = "/getMenuTree", tags = "查询菜单树")
	@RequestMapping(value = "/getMenuTree", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject getMenuTree(MenuConditionDto conditionDto) {
		List<MenuTreeVO> menuTreeList = service.getMenuTree(conditionDto);
		ResultObject result = new ResultObject(menuTreeList);
		return result;
	}

	@ApiOperation(value = "/modify", tags = "更新菜单表信息")
	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject modify(MenuModifyDto modifyDto) {
		service.modify(modifyDto);
		ResultObject result = new ResultObject(1);
		return result;
	}

	@ApiOperation(value = "/remove", tags = "删除菜单表信息")
	@RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject remove(String id) {
		service.remove(id);
		ResultObject result = new ResultObject(1);
		return result;
	}

	@ApiOperation(value = "/add", tags = "新增菜单表信息")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject add(MenuAddDto addDto) {
		service.add(addDto);
		ResultObject result = new ResultObject(1);
		return result;
	}

	@ApiOperation(value = "/get", tags = "根据id查询菜单表信息")
	@RequestMapping(value = "/get", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultObject get(String id) {
		MenuVO bean = service.get(id);
		ResultObject result = new ResultObject(bean);
		return result;
	}

}