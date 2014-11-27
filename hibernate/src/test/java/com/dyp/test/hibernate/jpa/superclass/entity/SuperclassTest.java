package com.dyp.test.hibernate.jpa.superclass.entity;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.dyp.test.hibernate.jpa.entity.Person;

/**
 * If use spring framwork the following code don't need to write again
 * <code> EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPA");
 * 	      EntityManager em = factory.createEntityManager(); </code> 
 * the transaction control operation will be inject by AOP, so the following code 
 * don't need to write
 * <code> em.getTransaction().begin();
 *        em.getTransaction().commit(); </code>
 */
public class SuperclassTest {

	@Test
	public void test() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPA");
		EntityManager em = factory.createEntityManager();  
		em.getTransaction().begin();  
		SubEntity subEntity = new SubEntity(); //person为new状态  
		subEntity.setName("subName"); 
        subEntity.setInfo("subInfo");
        em.persist(subEntity); //持久化实体  
        em.getTransaction().commit();  
        em.close();  
        factory.close();  
	}

}
