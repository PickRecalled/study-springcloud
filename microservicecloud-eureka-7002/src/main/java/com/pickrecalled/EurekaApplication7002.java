package com.pickrecalled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// EurekaServer服务器端启动类,接受其它微服务注册进来
@EnableEurekaServer
public class EurekaApplication7002 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaApplication7002.class, args);
	}
}
