##### JBoot-Module-Generator使用
######修改连接数据库
```yml
spring:
   application:
      name: Generator
   datasource:
      driverClassName: com.mysql.cj.jdbc.Driver
      type: com.alibaba.druid.pool.DruidDataSource
      url: jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8
      username: root
      password: 123456
```
######修改代码生成路径
```yml
jboot:
   package: org.jboot.generator
   java: src/main/java
   resource: src/main/resources
```
######运行application启动类
```log
auto code generator complete.......
```
```log
出现以上表示已经启动完成
```
#####生成代码如下
######实体类代码生成如下
```java
package org.jboot.generator.entity;

import java.util.Date;
import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import org.jboot.generator.base.BaseVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Emp 实体类
 * 
 * @author liwen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class EmpVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * 雇员编号
     */
    @ApiModelProperty("雇员编号")
    private Integer empno;

    /**
     * 雇员姓名
     */
    @Length(max = 15)
    @ApiModelProperty("雇员姓名")
    private String ename;

    /**
     * 雇员职位
     */
    @Length(max = 10)
    @ApiModelProperty("雇员职位")
    private String job;

    /**
     * 雇员对应的领导的编号
     */
    @ApiModelProperty("雇员对应的领导的编号")
    private Integer mgr;

    /**
     * 雇员的雇佣日期
     */
    @ApiModelProperty("雇员的雇佣日期")
    private Date hiredate;

    /**
     * 雇员的基本工资
     */
    @ApiModelProperty("雇员的基本工资")
    private BigDecimal sal;

    /**
     * 奖金
     */
    @ApiModelProperty("奖金")
    private BigDecimal comm;

    /**
     * 所在部门
     */
    @ApiModelProperty("所在部门")
    private Integer deptno;


}
```
######Mapper代码生成如下
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.jboot.generator.dao.IEmpDao">

    <!--基础字段返回信息配置 -->
    <resultMap id="BaseResultMap" type="org.jboot.generator.entity.EmpVO">
        <id column="empno" jdbcType="INTEGER" property="empno" />
        <result column="ename" jdbcType="VARCHAR" property="ename" />
        <result column="job" jdbcType="VARCHAR" property="job" />
        <result column="mgr" jdbcType="INTEGER" property="mgr" />
        <result column="hiredate" jdbcType="DATE" property="hiredate" />
        <result column="sal" jdbcType="DECIMAL" property="sal" />
        <result column="comm" jdbcType="DECIMAL" property="comm" />
        <result column="deptno" jdbcType="INTEGER" property="deptno" />
    </resultMap>

    <!--基础字段信息配置 -->
    <sql id="Base_Column_List">
        t.`empno`,t.`ename`,t.`job`,t.`mgr`,t.`hiredate`,
        t.`sal`,t.`comm`,t.`deptno`
    </sql>

    <!--基础条件查询配置 -->
    <sql id="Base_Where_Clause">
        <where>
            <if test="entity.empno != null">
                and t.`empno` = #{entity.empno,jdbcType=INTEGER}
            </if>
            <if test="entity.ename != null">
                and t.`ename` = #{entity.ename,jdbcType=VARCHAR}
            </if>
            <if test="entity.job != null">
                and t.`job` = #{entity.job,jdbcType=VARCHAR}
            </if>
            <if test="entity.mgr != null">
                and t.`mgr` = #{entity.mgr,jdbcType=INTEGER}
            </if>
            <if test="entity.hiredate != null">
                and t.`hiredate` = #{entity.hiredate,jdbcType=DATE}
            </if>
            <if test="entity.sal != null">
                and t.`sal` = #{entity.sal,jdbcType=DECIMAL}
            </if>
            <if test="entity.comm != null">
                and t.`comm` = #{entity.comm,jdbcType=DECIMAL}
            </if>
            <if test="entity.deptno != null">
                and t.`deptno` = #{entity.deptno,jdbcType=INTEGER}
            </if>
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
                    <when test="criterion.attr == 'empno'">
                        and LOWER(t.`empno`)
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'ename'">
                        and LOWER(t.`ename`)
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'job'">
                        and LOWER(t.`job`)
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'mgr'">
                        and LOWER(t.`mgr`)
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'hiredate'">
                        and LOWER(t.`hiredate`)
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'sal'">
                        and LOWER(t.`sal`)
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'comm'">
                        and LOWER(t.`comm`)
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'deptno'">
                        and LOWER(t.`deptno`)
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <otherwise>
                        and false
                    </otherwise>
                </choose>
            </when>
            <otherwise>
                <choose>
                    <when test="criterion.attr == 'empno'">
                        and t.`empno`
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'ename'">
                        and t.`ename`
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'job'">
                        and t.`job`
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'mgr'">
                        and t.`mgr`
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'hiredate'">
                        and t.`hiredate`
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'sal'">
                        and t.`sal`
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'comm'">
                        and t.`comm`
                        <include refid="Wrapper_Op_Clause" />
                    </when>
                    <when test="criterion.attr == 'deptno'">
                        and t.`deptno`
                        <include refid="Wrapper_Op_Clause" />
                    </when>
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
                = #{criterion.value}
            </when>
            <when test="criterion.op.type == 'ne'">
                != #{criterion.value}
            </when>
            <when test="criterion.op.type == 'gt'">
                <![CDATA[ > #{criterion.value} ]]>
            </when>
            <when test="criterion.op.type == 'ge'">
                <![CDATA[ >= #{criterion.value} ]]>
            </when>
            <when test="criterion.op.type == 'lt'">
                <![CDATA[ < #{criterion.value} ]]>
            </when>
            <when test="criterion.op.type == 'le'">
                <![CDATA[ <= #{criterion.value} ]]>
            </when>
            <when test="criterion.op.type == 'like'">
                <![CDATA[ LIKE CONCAT('%',LOWER(#{criterion.value}),'%')]]>
            </when>
            <when test="criterion.op.type == 'notLike'">
                <![CDATA[ NOT LIKE CONCAT('%',LOWER(#{criterion.value}),'%') ]]>
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
                    #{value}
                </foreach>
            </when>
            <when test="criterion.op.type == 'notIn'">
                not in
                <foreach collection="criterion.value" item="value" separator="," open="(" close=")">
                    #{value}
                </foreach>
            </when>
            <when test="criterion.op.type == 'between'">
                BETWEEN #{criterion.value} and #{criterion.secondValue}
            </when>
            <when test="criterion.op.type == 'notBetween'">
                NOT BETWEEN #{criterion.value} and #{criterion.secondValue}
            </when>
        </choose>
    </sql>

    <!--构造排序条件 -->
    <sql id="Wrapper_Order_Clause">
        <if test="wp.sorts != null">
            <foreach collection="wp.sorts" open=" order by " item="st" separator=",">
                <choose>
                    <when test="st.attr == 'empno'">
                        t.`empno` ${st.order.type}
                    </when>
                    <when test="st.attr == 'ename'">
                        t.`ename` ${st.order.type}
                    </when>
                    <when test="st.attr == 'job'">
                        t.`job` ${st.order.type}
                    </when>
                    <when test="st.attr == 'mgr'">
                        t.`mgr` ${st.order.type}
                    </when>
                    <when test="st.attr == 'hiredate'">
                        t.`hiredate` ${st.order.type}
                    </when>
                    <when test="st.attr == 'sal'">
                        t.`sal` ${st.order.type}
                    </when>
                    <when test="st.attr == 'comm'">
                        t.`comm` ${st.order.type}
                    </when>
                    <when test="st.attr == 'deptno'">
                        t.`deptno` ${st.order.type}
                    </when>
                </choose>
            </foreach>
        </if>
    </sql>

    <!--根据主键信息查询返回实体对象 -->
    <select id="findById" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from `emp` t
        where t.`empno` = #{empno,jdbcType=INTEGER}
    </select>

    <!--根据实体对象信息查询返回实体对象 -->
    <select id="query" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from `emp` t
        <include refid="Base_Where_Clause" />
    </select>

    <!--根据实体对象信息查询返回实体对象集合 -->
    <select id="findList" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from `emp` t
        <if test="_parameter != null">
            <include refid="Base_Where_Clause" />
        </if>
    </select>

    <!--根据主键信息删除实体对象 -->
    <delete id="deleteById" parameterType="java.io.Serializable">
        delete t from `emp`
        where t.`empno` = #{empno,jdbcType=INTEGER}
    </delete>

    <!--根据实体对象删除数据-->
    <delete id="delete" parameterType="org.jboot.generator.entity.EmpVO">
        delete t from `emp` t
        <include refid="Base_Where_Clause" />
    </delete>

    <!--根据实体对象删除数据-->
    <delete id="deletes" parameterType="org.jboot.generator.entity.EmpVO">
        delete t from `emp` t where t.`empno` in
        <foreach collection="list" item="item" open="(" separator="," close=")">
            #{item.attrName}
        </foreach>
    </delete>

    <!--插入实体对象 -->
    <insert id="insert" parameterType="org.jboot.generator.entity.EmpVO">
        <selectKey order="BEFORE" resultType="java.lang.String" keyProperty="empno">
            select uuid() 
        </selectKey>
        insert into `emp`
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <if test="empno != null">
                `empno`,
            </if>
            <if test="ename != null">
                `ename`,
            </if>
            <if test="job != null">
                `job`,
            </if>
            <if test="mgr != null">
                `mgr`,
            </if>
            <if test="hiredate != null">
                `hiredate`,
            </if>
            <if test="sal != null">
                `sal`,
            </if>
            <if test="comm != null">
                `comm`,
            </if>
            <if test="deptno != null">
                `deptno`,
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

    <!--插入实体对象 -->
    <insert id="inserts" parameterType="org.jboot.generator.entity.EmpVO">
        insert into `emp`
        <trim prefix="(" suffix=") values" suffixOverrides=",">
            `empno`,
            `ename`,
            `job`,
            `mgr`,
            `hiredate`,
            `sal`,
            `comm`,
            `deptno`
        </trim>
        <foreach collection="list" item="item" index="index" separator=",">
            (
            UUID(),
            #{item.ename,jdbcType=VARCHAR},
            #{item.job,jdbcType=VARCHAR},
            #{item.mgr,jdbcType=INTEGER},
            #{item.hiredate,jdbcType=DATE},
            #{item.sal,jdbcType=DECIMAL},
            #{item.comm,jdbcType=DECIMAL},
            #{item.deptno,jdbcType=INTEGER}
            )
        </foreach>
    </insert>

    <!--更新实体对象 -->
    <update id="update">
        update `emp` t
        <set>
            <if test="entity.ename != null">
                t.`ename` = #{entity.ename,jdbcType=VARCHAR},
            </if>
            <if test="entity.job != null">
                t.`job` = #{entity.job,jdbcType=VARCHAR},
            </if>
            <if test="entity.mgr != null">
                t.`mgr` = #{entity.mgr,jdbcType=INTEGER},
            </if>
            <if test="entity.hiredate != null">
                t.`hiredate` = #{entity.hiredate,jdbcType=DATE},
            </if>
            <if test="entity.sal != null">
                t.`sal` = #{entity.sal,jdbcType=DECIMAL},
            </if>
            <if test="entity.comm != null">
                t.`comm` = #{entity.comm,jdbcType=DECIMAL},
            </if>
            <if test="entity.deptno != null">
                t.`deptno` = #{entity.deptno,jdbcType=INTEGER},
            </if>
        </set>
        where t.`empno` = #{entity.empno,jdbcType=INTEGER}
    </update>

    <!--构造器查询 -->
    <select id="queryByWrapper" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from `emp` t
        <if test="wp != null">
            <include refid="Wrapper_Where_Clause" />
        </if>
    </select>

    <!--构造器查询 -->
    <select id="findByWrapper" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from `emp` t
        <if test="wp != null">
            <include refid="Wrapper_Where_Clause" />
            <include refid="Wrapper_Order_Clause" />
        </if>
    </select>

    <!--更新实体对象 -->
    <update id="updateByWrapper">
        update `emp` t
        <set>
            <if test="entity.empno != null">
                t.`empno` = #{entity.empno,jdbcType=INTEGER},
            </if>
            <if test="entity.ename != null">
                t.`ename` = #{entity.ename,jdbcType=VARCHAR},
            </if>
            <if test="entity.job != null">
                t.`job` = #{entity.job,jdbcType=VARCHAR},
            </if>
            <if test="entity.mgr != null">
                t.`mgr` = #{entity.mgr,jdbcType=INTEGER},
            </if>
            <if test="entity.hiredate != null">
                t.`hiredate` = #{entity.hiredate,jdbcType=DATE},
            </if>
            <if test="entity.sal != null">
                t.`sal` = #{entity.sal,jdbcType=DECIMAL},
            </if>
            <if test="entity.comm != null">
                t.`comm` = #{entity.comm,jdbcType=DECIMAL},
            </if>
            <if test="entity.deptno != null">
                t.`deptno` = #{entity.deptno,jdbcType=INTEGER},
            </if>
        </set>
        <include refid="Wrapper_Where_Clause" />
    </update>

    <!--根据实体对象删除数据-->
    <delete id="deleteByWrapper">
        delete t from `emp` t
        <include refid="Wrapper_Where_Clause" />
    </delete>

</mapper>
```
######Controller层代码生成如下，Dao、Service代码略...
```java
package org.jboot.generator.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboot.generator.base.Result;
import org.jboot.generator.conditions.Wrapper;
import org.jboot.generator.entity.EmpVO;
import org.jboot.generator.service.IEmpService;
import org.jboot.generator.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

/**
 * Emp实体控制层
 * 
 * @author liwen
 *
 */
@RestController
public class EmpController {

    @Autowired
    IEmpService iEmpService;

    /**
     * 新增实体数据
     * 
     * @param entity
     *            业务实体
     * @return 返回新增影响的数据
     */
    @PostMapping("/v1/emp/save")
    public Result<Integer> save(@RequestBody EmpVO entity) {
        return new Result<Integer>().success(iEmpService.insert(entity));
    }

    /**
     * 根据实体ID删除数据，并持久化删除数据。
     * 
     * @param id
     *            实体ID
     * @return 返回删除影响的实体
     */
    @DeleteMapping("/v1/emp/delete/{id}")
    public Result<Integer> delete(@PathVariable("id") String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "路径参数[id]错误。");
        return new Result<Integer>().success(iEmpService.deleteById(id));
    }

    /**
     * 跟新实体数据并持久化保存操作
     * 
     * @param entity
     *            操作的业务实体对象
     * @return 返回影响的行
     */
    @PostMapping("/v1/emp/update")
    public Result<Integer> update(@RequestBody EmpVO entity) {
        return new Result<Integer>().success(iEmpService.update(entity));
    }

    /**
     * 根据实体ID查询实体对象并返回实体对象的详细信息
     * 
     * @param id
     *            实体对象对应的ID
     * @return 返回实体对象的相信信息
     */
    @GetMapping("/v1/emp/single/{id}")
    public Result<EmpVO> findById(@PathVariable("id") String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "路径参数[id]错误。");
        return new Result<EmpVO>().success(iEmpService.findById(id));
    }

    /**
     * 根据实体查询并返回实体对象集合
     * 
     * @param entity
     *            业务实体对象
     * @return 实体对象集合
     */
    @PostMapping("/v1/emp/find/list")
    public Result<List<EmpVO>> findList(@RequestBody EmpVO entity) {
        return new Result<List<EmpVO>>().success(iEmpService.findList(entity));
    }

    /**
     * 分页操作
     * 
     * @param entity
     *            业务实体对象
     * @param pageNo
     *            起始页
     * @param pageSize
     *            显示数量
     * @return 返回实体的分页信息
     */
    @PostMapping("/v1/emp/page/{pageNo}/{pageSize}")
    public Result<PageInfo<EmpVO>> findPage(@RequestBody Wrapper<EmpVO> entity, @PathVariable("pageNo") int pageNo,
        @PathVariable("pageSize") int pageSize) {
        return new Result<PageInfo<EmpVO>>().success(iEmpService.findPage(entity, pageNo, pageSize));
    }

}

```