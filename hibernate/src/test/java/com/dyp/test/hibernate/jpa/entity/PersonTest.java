package com.dyp.test.hibernate.jpa.entity;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test() {
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

}
