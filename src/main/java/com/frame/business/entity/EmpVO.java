package com.frame.business.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EmpVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer empno;

	private String ename;

	private String job;

	private Integer mgr;

	private Date hiredate;

	private BigDecimal sal;

	private BigDecimal comm;

	private Integer deptno;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return null == ename ? null : ename.trim();
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return null == job ? null : job.trim();
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public BigDecimal getSal() {
		return sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	public BigDecimal getComm() {
		return comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

}