package com.wxj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

/**  
* <p>@ClassName: KernelApplication  <p>
* <p>@Description: TODO 核心控制模块启动类<p>
* <p>@author: wxj  <p>
* <p>@date: 2018-09-12 12:31<p>
* <p>@Tel:18772118541<p>
* <p>@email:18772118541@163.com<p>
*/
@SpringBootApplication(scanBasePackages = {"com.wxj"})
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("com.wxj.dao")
@EnableFeignClients
@EnableJms
@ComponentScan(basePackages = {"com.wxj.controller", "com.wxj.service", "com.wxj.dao", "com.wxj.util", "com.wxj.config"})
public class KernelApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(KernelApplication.class).run(args);
	}
}
