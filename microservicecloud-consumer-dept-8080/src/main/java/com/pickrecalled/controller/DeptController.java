package com.pickrecalled.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pickrecalled.entity.Dept;

@RestController
@SuppressWarnings("unchecked")
public class DeptController {

	@Autowired
	private RestTemplate restTemplate;

	// provider服务提供端的URL
	private static final String REST_URL_PREFIX = "http://127.0.0.1:8001";

	@RequestMapping(value = "/consumer/dept/add", method = { RequestMethod.GET, RequestMethod.POST })
	public Boolean add(Dept dept) {
		// (url, requestMap, ResponseBean.class)这三个参数分别代表REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@GetMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}

	@GetMapping(value = "consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

}
