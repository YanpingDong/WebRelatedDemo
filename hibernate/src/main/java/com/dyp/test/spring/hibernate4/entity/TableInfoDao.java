package com.dyp.test.spring.hibernate4.entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value="tableInfoDao")
public class TableInfoDao {
	/**
	 * SessionFactory
	 */
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
	@Transactional 
	public void save(TableInfo tableInfo)
	{
		getSessionFactory().getCurrentSession().saveOrUpdate(tableInfo);
		getSessionFactory().getCurrentSession().clear();
	}
}
