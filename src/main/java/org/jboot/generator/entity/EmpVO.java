package org.jboot.generator.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

/**
 * Emp 实体类
 * 
 * @author liwen
 */
@Data
public class EmpVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 雇员编号
     */
    private Integer empno;
    
    /**
     * 雇员姓名
     */
    private String ename;
    
    /**
     * 雇员职位
     */
    private String job;
    
    /**
     * 雇员对应的领导的编号
     */
    private Integer mgr;
    
    /**
     * 雇员的雇佣日期
     */
    private Date hiredate;
    
    /**
     * 雇员的基本工资
     */
    private BigDecimal sal;
    
    /**
     * 奖金
     */
    private BigDecimal comm;
    
    /**
     * 所在部门
     */
    private Integer deptno;
    

}