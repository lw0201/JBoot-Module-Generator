package com.frame.business.base.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.frame.business.base.IBaseDao;
import com.frame.business.base.IBaseService;

public class BaseService<T> implements IBaseService<T> {

	@Autowired
	IBaseDao<T> iBaseDao;

	@Override
	public int insert(T entity) {
		return iBaseDao.insert(entity);
	}

	@Override
	public int deleteById(Serializable id) {
		return iBaseDao.deleteById(id);
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
	public List<T> findList() {
		return iBaseDao.findList();
	}

	@Override
	public List<T> findList(T entity) {
		return iBaseDao.findList(entity);
	}

}
