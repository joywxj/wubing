package com.wxj.domain.dto.bank;

import lombok.Data;

/**
 * <p>@ClassName: BankInfoModifyDto  </p>
 * <p>@Description: </p>
 * <p>@author: wxj  </p>
 * <p>@date: 2020/10/19</p>
 * <p>@Tel:18772118541</p>
 * <p>@email:18772118541@163.com</p>
 */
@Data
public class BankInfoModifyDto {
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
}
