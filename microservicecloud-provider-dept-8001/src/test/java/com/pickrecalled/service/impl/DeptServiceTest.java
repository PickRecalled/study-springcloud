package com.pickrecalled.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pickrecalled.DeptService;
import com.pickrecalled.ProviderApplication;
import com.pickrecalled.entity.Dept;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeptServiceTest {

	@Autowired
	private DeptService deptService;

	@Test
	public void listTest() {
		List<Dept> list = deptService.list();
		for (Dept dept : list) {
			System.out.println("dep:" + dept);
		}
	}

}
