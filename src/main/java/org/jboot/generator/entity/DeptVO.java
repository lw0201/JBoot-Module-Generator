package org.jboot.generator.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * Dept 实体类
 * 
 * @author liwen
 */
@Data
public class DeptVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @Length(max = 64)
    private String id;

    /**
     * 部门编码
     */
    @Length(max = 100)
    private String deptCode;

    /**
     * 部门名称
     */
    @Length(max = 100)
    private String deptName;

    /**
     * 租户ID
     */
    @Length(max = 64)
    private String tenantId;

    /**
     * 部门地址
     */
    @Length(max = 255)
    private String address;

    /**
     * 描述
     */
    @Length(max = 150)
    private String describe;

    /**
     * 创建人
     */
    @Length(max = 64)
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 最后修改人
     */
    @Length(max = 64)
    private String lastUpdateBy;

    /**
     * 最后修改时间
     */
    private Date lastUpdateDate;


}