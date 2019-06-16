package org.jboot.generator.conditions;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Wrapper<T> {

    private List<Sort> sorts;

    private List<Criteria> criterias;

    public Wrapper() {
        criterias = new ArrayList<Criteria>();
    }

    public Wrapper<T> or(Criteria criteria) {
        if (null != criteria) {
            criterias.add(criteria);
        }
        return this;
    }

    public Wrapper<T> where(Criteria criteria) {
        if (null != criteria) {
            criterias.add(criteria);
        }
        return this;
    }

    public void clear() {
        criterias.clear();
    }
}