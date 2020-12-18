package com.wxj.dao;

import com.wxj.domain.entity.workload.Workload;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WorkloadMapper {
	public List<Workload> select(Map<String, Object> paramMap);

	public Workload get(String id);
 
	public Integer update(Workload bean);

	public Integer insert(Workload bean);

	public Integer delete(String id);

}