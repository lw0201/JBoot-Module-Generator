package org.jboot.generator.builder;

import lombok.Data;

/**
 * 字段信息
 * 
 * @author liwen
 *
 */
@Data
public class FieldInfo {

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 字段备注描述信息
     */
    private String comments;

    /**
     * 字段类型
     */
    private EntityMapping em;

    /**
     * 字段类型
     */
    private FieldType fieldType;
}
