package com.wxj.domain.dto.bank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>@ClassName: BankInfoConditionDto  </p>
 * <p>@Description: </p>
 * <p>@author: wxj  </p>
 * <p>@date: 2020/10/19</p>
 * <p>@Tel:18772118541</p>
 * <p>@email:18772118541@163.com</p>
 */
@Data
public class BankInfoConditionDto {
    private String id;
    /**银行卡号*/
    private String bankCard;
    /**银行名称*/
    private String bankName;
    /**开户行*/
    private String bankDeposit;
    /**1:常用0，备用*/
    private String sign;
    /**银行地址*/
    private String bankAddress;
    /**员工id*/
    private String emId;
    /**修改时间*/
    private String updateTime;
    /**创建时间*/
    private String createTime;

    @ApiModelProperty("当前页")
    private Integer page;

    @ApiModelProperty("当前页面大小")
    private Integer size;
}
