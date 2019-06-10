package org.jboot.generator.conditions;

/**
 * 排序规则
 * 
 * @author liwen
 *
 */
public enum Order {

    /**
     * 升序
     */
    asc("asc"),

    /**
     * 降序
     */
    desc("desc");

    private String type;

    Order(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
