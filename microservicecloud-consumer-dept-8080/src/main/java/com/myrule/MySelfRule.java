package com.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule() {
		// 修改默认轮询负载均衡算法为随机算法
		System.out.println("---进入 MySelfRule 负载均衡算法---");
		return new FiveCountRule();// 自定义算法每个机器被访问5次
	}
}
