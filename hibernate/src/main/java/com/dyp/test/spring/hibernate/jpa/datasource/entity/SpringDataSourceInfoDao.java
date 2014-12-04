package com.dyp.test.spring.hibernate.jpa.datasource.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("springDataSourceInfoDao") 
public class SpringDataSourceInfoDao {

	/*
	 * spring help to create.
	 * help us save operation, Don't need to write the following codes
	 * <code> EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPA");</code>
	 * <code> EntityManager em = factory.createEntityManager();  <code>
	 */
	@PersistenceContext 
	private EntityManager em; 

   /*
    * Spring will inject transaction by AOP
    */
   @Transactional 
   public void save(SpringDataSourceInfo SpringInfo) { 
		em.persist(SpringInfo); 
   } 
}
