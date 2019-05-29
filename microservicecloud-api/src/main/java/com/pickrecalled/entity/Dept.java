package com.pickrecalled.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

	private static final long serialVersionUID = -5208812177129953553L;

	private Long deptno;

	private String dname;

	private String dbSource;

	public Dept() {
		super();
	}

	public Dept(Long deptno, String dname, String dbSource) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.dbSource = dbSource;
	}

	@Override
	public String toString() {
		return "{\"deptno\":\"" + deptno + "\",\"dname\":\"" + dname + "\",\"dbSource\":\"" + dbSource + "\"}";
	}

}