package com.wxj.controller.advance;

import com.wxj.domain.dto.advance.AdvanceAddDto;
import com.wxj.domain.dto.advance.AdvanceConditionDto;
import com.wxj.domain.dto.advance.AdvanceModifyDto;
import com.wxj.domain.entity.advance.Advance;
import com.wxj.domain.vo.advance.AdvanceVO;
import com.wxj.service.IAdvanceService;
import com.wxj.util.PageUtils;
import com.wxj.util.ResultObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("advance")
@Api(tags = "预支控制类")
public class AdvanceController {
    @Autowired
    private IAdvanceService service;


    @ApiOperation(value = "/query", tags = "查询员工预支表列表(分页)")
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject query( AdvanceConditionDto conditionDto) {
        PageUtils<Advance> page = service.query(conditionDto);
        ResultObject result = new ResultObject(page);
        return result;
    }

    @ApiOperation(value = "/modify", tags = "更新员工预支表信息")
    @RequestMapping(value = "/modify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject modify(Advance modifyDto) {
        service.modify(modifyDto);
        ResultObject result = new ResultObject(1);
        return result;
    }

    @ApiOperation(value = "/audit", tags = "审核员工预支")
    @RequestMapping(value = "/audit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject audit(Advance modifyDto) {
        service.audit(modifyDto);
        ResultObject result = new ResultObject(1);
        return result;
    }

    @ApiOperation(value = "/remove", tags = "删除员工预支表信息")
    @RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject remove(String id) {
        service.remove(id);
        ResultObject result = new ResultObject(1);
        return result;
    }

    @ApiOperation(value = "/add", tags = "新增员工预支表信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject add(Advance addDto) {
        service.add(addDto);
        ResultObject result = new ResultObject(1);
        return result;
    }

    @ApiOperation(value = "/get", tags = "根据id查询员工预支表信息")
    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject get(String id) {
        Advance bean = service.get(id);
        ResultObject result = new ResultObject(bean);
        return result;
    }
}