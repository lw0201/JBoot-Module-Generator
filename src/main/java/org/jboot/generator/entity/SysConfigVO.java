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
public class SysConfigVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private String variable;
    
    /**
     * 
     */
    private String value;
    
    /**
     * 
     */
    private Date setTime;
    
    /**
     * 
     */
    private String setBy;
    

}