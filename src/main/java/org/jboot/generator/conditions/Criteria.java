package org.jboot.generator.conditions;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 条件装载
 * 
 * @author liwen
 *
 */
@Data
public class Criteria {

    private List<Criterion> criterions;

    public Criteria() {
        super();
        criterions = new ArrayList<Criterion>();
    }

    private void addCriterion(String attr, Operation op) {
        if (attr == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criterions.add(new Criterion(attr, op));
    }

    private void addCriterion(String attr, Operation op, Object value) {
        if (value == null) {
            throw new RuntimeException("Value for " + attr + " cannot be null");
        }
        criterions.add(new Criterion(attr, op, value));
    }

    private void addCriterion(String attr, Operation op, Object value, Object secondValue) {
        if (attr == null || secondValue == null) {
            throw new RuntimeException("Between values for " + attr + " cannot be null");
        }
        criterions.add(new Criterion(attr, op, value, secondValue));
    }

    public Criteria isNull(String attr) {
        addCriterion(attr, Operation.isNull);
        return this;
    }

    public Criteria isNotNull(String attr) {
        addCriterion(attr, Operation.isNotNull);
        return this;
    }

    public Criteria eq(String attr, Object value) {
        addCriterion(attr, Operation.eq, value);
        return this;
    }

    public Criteria ne(String attr, Object value) {
        addCriterion(attr, Operation.ne, value);
        return this;
    }

    public Criteria gt(String attr, Object value) {
        addCriterion(attr, Operation.gt, value);
        return this;
    }

    public Criteria ge(String attr, Object value) {
        addCriterion(attr, Operation.ge, value);
        return this;
    }

    public Criteria lt(String attr, Object value) {
        addCriterion(attr, Operation.lt, value);
        return this;
    }

    public Criteria le(String attr, Object value) {
        addCriterion(attr, Operation.le, value);
        return this;
    }

    public Criteria like(String attr, Object value) {
        addCriterion(attr, Operation.like, value);
        return this;
    }

    public Criteria notLike(String attr, Object value) {
        addCriterion(attr, Operation.notLike, value);
        return this;
    }

    public Criteria in(String attr, Object... values) {
        addCriterion(attr, Operation.in, values);
        return this;
    }

    public Criteria in(String attr, List<Object> values) {
        addCriterion(attr, Operation.in, values);
        return this;
    }

    public Criteria notIn(String attr, Object... values) {
        addCriterion(attr, Operation.notIn, values);
        return this;
    }

    public Criteria notIn(String attr, List<Object> values) {
        addCriterion(attr, Operation.notIn, values);
        return this;
    }

    public Criteria between(String attr, Object value, Object secondValue) {
        addCriterion(attr, Operation.between, value, secondValue);
        return this;
    }

    public Criteria notBetween(String attr, Object value, Object secondValue) {
        addCriterion(attr, Operation.notBetween, value, secondValue);
        return this;
    }

    public Criteria isNull(Enum<?> attr) {
        addCriterion(attr.name(), Operation.isNull);
        return this;
    }

    public Criteria isNotNull(Enum<?> attr) {
        addCriterion(attr.name(), Operation.isNotNull);
        return this;
    }

    public Criteria eq(Enum<?> attr, Object value) {
        addCriterion(attr.name(), Operation.eq, value);
        return this;
    }

    public Criteria ne(Enum<?> attr, Object value) {
        addCriterion(attr.name(), Operation.ne, value);
        return this;
    }

    public Criteria gt(Enum<?> attr, Object value) {
        addCriterion(attr.name(), Operation.gt, value);
        return this;
    }

    public Criteria ge(Enum<?> attr, Object value) {
        addCriterion(attr.name(), Operation.ge, value);
        return this;
    }

    public Criteria lt(Enum<?> attr, Object value) {
        addCriterion(attr.name(), Operation.lt, value);
        return this;
    }

    public Criteria le(Enum<?> attr, Object value) {
        addCriterion(attr.name(), Operation.le, value);
        return this;
    }

    public Criteria like(Enum<?> attr, Object value) {
        addCriterion(attr.name(), Operation.like, value);
        return this;
    }

    public Criteria notLike(Enum<?> attr, Object value) {
        addCriterion(attr.name(), Operation.notLike, value);
        return this;
    }

    public Criteria in(Enum<?> attr, Object... values) {
        addCriterion(attr.name(), Operation.in, values);
        return this;
    }

    public Criteria in(Enum<?> attr, List<Object> values) {
        addCriterion(attr.name(), Operation.in, values.toArray());
        return this;
    }

    public Criteria notIn(Enum<?> attr, Object... values) {
        addCriterion(attr.name(), Operation.notIn, values);
        return this;
    }

    public Criteria notIn(Enum<?> attr, List<Object> values) {
        addCriterion(attr.name(), Operation.notIn, values.toArray());
        return this;
    }

    public Criteria between(Enum<?> attr, Object value, Object secondValue) {
        addCriterion(attr.name(), Operation.between, value, secondValue);
        return this;
    }

    public Criteria notBetween(Enum<?> attr, Object value, Object secondValue) {
        addCriterion(attr.name(), Operation.notBetween, value, secondValue);
        return this;
    }
}
