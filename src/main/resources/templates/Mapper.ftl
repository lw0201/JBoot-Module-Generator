<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.dao.I${entityName}Dao">

    <!-- 基础字段返回信息配置 -->
    <resultMap id="BaseResultMap" type="${packageName}.entity.${entityName}VO">
        <id column="${pk.fieldName}" jdbcType="${pk.em.jdbcType}" property="${pk.attrName}" />
        <#list fields as field>
        <#if field.fieldName != pk.fieldName >
        <result column="${field.fieldName}" jdbcType="${field.em.jdbcType}" property="${field.attrName}" />
        </#if>
        </#list>
    </resultMap>

    <!-- 基础字段信息配置 -->
    <sql id="Base_Column_List">
        <#list fields as field><#if !field_has_next>${field.fieldName}<#else>${field.fieldName},</#if></#list>
    </sql>

    <!-- 基础条件查询配置 -->
    <sql id="Base_Where_Clause">
        <where>
            <#list fields as field>
            <if test="${field.attrName} != null">
                and ${field.fieldName} = ${r'#{'}entity.${field.attrName},jdbcType=${field.em.jdbcType}${r'}'}
            </if>
            </#list>
        </where>
    </sql>

    <!-- 根据主键信息查询返回实体对象 -->
    <select id="findById" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from emp
        where ${pk.fieldName} = ${r'#{'}${pk.attrName},jdbcType=${pk.em.jdbcType}${r'}'}
    </select>

    <!-- 根据实体对象信息查询返回实体对象 -->
    <select id="select" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        <if test="_parameter != null">
            <include refid="Base_Where_Clause" />
        </if>
    </select>

    <!-- 根据实体对象信息查询返回实体对象集合 -->
    <select id="findList" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        <if test="_parameter != null">
            <include refid="Base_Where_Clause" />
        </if>
    </select>

    <!-- 根据主键信息删除实体对象 -->
    <delete id="deleteById" parameterType="java.lang.Integer">
        delete from ${tableName}
        where ${pk.fieldName} = ${r'#{'}${pk.attrName},jdbcType=${pk.em.jdbcType}${r'}'}
    </delete>

    <!-- 根据实体对象删除数据-->
    <delete id="delete" parameterType="org.jboot.generator.entity.${entityName}VO">
        delete from ${tableName}
        <include refid="Base_Where_Clause" />
    </delete>

    <!-- 根据实体对象删除数据-->
    <delete id="deletes" parameterType="org.jboot.generator.entity.${entityName}VO">
        delete from ${tableName} where ${pk.fieldName} in
        <foreach collection="list" item="item" open="(" separator="," close=")">
            ${r'#{'}item.attrName${r'}'}
        </foreach>
    </delete>

    <!-- 插入实体对象 -->
    <insert id="insert" parameterType="org.jboot.generator.entity.${entityName}VO">
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list fields as field>
            <if test="${field.attrName} != null">
                ${field.fieldName},
            </if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <#list fields as field>
            <if test="${field.attrName} != null">
                ${r'#{'}${field.attrName},jdbcType=${field.em.jdbcType}${r'}'},
            </if>
            </#list>
        </trim>
    </insert>

    <!-- 插入实体对象 -->
    <insert id="inserts" parameterType="org.jboot.generator.entity.${entityName}VO">
        insert into ${tableName}
        <trim prefix="(" suffix=") values" suffixOverrides=",">
            <#list fields as field>
            <#if !field_has_next>
            ${field.fieldName}
            <#else>
            ${field.fieldName},
            </#if>
            </#list>
        </trim>
        <foreach collection="list" item="item" index="index" separator=",">
            (
            <#list fields as field>
            <#if !field_has_next>
            ${r'#{'}${field.attrName},jdbcType=${field.em.jdbcType}${r'}'}
            <#else>
            ${r'#{'}${field.attrName},jdbcType=${field.em.jdbcType}${r'}'},
            </#if>
            </#list>
            )
        </foreach>
    </insert>

    <!-- 更新实体对象 -->
    <update id="update" parameterType="${packageName}.entity.${entityName}VO">
        update ${tableName}
        <set>
            <#list fields as field>
            <if test="${field.attrName} != null">
                ${field.fieldName} = ${r'#{'}${field.attrName},jdbcType=${field.em.jdbcType}${r'}'},
            </if>
            </#list>
        </set>
        where ${pk.fieldName} = ${r'#{'}${pk.attrName},jdbcType=${pk.em.jdbcType}${r'}'}
    </update>

</mapper>
