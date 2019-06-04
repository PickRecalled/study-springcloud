package com.pickrecalled.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickrecalled.entity.Dept;
import com.pickrecalled.facade.DeptFeignService;

@RestController
public class DeptController {

	@Autowired
	private DeptFeignService deptFeignService;

	@RequestMapping(value = "/consumer/dept/add")
	public Boolean add(@RequestBody Dept dept) {
		return deptFeignService.add(dept);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptFeignService.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return deptFeignService.list();
	}

}
