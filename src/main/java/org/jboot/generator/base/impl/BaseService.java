package org.jboot.generator.base.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.jboot.generator.base.IBaseDao;
import org.jboot.generator.base.IBaseService;
import org.jboot.generator.conditions.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 基础服务业务实现层逻辑类
 * 
 * @author liwen
 *
 * @param <T>
 *            业务实体对象
 */
public class BaseService<T> implements IBaseService<T> {

    @Autowired
    IBaseDao<T> iBaseDao;

    @Override
    public int insert(T entity) {
        return iBaseDao.insert(entity);
    }

    @Override
    public int inserts(List<T> entitys) {
        int result = 0;
        while (CollectionUtils.isNotEmpty(entitys) && entitys.size() > 100) {
            int count = iBaseDao.inserts(entitys.subList(0, 100));
            result = result + count;
            entitys.subList(0, 100).clear();
        }
        if (CollectionUtils.isNotEmpty(entitys)) {
            int count = iBaseDao.inserts(entitys);
            result = result + count;
        }
        return result;
    }

    @Override
    public int deleteById(Serializable id) {
        return iBaseDao.deleteById(id);
    }

    @Override
    public int deletes(List<T> entitys) {
        int result = 0;
        while (CollectionUtils.isNotEmpty(entitys) && entitys.size() > 100) {
            int count = iBaseDao.deletes(entitys.subList(0, 100));
            result = result + count;
            entitys.subList(0, 100).clear();
        }
        if (CollectionUtils.isNotEmpty(entitys)) {
            int count = iBaseDao.deletes(entitys);
            result = result + count;
        }
        return result;
    }

    @Override
    public int update(T entity) {
        return iBaseDao.update(entity);
    }

    @Override
    public T findById(Serializable id) {
        return iBaseDao.findById(id);
    }

    @Override
    public T select(T entity) {
        return iBaseDao.select(entity);
    }

    @Override
    public T select(Wrapper<T> wrapper) {
        return iBaseDao.select(wrapper);
    }

    @Override
    public List<T> findList() {
        return iBaseDao.findList();
    }

    @Override
    public List<T> findList(T entity) {
        return iBaseDao.findList(entity);
    }

    @Override
    public PageInfo<T> findPage(T entity, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<T>(iBaseDao.findList(entity));
    }

    @Override
    public List<T> findList(Wrapper<T> wrapper) {
        return iBaseDao.findList(wrapper);
    }

    @Override
    public int delete(Wrapper<T> wrapper) {
        return iBaseDao.delete(wrapper);
    }

    @Override
    public int update(T entity, Wrapper<T> wrapper) {
        return iBaseDao.update(entity, wrapper);
    }

}
