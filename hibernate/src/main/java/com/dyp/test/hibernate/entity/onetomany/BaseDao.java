package com.dyp.test.hibernate.entity.onetomany;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.transform.ResultTransformer;

public class BaseDao<T> {
	private static  SessionFactory sessionFactory = null; 
	static {
		Configuration configuration = new Configuration(); 
		configuration.configure("DruidDatasourceHibernate.cfg.xml"); 
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
		sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
	}
	
	private Class<?> entityClass;
	
	public BaseDao() {
		entityClass = Reflections.getClassGenricType(getClass());
	}
	
	public Session openSession(){
		return sessionFactory.openSession();
	}
	
	/**
	 * 获取 Session
	 */
	public Session getSession(){  
	  return sessionFactory.getCurrentSession();
	}

	/**
	 * 强制与数据库同步
	 */
	public void flush(){
		getSession().flush();
	}
	
	/**
	 * 清除缓存数据
	 */
	public void clear(){ 
		getSession().clear();
	}
	
	/**
	 * 保存对象
	 */
	public void save(T entity){
		Transaction transaction = getSession().beginTransaction();
		try{
			getSession().saveOrUpdate(entity);
			transaction.commit();
		}
		catch(HibernateException e)
		{
			transaction.rollback();
		}
		
	}
	/**
	 * 按Key获取对象 
	 */
	@SuppressWarnings("unchecked")
	public T get(Serializable id){
		Session session = openSession();
		T result = (T)session.get(entityClass, id);
		session.close();
		return result;
	}
	
	/**
	 * 分页查询
	 */
	public List<T> find(int firstResult, int maxResults) {
		return find(firstResult, maxResults, createDetachedCriteria());
	}
	
	public List<T> find(int firstResult, int maxResults, DetachedCriteria detachedCriteria) {
		return find(firstResult, maxResults, detachedCriteria, Criteria.DISTINCT_ROOT_ENTITY);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(int firstResult, int maxResults, DetachedCriteria detachedCriteria, ResultTransformer resultTransformer) {

		Session session = openSession();
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		criteria.setResultTransformer(resultTransformer);
	
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults); 
        List<T> results = criteria.list();
        session.close();
		return results;
	}
	
	/**
	 * 创建与会话无关的检索标准对象
	 * @param criterions Restrictions.eq("name", value);
	 * @return 
	 */
	public DetachedCriteria createDetachedCriteria(Criterion... criterions) {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		for (Criterion c : criterions) {
			dc.add(c);
		}
		return dc;
	}
}
