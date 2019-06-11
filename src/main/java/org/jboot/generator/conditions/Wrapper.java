package org.jboot.generator.conditions;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Wrapper<T> {

    private T entity;

    private List<Sort> sorts;

    private List<Criteria> criterias;

    public Wrapper() {
        criterias = new ArrayList<Criteria>();
    }

    public void or(Criteria criteria) {
        criterias.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = new Criteria();
        criterias.add(criteria);
        return criteria;
    }

    public Wrapper<T> create(Criteria criteria) {
        if (null != criteria) {
            criterias.add(criteria);
        }
        return this;
    }

    public void clear() {
        criterias.clear();
    }

}