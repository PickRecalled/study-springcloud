package com.pickrecalled.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pickrecalled.ProviderApplication8001;
import com.pickrecalled.entity.Dept;
import com.pickrecalled.facade.DeptService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderApplication8001.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeptServiceTest {

	private static Logger logger = LoggerFactory.getLogger(DeptServiceTest.class.getName());

	@Autowired
	private DeptService deptService;

	@Test
	public void listTest() {
		List<Dept> list = deptService.list();
		for (Dept dept : list) {
			if (logger.isInfoEnabled()) logger.info("dep list:{}", dept);
		}
	}

}
