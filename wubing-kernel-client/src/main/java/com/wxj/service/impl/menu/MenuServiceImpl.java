package com.wxj.service.impl.menu;

import com.wxj.domain.vo.menu.MenuTreeVO;
import com.wxj.util.BeanCopyUtils;
import com.wxj.util.MapUtils;
import com.wxj.util.PageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wxj.domain.vo.menu.MenuVO;
import com.wxj.domain.dto.menu.MenuConditionDto;
import com.wxj.domain.dto.menu.MenuModifyDto;
import com.wxj.domain.dto.menu.MenuAddDto;
import com.wxj.service.IMenuService;
import com.wxj.dao.MenuMapper;
import com.wxj.domain.entity.menu.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("menuImpl")
public class MenuServiceImpl implements IMenuService{
	@Autowired
	private MenuMapper mapper;

	@Override
	public PageUtils<MenuVO> query(MenuConditionDto conditionDto) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
				PageUtils<MenuVO> page = new PageUtils<MenuVO>();

		paramMap = MapUtils.entityToMap(conditionDto, paramMap);
		List<Menu> list = mapper.select(paramMap);
		page.setTotalCount(list.size());
		page.setPageIndex(conditionDto.getPage());
		page.setPageSize(conditionDto.getSize());
		page.setPageInfo(paramMap, page.getBegin(), conditionDto.getSize());
		list = mapper.select(paramMap);
		List<MenuVO> resultList = new BeanCopyUtils().copyList(list,MenuVO.class);
		page.setList(resultList);
		return page;
	} 
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean add(MenuAddDto addDto) {
		Menu bean = new Menu();
		BeanUtils.copyProperties(addDto, bean);
		mapper.insert(bean);
		return true;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean modify(MenuModifyDto modifyDto) {
		Menu bean = new Menu();
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
	public MenuVO get(String id) {
		Menu bean =  mapper.get(id);
		MenuVO result = new MenuVO();
		BeanUtils.copyProperties(bean, result);
		return result;
	}

	@Override
	public List<MenuTreeVO> getMenuTree(MenuConditionDto conditionDto) {

		List<Menu> list = mapper.selectMenuByEmId(conditionDto.getEmId());
		List<MenuTreeVO> result = new ArrayList<MenuTreeVO>();

		buildMenuTree(list,result);

		return result;
	}

	private void buildMenuTree(List<Menu> list,List<MenuTreeVO> result) {
		for (int i = 0; i < list.size(); i++) {
			Menu menu = list.get(i);
			if (menu.getPid().equals(0)) {
                MenuTreeVO menuTreeVO = BeanCopyUtils.copy(menu, MenuTreeVO.class);
				list.remove(i);
				i--;
				List<MenuTreeVO> childrenTree = buildMenuChildrenTree(list, menu.getId());
                menuTreeVO.setChildren(childrenTree);
                result.add(menuTreeVO);
            }

		}
	}

	private List<MenuTreeVO> buildMenuChildrenTree(List<Menu> list, Integer pid) {

		List<MenuTreeVO> result = new ArrayList<>();
		if (list.size() == 0) {
			return result;
		}
		for (int i = 0; i < list.size(); i++) {
			Menu menu = list.get(i);

			if (pid == menu.getPid()) { 
				list.remove(i);
				MenuTreeVO menuTreeVO = BeanCopyUtils.copy(menu, MenuTreeVO.class);
				List<MenuTreeVO> childrenTree = buildMenuChildrenTree(list, menu.getId());
				i--;
				menuTreeVO.setChildren(childrenTree);
				result.add(menuTreeVO);

			}
		}
		return result;
	}
}