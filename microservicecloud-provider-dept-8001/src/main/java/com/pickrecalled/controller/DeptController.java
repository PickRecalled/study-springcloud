package com.pickrecalled.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pickrecalled.DeptService;
import com.pickrecalled.entity.Dept;

/**
 * 部门业务控制器
 * @author PickRecalled
 */
@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;

	@RequestMapping(value = "/dept/add", method = { RequestMethod.POST, RequestMethod.GET })
	public Boolean add(Dept dept) {
		return deptService.add(dept);
	}

	@GetMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}

	@GetMapping(value = "/dept/list")
	public List<Dept> list() {
		return deptService.list();
	}

}
