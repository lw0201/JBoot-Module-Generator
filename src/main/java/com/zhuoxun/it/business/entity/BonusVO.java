package com.zhuoxun.it.business.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * Emp 实体类
 * 
 * @author liwen
 */
@Data
public class BonusVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 雇员姓名
     */
    private String ename;
    
    /**
     * 雇员职位
     */
    private String job;
    
    /**
     * 雇员工资
     */
    private BigDecimal sal;
    
    /**
     * 雇员资金
     */
    private BigDecimal comm;
    

}