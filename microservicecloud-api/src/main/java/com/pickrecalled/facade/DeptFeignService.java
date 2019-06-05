package com.pickrecalled.facade;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pickrecalled.entity.Dept;

/**
 * Dept Feign负载均衡服务
 * @author PickRecalled
 */
// @FeignClient(value = "MICROSERVICECLOUD-PROVIDER-DEPT")//Feign面向服务接口，调用微服务
@FeignClient(value = "MICROSERVICECLOUD-PROVIDER-DEPT", fallbackFactory = DeptFeignServiceFallbackFactory.class)
public interface DeptFeignService {

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public Boolean add(Dept dept);
}
