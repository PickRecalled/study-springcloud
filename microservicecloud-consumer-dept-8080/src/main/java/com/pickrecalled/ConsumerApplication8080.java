package com.pickrecalled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication8080 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConsumerApplication8080.class, args);
	}

}
