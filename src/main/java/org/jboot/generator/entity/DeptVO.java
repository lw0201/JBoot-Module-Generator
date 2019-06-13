package org.jboot.generator.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Emp 实体类
 * 
 * @author liwen
 */
@Data
public class DeptVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    
    /**
     * 部门编码
     */
    private String deptCode;
    
    /**
     * 部门名称
     */
    private String deptName;
    
    /**
     * 租户ID
     */
    private String tenantId;
    
    /**
     * 部门地址
     */
    private String address;
    
    /**
     * 描述
     */
    private String describe;
    
    /**
     * 创建人
     */
    private String createdBy;
    
    /**
     * 创建时间
     */
    private Date createdDate;
    
    /**
     * 最后修改人
     */
    private String lastUpdateBy;
    
    /**
     * 最后修改时间
     */
    private Date lastUpdateDate;
    

}