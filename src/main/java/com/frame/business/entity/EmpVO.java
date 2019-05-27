package com.frame.business.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * Emp 实体类
 * 
 * @author Aone
 */
@Data
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

}