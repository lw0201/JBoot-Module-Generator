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
        <#list fields as field><#if !((field_index > 1) && ((field_index+1) % 6 == 0))><#if !field_has_next>t.`${field.fieldName}`<#else>t.`${field.fieldName}`,</#if><#else>
        <#if !field_has_next>t.`${field.fieldName}`<#else>t.`${field.fieldName}`,</#if></#if></#list>
    </sql>

    <!--基础条件查询配置 -->
    <sql id="Base_Where_Clause">
        <where>
            <#list fields as field>
            <if test="entity.${field.attrName} != null">
                and t.`${field.fieldName}` = ${r'#{'}entity.${field.attrName},jdbcType=${field.em.jdbcType}${r'}'}
            </if>
            </#list>
        </where>
    </sql>

    <!--构造条件 -->
    <sql id="Wrapper_Where_Clause">
        <where>
            <foreach collection="wp.criterias" item="criteria" separator="or">
                <trim prefix="(" prefixOverrides="and" suffix=")">
                    <foreach collection="criteria.criterions" item="criterion">
                         <include refid="Wrapper_Where_Op_Clause"></include>
                    </foreach>
                </trim>
            </foreach>
        </where>
    </sql>

    <!--构造操作条件 -->
    <sql id="Wrapper_Where_Op_Clause">
        <choose>
            <when test="criterion.op.type == 'like' or criterion.op.type == 'notLike'">
                <choose>
                    <#list fields as field>
                    <when test="criterion.attr == '${field.attrName}'">
                        and LOWER(t.`${field.fieldName}`)
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    </#list>
                    <otherwise>
                        and false
                    </otherwise>
                </choose>
            </when>
            <otherwise>
                <choose>
                    <#list fields as field>
                    <when test="criterion.attr == '${field.attrName}'">
                        and t.`${field.fieldName}`
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    </#list>
                    <otherwise>
                        and false
                    </otherwise>
                </choose>
            </otherwise>
        </choose>
    </sql>

    <!--查询操作构造器 -->
    <sql id="Wrapper_Op_Clause">
        <choose>
            <when test="criterion.op.type == 'eq'">
                = ${r'#{'}criterion.value${r'}'}
            </when>
            <when test="criterion.op.type == 'ne'">
                != ${r'#{'}criterion.value${r'}'}
            </when>
            <when test="criterion.op.type == 'gt'">
                <![CDATA[ > ${r'#{'}criterion.value${r'}'} ]]>
            </when>
            <when test="criterion.op.type == 'ge'">
                <![CDATA[ >= ${r'#{'}criterion.value${r'}'} ]]>
            </when>
            <when test="criterion.op.type == 'lt'">
                <![CDATA[ < ${r'#{'}criterion.value${r'}'} ]]>
            </when>
            <when test="criterion.op.type == 'le'">
                <![CDATA[ <= ${r'#{'}criterion.value${r'}'} ]]>
            </when>
            <when test="criterion.op.type == 'like'">
                <![CDATA[ LIKE CONCAT('%',LOWER(${r'#{'}criterion.value${r'}'}),'%')]]>
            </when>
            <when test="criterion.op.type == 'notLike'">
                <![CDATA[ NOT LIKE CONCAT('%',LOWER(${r'#{'}criterion.value${r'}'}),'%') ]]>
            </when>
            <when test="criterion.op.type == 'isNull'">
                is null
            </when>
            <when test="criterion.op.type == 'isNotNull'">
                is not null
            </when>
            <when test="criterion.op.type == 'in'">
                in
                <foreach collection="criterion.value" item="value" separator="," open="(" close=")">
                    ${r'#{'}value${r'}'}
                </foreach>
            </when>
            <when test="criterion.op.type == 'notIn'">
                not in
                <foreach collection="criterion.value" item="value" separator="," open="(" close=")">
                    ${r'#{'}value${r'}'}
                </foreach>
            </when>
            <when test="criterion.op.type == 'between'">
                BETWEEN ${r'#{'}criterion.value${r'}'} and ${r'#{'}criterion.secondValue${r'}'}
            </when>
            <when test="criterion.op.type == 'notBetween'">
                NOT BETWEEN ${r'#{'}criterion.value${r'}'} and ${r'#{'}criterion.secondValue${r'}'}
            </when>
        </choose>
    </sql>

    <!--构造排序条件 -->
    <sql id="Wrapper_Order_Clause">
        <if test="wp.sorts != null">
            <foreach collection="wp.sorts" open=" order by " item="st" separator=",">
                <choose>
                    <#list fields as field>
                    <when test="st.attr == '${field.attrName}'">
                        t.`${field.fieldName}` ${r'${'}st.order.type${r'}'}
                    </when>
                    </#list>
                </choose>
            </foreach>
        </if>
    </sql>

    <!--根据主键信息查询返回实体对象 -->
    <select id="findById" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from `${tableName}` t
        where t.`${pk.fieldName}` = ${r'#{'}${pk.attrName},jdbcType=${pk.em.jdbcType}${r'}'}
    </select>

    <!--根据实体对象信息查询返回实体对象 -->
    <select id="query" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from `${tableName}` t
        <include refid="Base_Where_Clause" />
    </select>

    <!--根据实体对象信息查询返回实体对象集合 -->
    <select id="findList" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from `${tableName}` t
        <if test="_parameter != null">
            <include refid="Base_Where_Clause" />
        </if>
    </select>
    
    <!--根据主键信息删除实体对象 -->
    <delete id="deleteById" parameterType="java.io.Serializable">
        delete t from `${tableName}` t
        where t.`${pk.fieldName}` = ${r'#{'}${pk.attrName},jdbcType=${pk.em.jdbcType}${r'}'}
    </delete>
    
    <!--根据实体对象删除数据-->
    <delete id="delete" parameterType="${packageName}.entity.${entityName}VO">
        delete t from `${tableName}` t
        <include refid="Base_Where_Clause" />
    </delete>

    <!--根据实体对象删除数据-->
    <delete id="deletes" parameterType="${packageName}.entity.${entityName}VO">
        delete t from `${tableName}` t where t.`${pk.fieldName}` in
        <foreach collection="list" item="item" open="(" separator="," close=")">
            ${r'#{'}item.attrName${r'}'}
        </foreach>
    </delete>

    <!--插入实体对象 -->
    <insert id="insert" parameterType="${packageName}.entity.${entityName}VO">
        <selectKey order="BEFORE" resultType="java.lang.String" keyProperty="${pk.attrName}">
            select uuid() 
        </selectKey>
        insert into `${tableName}`
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list fields as field>
            <#if field.attrName =='lastUpdateDate' || field.attrName =='createdDate'>
            <if test="${field.attrName} != null or ${field.attrName} == null">
                `${field.fieldName}`,
            </if>
            <#else>
            <if test="${field.attrName} != null">
                `${field.fieldName}`,
            </if>
            </#if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <#list fields as field>
            <#if field.attrName =='lastUpdateDate' || field.attrName =='createdDate'>
            <if test="${field.attrName} != null or ${field.attrName} == null">
                current_timestamp(),
            </if>
            <#else>
            <if test="${field.attrName} != null">
                ${r'#{'}${field.attrName},jdbcType=${field.em.jdbcType}${r'}'},
            </if>
            </#if>
            </#list>
        </trim>
    </insert>

    <!--插入实体对象 -->
    <insert id="inserts" parameterType="${packageName}.entity.${entityName}VO">
        insert into `${tableName}`
        <trim prefix="(" suffix=") values" suffixOverrides=",">
            <#list fields as field>
            `${field.fieldName}`<#if field_has_next>,</#if>
            </#list>
        </trim>
        <foreach collection="list" item="item" index="index" separator=",">
            (
            <#list fields as field>
            <#if field.attrName =='lastUpdateDate' || field.attrName =='createdDate'>
            current_timestamp()<#if field_has_next>,</#if>
            <#elseif field.fieldName == pk.fieldName >
            UUID()<#if field_has_next>,</#if>
            <#else>
            ${r'#{item.'}${field.attrName},jdbcType=${field.em.jdbcType}${r'}'}<#if field_has_next>,</#if>
            </#if>
            </#list>
            )
        </foreach>
    </insert>

    <!--更新实体对象 -->
    <update id="update">
        update `${tableName}` t
        <set>
            <#list fields as field>
            <#if field.attrName =='lastUpdateDate'>
            <if test="entity.${field.attrName} == null or entity.${field.attrName} != null">
                t.`${field.fieldName}` = current_timestamp(),
            </if>
            <#elseif field.attrName =='createdDate' || field.attrName =='createdBy' || field.fieldName == pk.fieldName>
            <#else>
            <if test="entity.${field.attrName} != null">
                t.`${field.fieldName}` = ${r'#{entity.'}${field.attrName},jdbcType=${field.em.jdbcType}${r'}'},
            </if>
            </#if>
            </#list>
        </set>
        where t.`${pk.fieldName}` = ${r'#{entity.'}${pk.attrName},jdbcType=${pk.em.jdbcType}${r'}'}
    </update>

    <!--构造器查询 -->
    <select id="queryByWrapper" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from `${tableName}` t
        <if test="wp != null">
            <include refid="Wrapper_Where_Clause" />
        </if>
    </select>
    
    <!--构造器查询 -->
    <select id="findByWrapper" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from `${tableName}` t
        <if test="wp != null">
            <include refid="Wrapper_Where_Clause" />
            <include refid="Wrapper_Order_Clause" />
        </if>
    </select>

    <!--更新实体对象 -->
    <update id="updateByWrapper">
        update `${tableName}` t
        <set>
            <#list fields as field>
            <#if field.attrName =='lastUpdateDate'>
            <if test="entity.${field.attrName} == null or entity.${field.attrName} != null">
                t.`${field.fieldName}` = current_timestamp(),
            </if>
            <#elseif field.attrName =='createdDate' || field.attrName =='createdBy'>
            <#else>
            <if test="entity.${field.attrName} != null">
                t.`${field.fieldName}` = ${r'#{entity.'}${field.attrName},jdbcType=${field.em.jdbcType}${r'}'},
            </if>
            </#if>
            </#list>
        </set>
        <include refid="Wrapper_Where_Clause" />
    </update>
    
    <!--根据实体对象删除数据-->
    <delete id="deleteByWrapper">
        delete t from `${tableName}` t
        <include refid="Wrapper_Where_Clause" />
    </delete>

</mapper>