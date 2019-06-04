package org.jboot.generator.builder;

import java.sql.Types;

/**
 * 实体映射对象
 * 
 * @author liwen
 */
public enum EntityMapping {

    /**
     * Identifies the generic SQL type {@code BIT}.
     */
    BIT(Types.BIT, "Integer", "INTEGER"),
    /**
     * Identifies the generic SQL type {@code TINYINT}.
     */
    TINYINT(Types.TINYINT, "Integer", "INTEGER"),
    /**
     * Identifies the generic SQL type {@code SMALLINT}.
     */
    SMALLINT(Types.SMALLINT, "Integer", "INTEGER"),
    /**
     * Identifies the generic SQL type {@code INTEGER}.
     */
    INTEGER(Types.INTEGER, "Integer", "INTEGER"),
    /**
     * Identifies the generic SQL type {@code BIGINT}.
     */
    BIGINT(Types.BIGINT, "Long", "LONG"),
    /**
     * Identifies the generic SQL type {@code FLOAT}.
     */
    FLOAT(Types.FLOAT, "Float", "FLOAT"),
    /**
     * Identifies the generic SQL type {@code REAL}.
     */
    REAL(Types.REAL, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code DOUBLE}.
     */
    DOUBLE(Types.DOUBLE, "Double", "DOUBLE"),
    /**
     * Identifies the generic SQL type {@code NUMERIC}.
     */
    NUMERIC(Types.NUMERIC, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code DECIMAL}.
     */
    DECIMAL(Types.DECIMAL, "BigDecimal", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code CHAR}.
     */
    CHAR(Types.CHAR, "Character", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code VARCHAR}.
     */
    VARCHAR(Types.VARCHAR, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code LONGVARCHAR}.
     */
    LONGVARCHAR(Types.LONGVARCHAR, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code DATE}.
     */
    DATE(Types.DATE, "Date", "DATE"),
    /**
     * Identifies the generic SQL type {@code TIME}.
     */
    TIME(Types.TIME, "Date", "DATE"),
    /**
     * Identifies the generic SQL type {@code TIMESTAMP}.
     */
    TIMESTAMP(Types.TIMESTAMP, "Date", "DATE"),
    /**
     * Identifies the generic SQL type {@code BINARY}.
     */
    BINARY(Types.BINARY, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code VARBINARY}.
     */
    VARBINARY(Types.VARBINARY, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code LONGVARBINARY}.
     */
    LONGVARBINARY(Types.LONGVARBINARY, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL value {@code NULL}.
     */
    NULL(Types.NULL, "String", "VARCHAR"),
    /**
     * Indicates that the SQL type is database-specific and gets mapped to a Java object that can be accessed via the
     * methods getObject and setObject.
     */
    OTHER(Types.OTHER, "String", "VARCHAR"),
    /**
     * Indicates that the SQL type is database-specific and gets mapped to a Java object that can be accessed via the
     * methods getObject and setObject.
     */
    JAVA_OBJECT(Types.JAVA_OBJECT, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code DISTINCT}.
     */
    DISTINCT(Types.DISTINCT, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code STRUCT}.
     */
    STRUCT(Types.STRUCT, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code ARRAY}.
     */
    ARRAY(Types.ARRAY, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code BLOB}.
     */
    BLOB(Types.BLOB, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code CLOB}.
     */
    CLOB(Types.CLOB, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code REF}.
     */
    REF(Types.REF, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code DATALINK}.
     */
    DATALINK(Types.DATALINK, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code BOOLEAN}.
     */
    BOOLEAN(Types.BOOLEAN, "Boolean", "BOOLEAN"),
    /**
     * Identifies the SQL type {@code ROWID}.
     */
    ROWID(Types.ROWID, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code NCHAR}.
     */
    NCHAR(Types.NCHAR, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code NVARCHAR}.
     */
    NVARCHAR(Types.NVARCHAR, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code LONGNVARCHAR}.
     */
    LONGNVARCHAR(Types.LONGNVARCHAR, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code NCLOB}.
     */
    NCLOB(Types.NCLOB, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code SQLXML}.
     */
    SQLXML(Types.SQLXML, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code REF_CURSOR}.
     */
    REF_CURSOR(Types.REF_CURSOR, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code TIME_WITH_TIMEZONE}.
     */
    TIME_WITH_TIMEZONE(Types.TIME_WITH_TIMEZONE, "String", "VARCHAR"),
    /**
     * Identifies the generic SQL type {@code TIMESTAMP_WITH_TIMEZONE}.
     */
    TIMESTAMP_WITH_TIMEZONE(Types.TIMESTAMP_WITH_TIMEZONE, "String", "VARCHAR");
    /**
     * The Integer value for the JDBCType. It maps to a value in {@code Types.java}
     */
    private Integer key;

    private String jdbcType;

    private String javaType;

    /**
     * Constructor to specify the data type value from {@code Types) for
     * this data type. @param type The value from {@code Types) for this data type
     */
    EntityMapping(final Integer key, final String javaType, final String jdbcType) {
        this.key = key;
        this.javaType = javaType;
        this.jdbcType = jdbcType;
    }

    /**
     * {@inheritDoc }
     * 
     * @return The name of this {@code SQLType}.
     */
    public String getName() {
        return name();
    }

    /**
     * {@inheritDoc }
     * 
     * @return The type of this {@code SQLType}.
     */
    public String getJavaType() {
        return javaType;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    /**
     * {@inheritDoc }
     * 
     * @return The value of this {@code value}.
     */
    public Integer getKey() {
        return key;
    }

    /**
     * Returns the name of the vendor that supports this data type.
     * 
     * @return The name of the vendor for this data type which is {@literal java.sql} for JDBCType.
     */
    public String getVendor() {
        return "java.sql";
    }

    /**
     * Returns the vendor specific type number for the data type.
     * 
     * @return An Integer representing the data type. For {@code JDBCType}, the value will be the same value as in
     *         {@code Types} for the data type.
     */
    public Integer getVendorTypeNumber() {
        return key;
    }

    /**
     * Returns the {@code JDBCType} that corresponds to the specified {@code Types} value
     * 
     * @param type
     *            {@code Types} value
     * @return The {@code JDBCType} constant
     * @throws IllegalArgumentException
     *             if this enum type has no constant with the specified {@code Types} value
     * @see Types
     */
    public static EntityMapping forKey(int key) {
        for (EntityMapping sqlType : EntityMapping.class.getEnumConstants()) {
            if (key == sqlType.key)
                return sqlType;
        }
        throw new IllegalArgumentException("Type:" + key + " is not a valid " + "Types.java value.");
    }

}
