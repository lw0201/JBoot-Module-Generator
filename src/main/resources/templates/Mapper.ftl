<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.dao.I${entityName}Dao">

    <!-- 基础字段返回信息配置 -->
    <resultMap id="BaseResultMap" type="${packageName}.entity.${entityName}VO">
        <#list fields as field>
        <id column="${field.fieldName}" jdbcType="${field.em.jdbcType}" property="${field.attrName}" />
        </#list>
    </resultMap>

    <!-- 基础字段信息配置 -->
    <sql id="Base_Column_List">
        <#list fields as field>
            ${field.fieldName},
        </#list>
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
        where empno = ${r'#{'}id,jdbcType=INTEGER${r'}'}
    </select>

    <!-- 根据实体对象信息查询返回实体对象 -->
    <select id="select" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from emp
        <if test="_parameter != null">
            <include refid="Base_Where_Clause" />
        </if>
    </select>

    <!-- 根据实体对象信息查询返回实体对象集合 -->
    <select id="findList" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from emp
        where empno = ${r'#{'}id,jdbcType=INTEGER${r'}'}
        <if test="_parameter != null">
            <include refid="Base_Where_Clause" />
        </if>
    </select>

    <!-- 根据主键信息删除实体对象 -->
    <delete id="deleteById" parameterType="java.lang.Integer">
        delete from emp
        where
        empno = ${r'#{'}empno,jdbcType=INTEGER${r'}'}
    </delete>

    <!-- 插入实体对象 -->
    <insert id="insert" parameterType="com.frame.business.entity.EmpVO">
        insert into emp
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <if test="empno != null">
                empno,
            </if>
            <if test="ename != null">
                ename,
            </if>
            <if test="job != null">
                job,
            </if>
            <if test="mgr != null">
                mgr,
            </if>
            <if test="hiredate != null">
                hiredate,
            </if>
            <if test="sal != null">
                sal,
            </if>
            <if test="comm != null">
                comm,
            </if>
            <if test="deptno != null">
                deptno,
            </if>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <if test="empno != null">
                #{empno,jdbcType=INTEGER},
            </if>
            <if test="ename != null">
                #{ename,jdbcType=VARCHAR},
            </if>
            <if test="job != null">
                #{job,jdbcType=VARCHAR},
            </if>
            <if test="mgr != null">
                #{mgr,jdbcType=INTEGER},
            </if>
            <if test="hiredate != null">
                #{hiredate,jdbcType=DATE},
            </if>
            <if test="sal != null">
                #{sal,jdbcType=DECIMAL},
            </if>
            <if test="comm != null">
                #{comm,jdbcType=DECIMAL},
            </if>
            <if test="deptno != null">
                #{deptno,jdbcType=INTEGER},
            </if>
        </trim>
    </insert>

    <!-- 更新实体对象 -->
    <update id="update" parameterType="com.frame.business.entity.EmpVO">
        update emp
        <set>
            <if test="ename != null">
                ename = #{ename,jdbcType=VARCHAR},
            </if>
            <if test="job != null">
                job = #{job,jdbcType=VARCHAR},
            </if>
            <if test="mgr != null">
                mgr = #{mgr,jdbcType=INTEGER},
            </if>
            <if test="hiredate != null">
                hiredate = #{hiredate,jdbcType=DATE},
            </if>
            <if test="sal != null">
                sal = #{sal,jdbcType=DECIMAL},
            </if>
            <if test="comm != null">
                comm = #{comm,jdbcType=DECIMAL},
            </if>
            <if test="deptno != null">
                deptno = #{deptno,jdbcType=INTEGER},
            </if>
        </set>
        where empno = #{empno,jdbcType=INTEGER}
    </update>

</mapper>
