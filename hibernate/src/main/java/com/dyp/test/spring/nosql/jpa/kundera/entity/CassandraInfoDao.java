package com.dyp.test.spring.nosql.jpa.kundera.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value="cassandraInfoDao")
public class CassandraInfoDao {
	/*
	 * spring help to create.
	 * help us save operation, Don't need to write the following codes
	 * <code> EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPA");</code>
	 * <code> EntityManager em = factory.createEntityManager();  <code>
	 */
	@PersistenceContext(unitName="myCassandra", type=PersistenceContextType.EXTENDED)
	private EntityManager em; 
	
	 /*
	    * Spring will inject transaction by AOP
	    */
	   @Transactional 
	   public void save(CassandraInfo cassandraInfo)
	   {
		   em.persist(cassandraInfo);
	   }
	   
	   @SuppressWarnings("unchecked")
	   public void get()
	   {
		   CassandraInfo temInfo = em.find(CassandraInfo.class, 1);
		   System.out.println(temInfo);
		   /*
		    * sql command is limited by cassandra database feature.
		    * such as, Don't use equal on element that don't have index
		    */
		   Query query= em.createQuery("select c from CassandraInfo c where c.id=:id");
		   query.setParameter("id", 5);
		   List<CassandraInfo> result = query.getResultList();
		   for(CassandraInfo info : result)
			   System.out.println(info);
	   }
}
