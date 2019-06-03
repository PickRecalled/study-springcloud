package com.pickrecalled;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 本服务启动后会自动注册进 eureka 服务中
@EnableEurekaClient
// 服务发现
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.pickrecalled" })
@MapperScan(basePackages = { "com.pickrecalled.dao" })
public class ProviderApplication8002 {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication8002.class, args);
	}

}
