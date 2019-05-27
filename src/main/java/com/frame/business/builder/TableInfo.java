package com.frame.business.builder;

import java.util.List;
import java.util.Set;

import lombok.Data;

/**
 * 表信息
 */
@Data
public class TableInfo {

    /**
     * note:表名
     */
    private String tableName;

    /**
     * :表描述
     */
    private String comments;

    /**
     * 实体名称
     */
    private String entityName;

    /**
     * 需要生产的实体对象包路径
     */
    private String packageName;

    /**
     * 主键信息
     */
    private FieldInfo pk;

    /**
     * 表所有的字段信息
     */
    private List<FieldInfo> fields;

    /**
     * 需要导入的包
     */
    private Set<String> importPackages;

}
