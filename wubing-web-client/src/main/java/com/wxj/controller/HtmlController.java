package com.wxj.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**  
* @ClassName: HtmlController  
* @Description: TODO 页面跳转控制类
* @author: wxj  
* @date: 2018-09-09 09:47
* @Tel:18772118541
* @email:18772118541@163.com
*/
@Controller
@Api(value = "desc of class")
public class HtmlController {
	@ApiOperation(value = "desc of method", notes = "")
	@GetMapping(value="/index")
	public String index(){
		return "/index";
	}
}
