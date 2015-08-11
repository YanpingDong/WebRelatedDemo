package com.dyp.test.hibernate.c3p0.entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.dyp.test.hibernate.entity.User;

public class DataSourceTest {

	@Test
	public void test() {
		Configuration config = new Configuration(); 
		config.configure("dataSourceHibernate.cfg.xml");	
		SessionFactory factory = config.buildSessionFactory();  
        Session session = factory.openSession();  
        Transaction tran = session.beginTransaction();  
        DataSource dataSource = new DataSource();
        dataSource.setName("data_source_name");
        session.save(dataSource);  
        //session.persist(user);  
        tran.commit();  
        DataSource dataSourceInfo = (DataSource) session.get(DataSource.class, 1);
        System.out.println(dataSourceInfo.toString());
        session.close();   
	}
	
	@Test
	public void testDruid() {
		Configuration configuration = new Configuration(); 
		configuration.configure("DruidDatasourceHibernate.cfg.xml"); 
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry); 
        Session session = factory.openSession();  
        Transaction tran = session.beginTransaction();  
        DataSource dataSource = new DataSource();
        dataSource.setName("data_source_name113");
        session.save(dataSource);  
        tran.commit();  
        DataSource dataSourceInfo = (DataSource) session.get(DataSource.class, 1);
        System.out.println(dataSourceInfo.toString());
        session.close();   
	}

}
