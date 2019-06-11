package org.jboot.generator.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jboot.generator.conditions.Wrapper;

/**
 * 基础数据持久层
 * 
 * @author liwen
 *
 * @param <T>
 *            操作实体
 */
public interface IBaseDao<T> {

    /**
     * 新增实体数据
     * 
     * @param entity
     *            实体对象
     * @return int 返回实体操作所影响的行
     */
    int insert(T entity);

    /**
     * 批量插入实体对象操作
     * 
     * @param entitys
     *            实体集合对象
     * @return int 返回实体操作所影响的行
     */
    int inserts(Collection<T> entitys);

    /**
     * 根据实体ID删除实体对象
     * 
     * @param id
     *            实体对应的ID
     * @return int 返回删除实体影响的行
     */
    int deleteById(Serializable id);

    /**
     * 按照实体删除
     * 
     * @param entitys
     *            操作业务实体
     * @return int 返回删除实体影响的行
     */
    int delete(@Param("entity") T entity);

    /**
     * 批量删除
     * 
     * @param entitys
     *            操作业务实体
     * @return int 返回删除实体影响的行
     */
    int deletes(Collection<T> entitys);

    /**
     * 根据实体ID更新实体对象操作
     * 
     * @param entity
     *            实体对象
     * @return int 返回更新实体影响的行
     */
    int update(@Param("entity") T entity);

    /**
     * 根据业务实体ID可查询返回业务实体的详细信息
     * 
     * @param id
     *            业务实体ID
     * @return T 返回业务实体的详细信息
     */
    T findById(Serializable id);

    /**
     * 根据实体对象查询并返回单个实体对象
     * 
     * @param entity
     *            业务实体
     * @return T 返回单个业务实体对象详细信息
     */
    T query(@Param("entity") T entity);

    /**
     * 查询业务实体集合
     * 
     * @return List<T> 返回实体集合
     */
    List<T> findList();

    /**
     * 根据实体对象返回实体集合
     * 
     * @param entity
     *            业务实体对象
     * @return List<T> 返回业务实体对象集合
     */
    List<T> findList(@Param("entity") T entity);

    /**
     * 根据实体对象查询并返回单个实体对象
     * 
     * @param entity
     *            业务实体
     * @return T 返回单个业务实体对象详细信息
     */
    T queryByWrapper(@Param("wp") Wrapper<T> wrapper);

    /**
     * 根据构造器来查询数据
     * 
     * @param wrapper
     * @return List<T> 返回业务实体对象集合
     */
    List<T> findByWrapper(@Param("wp") Wrapper<T> wrapper);

    /**
     * 根据构造器来修改对象
     * 
     * @param entity
     *            实体对象
     * @param wrapper
     *            构造器
     * @return int 返回更新实体影响的行
     */
    int deleteByWrapper(@Param("wp") Wrapper<T> wrapper);

    /**
     * 根据构造器来修改对象
     * 
     * @param entity
     *            实体对象
     * @param wrapper
     *            构造器
     * @return int 返回更新实体影响的行
     */
    int updateByWrapper(@Param("entity") T entity, @Param("wp") Wrapper<T> wrapper);

}
