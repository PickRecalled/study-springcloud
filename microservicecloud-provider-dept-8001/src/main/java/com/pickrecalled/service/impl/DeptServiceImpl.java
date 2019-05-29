package com.pickrecalled.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickrecalled.DeptService;
import com.pickrecalled.dao.DeptMapper;
import com.pickrecalled.entity.Dept;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;

	@Override
	public Boolean add(Dept dept) {
		return deptMapper.insert(dept) > 0 ? true : false;
	}

	@Override
	public Dept get(Long id) {
		return deptMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Dept> list() {
		return deptMapper.list();
	}

}
