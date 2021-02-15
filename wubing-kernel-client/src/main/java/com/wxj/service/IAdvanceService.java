package com.wxj.service;

import com.wxj.domain.dto.advance.AdvanceAddDto;
import com.wxj.domain.dto.advance.AdvanceConditionDto;
import com.wxj.domain.dto.advance.AdvanceModifyDto;
import com.wxj.domain.entity.advance.Advance;
import com.wxj.domain.vo.advance.AdvanceVO;
import com.wxj.util.PageUtils;

public interface IAdvanceService {
    public PageUtils<Advance> query(AdvanceConditionDto conditionDto) ;

    public Boolean modify(Advance modifyDto) ;

    public Boolean add(Advance addDto) ;

    public Boolean remove(String id) ;

    public Advance get(String id) ;

    /**
     * 审核
     * @param modifyDto
     */
	void audit(Advance modifyDto);
}
