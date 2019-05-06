package com.frame.business.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IBaseDao<T> {

	int insert(T entity);

	int inserts(Collection<T> entity);

	int deleteById(Serializable id);

	int update(T entity);

	T findById(Serializable id);

	T select(@Param("entity") T entity);

	List<T> findList();

	List<T> findList(@Param("entity") T entity);

}
