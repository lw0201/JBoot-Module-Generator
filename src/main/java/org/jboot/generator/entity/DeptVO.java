package org.jboot.generator.entity;

import java.io.Serializable;

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
     * 部门编号
     */
    private Integer deptno;
    
    /**
     * 部门名称
     */
    private String dname;
    
    /**
     * 部门所在位置
     */
    private String loc;
    

}