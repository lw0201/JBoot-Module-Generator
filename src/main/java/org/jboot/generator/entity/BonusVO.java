package org.jboot.generator.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * Bonus 实体类
 * 
 * @author liwen
 */
@Data
public class BonusVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 雇员姓名
     */
    @Length(max = 10)
    private String ename;

    /**
     * 雇员职位
     */
    @Length(max = 9)
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