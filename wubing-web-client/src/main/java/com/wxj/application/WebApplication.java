package com.wxj.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**  
* @ClassName: WebApplication  
* @Description: TODO web端启动类
* @author: wxj  
* @date: 2018-09-09 08:34
* @Tel:18772118541
* @email:18772118541@163.com
*/
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
@ComponentScan({"com.wxj.controller"})
public class WebApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(WebApplication.class).run(args);
	}
}
