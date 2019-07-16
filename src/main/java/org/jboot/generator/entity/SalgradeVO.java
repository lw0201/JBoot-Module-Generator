package org.jboot.generator.entity;

import org.jboot.generator.base.BaseVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Salgrade 实体类
 * 
 * @author liwen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SalgradeVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * 工资等级
     */
    @ApiModelProperty("工资等级")
    private Integer grade;

    /**
     * 此等级的最低工资
     */
    @ApiModelProperty("此等级的最低工资")
    private Integer losal;

    /**
     * 此等级的最高工资
     */
    @ApiModelProperty("此等级的最高工资")
    private Integer hisal;

}