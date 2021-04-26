package com.wxj.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName: ServerApplication
 * @Description: TODO 服务总线
 * @author: wxj
 * @date: 2018-09-12 11:14
 * @Tel:18772118541
 * @email:18772118541@163.com
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerApplication {
	// skafhsdkh
	public static void main(String[] args) {
		new SpringApplicationBuilder(ServerApplication.class).run(args);
	}
}
