package org.jboot.generator.conditions;

/**
 * 操作类型
 * 
 * @author liwen
 */
public enum Operation {
    /**
     * 等于=
     */
    eq("eq"),
    /**
     * 不等于<>
     */
    ne("ne"),
    /**
     * 大于>
     */
    gt("gt"),
    /**
     * 大于等于>=
     */
    ge("ge"),
    /**
     * 小于<
     */
    lt("lt"),
    /**
     * 小于等于<=
     */
    le("le"),
    /**
     * 模糊查询LIKE
     */
    like("like"),
    /**
     * 模糊查询 NOT LIKE
     */
    notLike("notLike"),
    /**
     * IN 查询
     */
    in("in"),
    /**
     * NOT IN 查询
     */
    notIn("notIn"),
    /**
     * NULL 值查询
     */
    isNull("isNull"),
    /**
     * IS NOT NULL
     */
    isNotNull("isNotNull"),
    /**
     * BETWEEN 条件语句
     */
    between("between"),
    /**
     * NOT BETWEEN 条件语句
     */
    notBetween("notBetween");

    private String type;

    public String getType() {
        return type;
    }

    Operation(String type) {
        this.type = type;
    }
}
