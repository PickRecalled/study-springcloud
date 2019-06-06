package com.pickrecalled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
// 开启Hystrix图形化监控
@EnableHystrixDashboard
public class HystrixDashboardApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}

}
