package com.wxj.service;

import com.wxj.domain.dto.advance.AdvanceAddDto;
import com.wxj.domain.dto.advance.AdvanceConditionDto;
import com.wxj.domain.dto.advance.AdvanceModifyDto;
import com.wxj.domain.entity.advance.Advance;
import com.wxj.domain.vo.advance.AdvanceVO;
import com.wxj.util.PageUtils;

public interface IAdvanceService {
    public PageUtils<AdvanceVO> query(AdvanceConditionDto conditionDto) ;

    public Boolean modify(AdvanceModifyDto modifyDto) ;

    public Boolean add(AdvanceAddDto addDto) ;

    public Boolean remove(String id) ;

    public AdvanceVO get(String id) ;

}
