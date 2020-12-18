package com.wxj.service;

import com.wxj.domain.vo.menu.MenuTreeVO;
import com.wxj.domain.vo.menu.MenuVO;
import com.wxj.domain.dto.menu.MenuConditionDto;
import com.wxj.domain.dto.menu.MenuModifyDto;
import com.wxj.domain.dto.menu.MenuAddDto;
import com.wxj.util.PageUtils;

import java.util.List;

public interface IMenuService {
	public PageUtils<MenuVO> query(MenuConditionDto conditionDto) ;

	public Boolean modify(MenuModifyDto modifyDto) ;

	public Boolean add(MenuAddDto addDto) ;

	public Boolean remove(String id) ;

	public MenuVO get(String id) ;

    List<MenuTreeVO> getMenuTree(MenuConditionDto conditionDto);
}
