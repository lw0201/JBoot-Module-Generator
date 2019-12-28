package org.jboot.generator.base;

import java.io.Serializable;
import java.util.List;

import org.jboot.generator.conditions.Wrapper;

import com.github.pagehelper.PageInfo;

/**
 * 基础业务层逻辑接口类</li>
 * 
 * @author liwen
 * @param <T>
 *            操作实体
 */
public interface IBaseService<T> {

    /**
     * 新增实体数据
     * 
     * @param entity
     *            实体对象
     * @return 返回实体操作所影响的行
     */
    int insert(T entity);

    /**
     * 批量插入实体对象操作</li>
     * 
     * @param entitys
     *            实体集合对象
     * @return
     */
    int inserts(List<T> entitys);

    /**
     * 根据实体ID删除实体对象</li>
     * 
     * @param id
     *            实体对应的ID
     * @return 返回删除实体影响的行
     */
    int deleteById(Serializable id);

    /**
     * 根据实体删除实体对象</li>
     * 
     * @param entity
     *            实体
     * @return int 返回删除实体影响的行
     */
    int delete(T entity);

    /**
     * 批量删除
     * 
     * @param entitys
     *            操作业务实体
     * @return 返回删除实体影响的行
     */
    int deletes(List<T> entitys);

    /**
     * 根据实体ID更新实体对象操作</li>
     * 
     * @param entity
     *            实体对象
     * @return
     */
    int update(T entity);

    /**
     * 根据业务实体ID可查询返回业务实体的详细信息</li>
     * 
     * @param id
     *            业务实体ID
     * @param columns
     *            自定义查询属性字段
     * @return 返回业务实体的详细信息
     */
    T findById(Serializable id, String... columns);

    /**
     * 根据实体对象查询并返回单个实体对象</li>
     * 
     * @param entity
     *            业务实体
     * @param columns
     *            自定义查询属性字段
     * @return 返回单个业务实体对象详细信息
     */
    T query(T entity, String... columns);

    /**
     * 根据实体对象查询并返回单个实体对象
     * 
     * @param entity
     *            业务实体
     * @param columns
     *            自定义查询属性字段
     * @return 返回单个业务实体对象详细信息
     */
    T query(Wrapper<T> wrapper, String... columns);

    /**
     * 根据实体对象返回实体集合</li>
     * 
     * @param entity
     *            业务实体对象
     * @param columns
     *            自定义查询属性字段
     * @return 返回业务实体对象集合
     */
    List<T> findList(T entity, String... columns);

    /**
     * 实体分页操作</li>
     * 
     * @param entity
     *            业务实体对象
     * @param pageNo
     *            分页起始页
     * @param pageSize
     *            分页每页显示的数据大小
     * @param columns
     *            自定义查询属性字段
     * @return 返回业务的实体的分页信息
     */
    PageInfo<T> findPage(Wrapper<T> wrapper, int pageNo, int pageSize, String... columns);

    /**
     * 根据构造器来查询数据
     * 
     * @param wrapper
     *            条件构造器
     * @param columns
     *            自定义查询属性字段
     * @return 返回业务实体对象集合
     */
    List<T> findByWrapper(Wrapper<T> wrapper, String... columns);

    /**
     * 根据构造器来修改对象
     * 
     * @param entity
     *            实体对象
     * @param wrapper
     *            条件构造器
     * @return 返回更新实体影响的行
     */
    int delete(Wrapper<T> wrapper);

    /**
     * 根据构造器来修改对象
     * 
     * @param entity
     *            实体对象
     * @param wrapper
     *            构造器
     * @return 返回更新实体影响的行
     */
    int update(T entity, Wrapper<T> wrapper);

}
