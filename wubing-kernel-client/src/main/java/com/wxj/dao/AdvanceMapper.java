package com.wxj.dao;

import com.wxj.domain.entity.advance.Advance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdvanceMapper {
	public List<Advance> select(Map<String, Object> paramMap);

	public Advance get(String id);
 
	public Integer update(Advance bean);

	public Integer insert(Advance bean);

	public Integer delete(String id);

}