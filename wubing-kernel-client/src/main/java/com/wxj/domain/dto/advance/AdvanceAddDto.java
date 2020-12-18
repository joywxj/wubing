package com.wxj.domain.dto.advance;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>@ClassName: AdvanceAddDto  </p>
 * <p>@Description: </p>
 * <p>@author: wxj  </p>
 * <p>@date: 2020/10/16</p>
 * <p>@Tel:18772118541</p>
 * <p>@email:18772118541@163.com</p>
 */
@Data
public class AdvanceAddDto {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("员工id")
    private Integer emId;

    @ApiModelProperty("借支金额")
    private BigDecimal money;

    @ApiModelProperty("审核状态：wait--待审核,pass--审核通过,noPass--审核不通过")
    private String auditTag;
    @ApiModelProperty("审核信息")
    private String auditMessage;

    @ApiModelProperty("创建用户")
    private String createUser;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改用户，")
    private String modifyUser;

    @ApiModelProperty("修改时间")
    private Date modifyTime;
}
