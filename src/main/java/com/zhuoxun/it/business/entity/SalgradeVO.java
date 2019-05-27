package com.zhuoxun.it.business.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * Emp 实体类
 * 
 * @author liwen
 */
@Data
public class SalgradeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工资等级
     */
    private Integer grade;
    
    /**
     * 此等级的最低工资
     */
    private Integer losal;
    
    /**
     * 此等级的最高工资
     */
    private Integer hisal;
    

}