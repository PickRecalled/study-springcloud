package com.pickrecalled.facade;

import java.util.List;

import com.pickrecalled.entity.Dept;

public interface DeptService {

	public Boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();

}
