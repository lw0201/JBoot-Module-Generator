package org.jboot.generator.conditions;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 构造条件
 * 
 * @author liwen
 */
@Data
public class Criterion {

    @ApiModelProperty("字段属性")
    private String attr;

    @ApiModelProperty("操作规则")
    private Operation op;

    @ApiModelProperty("查询的值")
    private Object value;

    @ApiModelProperty("查询的第二个值")
    private Object secondValue;

    public Criterion() {
        super();
    }

    public Criterion(String attr, Operation op) {
        super();
        this.attr = attr;
        this.op = op;
    }

    public Criterion(String attr, Operation op, Object value, Object secondValue) {
        super();
        this.attr = attr;
        this.op = op;
        this.value = value;
        this.secondValue = secondValue;
    }

    public Criterion(String attr, Operation op, Object value) {
        super();
        this.attr = attr;
        this.op = op;
        this.value = value;
    }
}
