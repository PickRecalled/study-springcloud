package com.pickrecalled.entity;

import java.io.Serializable;

/**
 * Dept ORM
 * @author PickRecalled
 */
public class Dept implements Serializable {

	private static final long serialVersionUID = -2805370832889633343L;

	private Long deptno;// 部门编号

	private String dname;// 部门名字

	private String dbSource;// 数据源，当前数据所在的数据库位置，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

	public Dept() {
		super();
	}

	public Dept(Long deptno, String dname, String dbSource) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.dbSource = dbSource;
	}

	public Long getDeptno() {
		return deptno;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDbSource() {
		return dbSource;
	}

	public void setDbSource(String dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public String toString() {
		return "{\"deptno\":\"" + deptno + "\",\"dname\":\"" + dname + "\",\"dbSource\":\"" + dbSource + "\"}";
	}

}