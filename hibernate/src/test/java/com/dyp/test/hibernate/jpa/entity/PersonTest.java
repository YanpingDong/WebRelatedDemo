package com.dyp.test.hibernate.jpa.entity;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class PersonTest {

	/**
	 * If use spring framwork the following code don't need to write again
	 * <code> EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPA");
	 * 	      EntityManager em = factory.createEntityManager(); </code> 
	 * the transaction control operation will be inject by AOP, so the following code 
	 * don't need to write
	 * <code> em.getTransaction().begin();
	 *        em.getTransaction().commit(); </code>
	 */
	@Test
	public void testInH2() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPA");
		EntityManager em = factory.createEntityManager();  
		
		em.getTransaction().begin();  
        Person person = new Person(); //person为new状态  
        person.setName("zhang san"); 
        person.setPass("pass_world");
        em.persist(person); //持久化实体  
        em.getTransaction().commit();  
        em.close();  
        factory.close();  
	}
	
	@Test
	public void testInMySQL()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mySQL");
		EntityManager em = factory.createEntityManager();  
		
		em.getTransaction().begin();  
        Person person = new Person(); //person为new状态  
        person.setName("zhang san7"); 
        person.setPass("pass_world7");
        em.persist(person); //持久化实体  
        em.getTransaction().commit();  
        em.close();  
        factory.close();  
	}

}
