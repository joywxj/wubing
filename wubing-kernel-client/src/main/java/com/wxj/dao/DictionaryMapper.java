package com.wxj.dao;

import java.util.List;
import java.util.Map;

import com.wxj.domain.entity.dictionary.Dictionary;
import org.springframework.stereotype.Repository;

/**
* @ClassName:  DictionaryMapper
* @Description:TODO
* @Modified:第一版本
* @author: wxj
* @date:2020-4-7 8:36:04
* @email: 18772118541@163.com
*/
@Repository("dictionaryMapper")
public interface DictionaryMapper {
	public List<Dictionary> select(Map<String, Object> paramMap);

	public Dictionary get(String id);

	public Integer update(Dictionary bean);

	public Integer insert(Dictionary bean);

	public Integer delete(String id);

}