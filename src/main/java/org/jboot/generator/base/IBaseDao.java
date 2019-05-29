package org.jboot.generator.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <li>基础数据持久层
 * 
 * @author liwen
 *
 * @param <T>
 *            操作实体
 */
public interface IBaseDao<T> {

    /**
     * <li>新增实体数据
     * 
     * @param entity
     *            :实体对象
     * @return 返回实体操作所影响的行
     */
    int insert(T entity);

    /**
     * <li>批量插入实体对象操作
     * 
     * @param entitys
     *            :实体集合对象
     * @return
     */
    int inserts(Collection<T> entitys);

    /**
     * <li>根据实体ID删除实体对象
     * 
     * @param id
     *            :实体对应的ID
     * @return 返回删除实体影响的行
     */
    int deleteById(Serializable id);

    /**
     * <li>根据实体ID更新实体对象操作
     * 
     * @param entity
     *            :实体对象
     * @return
     */
    int update(T entity);

    /**
     * <li>根据业务实体ID可查询返回业务实体的详细信息
     * 
     * @param id
     *            :业务实体ID
     * @return 返回业务实体的详细信息
     */
    T findById(Serializable id);

    /**
     * <li>根据实体对象查询并返回单个实体对象
     * 
     * @param entity
     *            :业务实体
     * @return 返回单个业务实体对象详细信息
     */
    T select(T entity);

    /**
     * <li>查询业务实体集合
     * 
     * @return 返回实体集合
     */
    List<T> findList();

    /**
     * <li>根据实体对象返回实体集合
     * 
     * @param entity
     *            :业务实体对象
     * @return 返回业务实体对象集合
     */
    List<T> findList(T entity);

}
