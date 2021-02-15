package com.wxj.domain.dto.advance;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>@ClassName: AdvanceVo  </p>
 * <p>@Description: 查询DTO </p>
 * <p>@author: wxj  </p>
 * <p>@date: 2020/10/16</p>
 * <p>@Tel:18772118541</p>
 * <p>@email:18772118541@163.com</p>
 */
@Data
public class AdvanceConditionDto {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("员工id")
    private Integer emId;

    @ApiModelProperty("借支金额")
    private BigDecimal money;

    @ApiModelProperty("审核状态：wait--待审核,pass--审核通过,noPass--审核不通过")
    private String auditTag;

    @ApiModelProperty("创建用户")
    private String createUser;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改用户，")
    private String modifyUser;

    @ApiModelProperty("修改时间")
    private Date modifyTime;

    @ApiModelProperty("审核信息")
    private String auditMessage;
    @ApiModelProperty("当前页")
    private Integer page = 1;

    @ApiModelProperty("当前页面大小")
    private Integer size = 10;
}
