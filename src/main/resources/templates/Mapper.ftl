<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.dao.I${entityName}Dao">

    <!--基础字段返回信息配置 -->
    <resultMap id="BaseResultMap" type="${packageName}.entity.${entityName}VO">
        <id column="${pk.fieldName}" jdbcType="${pk.em.jdbcType}" property="${pk.attrName}" />
        <#list fields as field>
        <#if field.fieldName != pk.fieldName >
        <result column="${field.fieldName}" jdbcType="${field.em.jdbcType}" property="${field.attrName}" />
        </#if>
        </#list>
    </resultMap>

    <!--基础字段信息配置 -->
    <sql id="Base_Column_List">
        <#list fields as field><#if !((field_index > 1) && ((field_index+1) % 6 == 0))><#if !field_has_next>`${field.fieldName}`<#else>`${field.fieldName}`,</#if><#else>
        <#if !field_has_next>`${field.fieldName}`<#else>`${field.fieldName}`,</#if></#if></#list>
    </sql>

    <!--基础条件查询配置 -->
    <sql id="Base_Where_Clause">
        <where>
            <#list fields as field>
            <if test="${field.attrName} != null">
                and `${field.fieldName}` = ${r'#{'}entity.${field.attrName},jdbcType=${field.em.jdbcType}${r'}'}
            </if>
            </#list>
        </where>
    </sql>

    <!--构造条件 -->
    <sql id="Wrapper_Where_Clause">
        <where>
            <foreach collection="wp.conditions" item="condition">
                <choose>
                    <#list fields as field>
                    <when test="condition.attr == '${field.attrName}'">
                        and `${field.fieldName}`
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    </#list>
                </choose>
            </foreach>
        </where>
    </sql>

    <!--查询操作构造器 -->
    <sql id="Wrapper_Op_Clause">
        <choose>
            <when test="condition.op.type == 'eq'">
                = ${r'#{'}condition.value${r'}'}
            </when>
            <when test="condition.op.type == 'ne'">
                != ${r'#{'}condition.value${r'}'}
            </when>
            <when test="condition.op.type == 'gt'">
                <![CDATA[ > ${r'#{'}condition.value${r'}'} ]]>
            </when>
            <when test="condition.op.type == 'ge'">
                <![CDATA[ >= ${r'#{'}condition.value${r'}'} ]]>
            </when>
            <when test="condition.op.type == 'lt'">
                <![CDATA[ < ${r'#{'}condition.value${r'}'} ]]>
            </when>
            <when test="condition.op.type == 'le'">
                <![CDATA[ <= ${r'#{'}condition.value${r'}'} ]]>
            </when>
            <when test="condition.op.type == 'like'">
                <![CDATA[ LIKE CONCAT('%',${r'#{'}condition.value${r'}'},'%')]]>
            </when>
            <when test="condition.op.type == 'notLike'">
                <![CDATA[ NOT LIKE CONCAT('%',${r'#{'}condition.value${r'}'},'%') ]]>
            </when>
            <when test="condition.op.type == 'in'">
                = ${r'#{'}condition.value${r'}'}
            </when>
            <when test="condition.op.type == 'notIn'">
                = ${r'#{'}condition.value${r'}'}
            </when>
            <when test="condition.op.type == 'in'">
                in
                <foreach collection="condition.value" item="value" separator="," open="(" close=")">
                    ${r'#{'}value${r'}'}
                </foreach>
            </when>
            <when test="condition.op.type == 'notIn'">
                not in
                <foreach collection="condition.value" item="value" separator="," open="(" close=")">
                    ${r'#{'}value${r'}'}
                </foreach>
            </when>
            <when test="condition.op.type == 'between'">
                BETWEEN ${r'#{'}condition.value${r'}'} and ${r'#{'}condition.secondValue${r'}'}
            </when>
            <when test="condition.op.type == 'notBetween'">
                NOT BETWEEN ${r'#{'}condition.value${r'}'} and ${r'#{'}condition.secondValue${r'}'}
            </when>
        </choose>
    </sql>

    <!--构造排序条件 -->
    <sql id="Wrapper_Order_Clause">
        <foreach collection="wp.sorts" item="st" separator=",">
            <choose>
                <#list fields as field>
                <when test="st.attr == '${field.attrName}'">
                    `${field.fieldName}` ${r'#{'}st.order.type${r'}'}
                </when>
                </#list>
            </choose>
        </foreach>
    </sql>

    <!--根据主键信息查询返回实体对象 -->
    <select id="findById" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        where `${pk.fieldName}` = ${r'#{'}${pk.attrName},jdbcType=${pk.em.jdbcType}${r'}'}
    </select>

    <!--根据实体对象信息查询返回实体对象 -->
    <select id="select">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        <choose>
            <when test="entity != null">
                <include refid="Base_Where_Clause" />
            </when>
            <otherwise>
                <include refid="Wrapper_Where_Clause" />
            </otherwise>
        </choose>
    </select>

    <!--根据实体对象信息查询返回实体对象集合 -->
    <select id="findList" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        <choose>
            <when test="entity != null">
                <include refid="Base_Where_Clause" />
            </when>
            <otherwise>
                <include refid="Wrapper_Where_Clause" />
            </otherwise>
        </choose>
    </select>
    
    <!--根据主键信息删除实体对象 -->
    <delete id="deleteById" parameterType="java.lang.Integer">
        delete from ${tableName}
        where `${pk.fieldName}` = ${r'#{'}${pk.attrName},jdbcType=${pk.em.jdbcType}${r'}'}
    </delete>

    <!--根据实体对象删除数据-->
    <delete id="delete" parameterType="${packageName}.entity.${entityName}VO">
        delete from ${tableName}
        <choose>
            <when test="entity != null">
                <include refid="Base_Where_Clause" />
            </when>
            <otherwise>
                <include refid="Wrapper_Where_Clause" />
            </otherwise>
        </choose>
    </delete>

    <!--根据实体对象删除数据-->
    <delete id="deletes" parameterType="${packageName}.entity.${entityName}VO">
        delete from ${tableName} where ${pk.fieldName} in
        <foreach collection="list" item="item" open="(" separator="," close=")">
            ${r'#{'}item.attrName${r'}'}
        </foreach>
    </delete>

    <!--插入实体对象 -->
    <insert id="insert" parameterType="${packageName}.entity.${entityName}VO">
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list fields as field>
            <if test="${field.attrName} != null">
                `${field.fieldName}`,
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

    <!--插入实体对象 -->
    <insert id="inserts" parameterType="${packageName}.entity.${entityName}VO">
        insert into ${tableName}
        <trim prefix="(" suffix=") values" suffixOverrides=",">
            <#list fields as field>
            <#if !field_has_next>
            `${field.fieldName}`
            <#else>
            `${field.fieldName}`,
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

    <!--更新实体对象 -->
    <update id="update">
        update ${tableName}
        <set>
            <#list fields as field>
            <if test="${field.attrName} != null">
                `${field.fieldName}` = ${r'#{entity.'}${field.attrName},jdbcType=${field.em.jdbcType}${r'}'},
            </if>
            </#list>
        </set>
        <choose>
            <when test="wp != null">
                <include refid="Wrapper_Where_Clause" />
            </when>
            <otherwise>
                where `${pk.fieldName}` = ${r'#{entity.'}${pk.attrName},jdbcType=${pk.em.jdbcType}${r'}'}
            </otherwise>
        </choose>
    </update>

</mapper>
