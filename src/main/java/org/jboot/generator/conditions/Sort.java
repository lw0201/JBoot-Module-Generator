package org.jboot.generator.conditions;

import lombok.Data;

/**
 * 排序
 * 
 * @author liwen
 */
@Data
public class Sort {

    /**
     * 选择要排序的列、属性，对应实体属性字段
     */
    private String attr;

    /**
     * 排序规则{ASC,DESC}
     */
    private Order order;

}
