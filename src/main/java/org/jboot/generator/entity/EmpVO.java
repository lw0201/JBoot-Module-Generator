package org.jboot.generator.entity;

import java.util.Date;
import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import org.jboot.generator.base.BaseVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Emp 实体类
 * 
 * @author liwen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class EmpVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * 雇员编号
     */
    @ApiModelProperty("雇员编号")
    private Integer empno;

    /**
     * 雇员姓名
     */
    @Length(max = 15)
    @ApiModelProperty("雇员姓名")
    private String ename;

    /**
     * 雇员职位
     */
    @Length(max = 10)
    @ApiModelProperty("雇员职位")
    private String job;

    /**
     * 雇员对应的领导的编号
     */
    @ApiModelProperty("雇员对应的领导的编号")
    private Integer mgr;

    /**
     * 雇员的雇佣日期
     */
    @ApiModelProperty("雇员的雇佣日期")
    private Date hiredate;

    /**
     * 雇员的基本工资
     */
    @ApiModelProperty("雇员的基本工资")
    private BigDecimal sal;

    /**
     * 奖金
     */
    @ApiModelProperty("奖金")
    private BigDecimal comm;

    /**
     * 所在部门
     */
    @ApiModelProperty("所在部门")
    private Integer deptno;


}