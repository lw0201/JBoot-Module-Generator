package org.jboot.generator.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义操作属性列
 * 
 * @author liwen
 */
public class SqlColumns {

    /**
     * 自定义列集
     */
    private static List<String> columns = new ArrayList<>();

    /**
     * create
     */
    public static SqlColumns create() {
        return new SqlColumns();
    }

    /**
     * append
     */
    public SqlColumns append(Enum<?>... attrNames) {
        for (Enum<?> attr : attrNames) {
            if (!columns.contains(attr.name())) {
                columns.add(attr.name());
            }
        }
        return this;
    }

    /**
     * append
     */
    public SqlColumns append(Enum<?> attrName) {
        if (!columns.contains(attrName.name())) {
            columns.add(attrName.name());
        }
        return this;
    }

    /**
     * build
     */
    public String[] build() {
        String[] array = new String[columns.size()];
        columns.toArray(array);
        return array;
    }

}
