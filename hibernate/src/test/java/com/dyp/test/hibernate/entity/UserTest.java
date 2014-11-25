package com.dyp.test.hibernate.entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		Configuration config = new Configuration(); 
		config.configure("userHibernate.cfg.xml");
		/*config.configure("dataSourceHibernate.cfg.xml");	*/
		SessionFactory factory = config.buildSessionFactory();  
        Session session = factory.openSession();  
        Transaction tran = session.beginTransaction();  
        User user = new User();
        user.setAge(20);
        user.setName("test");
        user.setPass("123456");
        user.setRegisterTime(new Date(2014, 11, 15));
        session.save(user);  
        //session.persist(user);  
        tran.commit();  
        User userInfo = (User) session.get(User.class, 1);
        System.out.println(userInfo.toString());
        session.close();   
	}

}
