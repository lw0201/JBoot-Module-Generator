package org.jboot.generator.conditions;

import lombok.Data;

/**
 * 构造条件
 * 
 * @author liwen
 */
@Data
public class Criterion {

    private String attr;

    private Operation op;

    private Object value;

    private Object secondValue;

    protected Criterion(String attr, Operation op) {
        super();
        this.attr = attr;
        this.op = op;
    }

    protected Criterion(String attr, Operation op, Object value, Object secondValue) {
        super();
        this.attr = attr;
        this.op = op;
        this.value = value;
        this.secondValue = secondValue;
    }

    protected Criterion(String attr, Operation op, Object value) {
        super();
        this.attr = attr;
        this.op = op;
        this.value = value;
    }
}
