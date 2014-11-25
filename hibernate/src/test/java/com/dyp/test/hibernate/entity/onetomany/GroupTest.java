package com.dyp.test.hibernate.entity.onetomany;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class GroupTest {
	
	@Test
	public void test() {
		Configuration config = new Configuration(); 
		config.configure("userHibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();  
        Session session = factory.openSession();  
        Transaction tran = session.beginTransaction();  
        Group group = new Group();  
        group.setName("animal");  
        Single user = new Single();  
        user.setName("little dog");  
        user.setGroup(group);  
        Single user1 = new Single();  
        user1.setName("little cat");  
        user1.setGroup(group);  
        
        group.getSingles().add(user);  
        group.getSingles().add(user1);  
        
        session.save(group);  
        session.save(user);  
        session.save(user1);  

        tran.commit();
        session.close(); 
	}

}
