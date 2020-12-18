package com.wxj.controller.bank;

import com.wxj.domain.dto.bank.BankInfoAddDto;
import com.wxj.domain.dto.bank.BankInfoConditionDto;
import com.wxj.domain.dto.bank.BankInfoModifyDto;
import com.wxj.domain.entity.bank.BankInfo;
import com.wxj.domain.vo.bank.BankInfoVO;
import com.wxj.service.IBankInfoService;
import com.wxj.util.PageUtils;
import com.wxj.util.ResultObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * <p>@ClassName: BankController  <p>
 * <p>@Description: TODO 银行信息管理<p>
 * <p>@author: wxj  <p>
 * <p>@date: 2019年3月7日<p>
 * <p>@Tel:18772118541<p>
 * <p>@email:18772118541@163.com<p>
 */
@RestController
@RequestMapping("/bank")
@Api(tags = "银行信息管理")
public class BankController {
    @Autowired
    private IBankInfoService bankService;

    /**
     * <p>@Title: addBankInfo  <p>
     * <p>@Description: TODO 添加银行信息<p>
     * <p>@param bankInfo   <p>
     * <p>@date:2019-03-07 16:58<p>
     */
    @ApiOperation(value = "银行卡信息添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject add(BankInfoAddDto bankInfo) {
        boolean flg = bankService.addBankInfo(bankInfo);
        return new ResultObject(flg);
    }

    @ApiOperation(value = "银行卡信息删除")
    @RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject remove(String id) {
        boolean flg = bankService.remove(id);
        return new ResultObject(flg);
    }

    @ApiOperation(value = "银行卡信息更新")
    @RequestMapping(value = "/modify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject modify(BankInfoModifyDto bankInfo) {
        boolean flg = bankService.modify(bankInfo);
        return new ResultObject(flg);
    }

    /**
     * <p>@方法名: query </p>
     * <p>@方法描述: 查询员工的银行卡信息</p>
     * <p>@param bankInfo
     * <p>@param page
     * <p>@return</p>
     * <p>日期:2019-08-02 11:18</p>
     */
    @ApiOperation(value = "银行卡信息查询")
    @PostMapping(value = "/query")
    public ResultObject query(BankInfoConditionDto bankInfo) {
        PageUtils<BankInfoVO> page = bankService.query(bankInfo);
        return new ResultObject(page);
    }

    @ApiOperation(value = "查询单条银行信息")
    @PostMapping(value = "/get")
    public ResultObject get(String id) {
        BankInfoVO bean = bankService.get(id);
        return new ResultObject(bean);
    }
}
