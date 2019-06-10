package org.jboot.generator.conditions;

import org.jboot.generator.exception.ApplicationException;

import lombok.Data;

/**
 * 条件构造器
 * 
 * @author liwen
 */
@Data
public class Condition {

    /**
     * 字段名称
     */
    private String attr;

    /**
     * 操作类型
     */
    private Operation op;

    /**
     * 操作值
     */
    private Object value;

    /**
     * 操作第二个值
     */
    private Object secondValue;

    public Condition() {}

    public Condition(String attr, Operation op, Object value) {
        this.attr = attr;
        this.op = op;
        this.value = value;
        this.valid();
    }

    public Condition(String attr, Operation op, Object value, Object secondValue) {
        this.attr = attr;
        this.op = op;
        this.value = value;
        this.secondValue = secondValue;
    }

    public void valid() {
        if (Operation.in.getType().equals(this.getOp().getType())
            || Operation.notIn.getType().equals(this.getOp().getType())) {
            if (!isArray(value)) {
                throw new ApplicationException("Object check for isArray is null.");
            }
        }
        if (Operation.between.getType().equals(this.getOp().getType())
            || Operation.between.getType().equals(this.getOp().getType())) {
            if (null != value || null != secondValue) {
                throw new ApplicationException("Value and secondValue cannot be empty.");
            }
        }
    }

    /**
     * 对象是否为数组对象
     *
     * @param obj
     *            对象
     * @return 是否为数组对象，如果为{@code null} 返回false
     */
    public static boolean isArray(Object obj) {
        if (null == obj) {
            throw new ApplicationException("Object check for isArray is null.");
        }
        return obj.getClass().isArray();
    }

}
