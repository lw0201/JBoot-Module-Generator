package org.jboot.generator.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import org.jboot.generator.base.BaseVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Bonus 实体类
 * 
 * @author liwen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BonusVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * 雇员姓名
     */
    @Length(max = 10)
    @ApiModelProperty("雇员姓名")
    private String ename;

    /**
     * 雇员职位
     */
    @Length(max = 9)
    @ApiModelProperty("雇员职位")
    private String job;

    /**
     * 雇员工资
     */
    @ApiModelProperty("雇员工资")
    private BigDecimal sal;

    /**
     * 雇员资金
     */
    @ApiModelProperty("雇员资金")
    private BigDecimal comm;


}