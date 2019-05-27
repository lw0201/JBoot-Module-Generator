package com.frame.business.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * 字段类型
 * 
 * @author liwen
 *
 */
public enum FieldType {

    /**
     * 主键
     */
    PK("pk"),

    /**
     * 普通键
     */
    CK("ck");

    public final String key;

    FieldType(String key) {
        this.key = key;
    }

    private static Map<String, FieldType> codeLookup = new HashMap<>();

    static {
        for (FieldType type : FieldType.values()) {
            codeLookup.put(type.key, type);
        }
    }

    public static FieldType forCode(String code) {
        return codeLookup.get(code);
    }

}
