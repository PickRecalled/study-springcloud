package com.pickrecalled.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pickrecalled.entity.Dept;
import com.pickrecalled.facade.DeptService;

/**
 * 部门业务控制器
 * @author PickRecalled
 */
@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping(value = "/dept/get/{id}")
	@HystrixCommand(fallbackMethod = "processHystrixGet")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.get(id);
		if (null == dept) {
			throw new RuntimeException("该ID" + id + "无对应数据信息");
		}
		return dept;
	}

	public Dept processHystrixGet(@PathVariable("id") Long id) {
		Dept dept = new Dept();
		dept.setDname("该ID：" + id + "无对应数据信息,null--@HystrixCommand");
		dept.setDbSource("no this database in MySQL");
		return dept;
	}

	/**//////////////////////////////////////////////////////////////////////////////////////// **/

	@RequestMapping(value = "/dept/add", method = { RequestMethod.POST, RequestMethod.GET })
	public Boolean add(@RequestBody Dept dept) {
		System.out.println("---dept:" + dept);
		return deptService.add(dept);
	}

	@GetMapping(value = "/dept/list")
	public List<Dept> list() {
		return deptService.list();
	}

	@GetMapping(value = "/dept/discovery")
	public Object discovery() {
		// 获取微服务列表清单
		List<String> list = discoveryClient.getServices();
		System.out.println("-----discoveryClient.getServices-----:" + list);
		// 从获取微服务列表清单当中找到MICROSERVICECLOUD-PROVIDER-DEPT-8001这个微服务
		// MICROSERVICECLOUD-PROVIDER-DEPT-8001 从application.yml当中的spring.application.name获取
		List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-PROVIDER-DEPT-8001");
		for (ServiceInstance element : srvList) {
			// 输出对应微服务的信息
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
		}
		return this.discoveryClient;
	}

}
