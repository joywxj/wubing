package com.wxj.domain.vo.menu;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>@ClassName: MenuTreeVO  </p>
 * <p>@Description: </p>
 * <p>@author: wxj  </p>
 * <p>@date: 2020/10/30</p>
 * <p>@Tel:18772118541</p>
 * <p>@email:18772118541@163.com</p>
 */
@Data
public class MenuTreeVO {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("路径")
    private String path;

    @ApiModelProperty("排序")
    private Integer order;

    @ApiModelProperty("父id")
    private Integer pid;

    @ApiModelProperty("子菜单")
    private List<MenuTreeVO> children;
}
