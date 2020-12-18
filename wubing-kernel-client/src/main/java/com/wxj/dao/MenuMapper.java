package com.wxj.dao;

import org.springframework.stereotype.Repository;
import com.wxj.domain.entity.menu.Menu;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuMapper {
	public List<Menu> select(Map<String, Object> paramMap);

	public Menu get(String id);
 
	public Integer update(Menu bean);

	public Integer insert(Menu bean);

	public Integer delete(String id);

    List<Menu> selectMenuByEmId(Integer emId);
}