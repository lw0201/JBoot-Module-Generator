package com.frame.business.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

/**
 * <li>基础业务层逻辑接口类</li>
 * 
 * @author liwen
 * @param <T>
 *            操作实体
 */
public interface IBaseService<T> {

    /**
     * <li>新增实体数据</li>
     * 
     * @param entity
     *            :实体对象
     * @return 返回实体操作所影响的行
     */
    int insert(T entity);

    /**
     * <li>批量插入实体对象操作</li>
     * 
     * @param entitys
     *            : 实体集合对象
     * @return
     */
    int inserts(Collection<T> entitys);

    /**
     * <li>根据实体ID删除实体对象</li>
     * 
     * @param id
     *            : 实体对应的ID
     * @return 返回删除实体影响的行
     */
    int deleteById(Serializable id);

    /**
     * <li>根据实体ID更新实体对象操作</li>
     * 
     * @param entity
     *            :实体对象
     * @return
     */
    int update(T entity);

    /**
     * <li>根据业务实体ID可查询返回业务实体的详细信息</li>
     * 
     * @param id
     *            :业务实体ID
     * @return 返回业务实体的详细信息
     */
    T findById(Serializable id);

    /**
     * <li>根据实体对象查询并返回单个实体对象</li>
     * 
     * @param entity
     *            :业务实体
     * @return 返回单个业务实体对象详细信息
     */
    T select(@Param("entity") T entity);

    /**
     * <li>查询业务实体集合</li>
     * 
     * @return 返回实体集合
     */
    List<T> findList();

    /**
     * <li>根据实体对象返回实体集合</li>
     * 
     * @param entity
     *            业务实体对象
     * @return 返回业务实体对象集合
     */
    List<T> findList(@Param("entity") T entity);

    /**
     * <li>实体分页操作</li>
     * 
     * @param entity
     *            :业务实体对象
     * @param pageNo
     *            :分页起始页
     * @param pageSize
     *            :分页每页显示的数据大小
     * @return 返回业务的实体的分页信息
     */
    PageInfo<T> findPage(T entity, int pageNo, int pageSize);
}
