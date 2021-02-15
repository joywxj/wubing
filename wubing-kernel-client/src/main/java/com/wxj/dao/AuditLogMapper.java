package com.wxj.dao;

import com.wxj.domain.entity.audit.AuditLog;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
@Repository
public interface AuditLogMapper {
	public List<AuditLog> select(Map<String, Object> paramMap);

	public AuditLog get(Integer id);
 
	public Integer update(AuditLog bean);

	public Integer insert(AuditLog bean);

	public Integer delete(Integer id);

}