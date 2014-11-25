package com.dyp.test.hibernate.entity.manytomany;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class EmployeeTest {

	@Test
	public void test() {
		Configuration config = new Configuration(); 
		config.configure("userHibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();  
        Session session = factory.openSession();  
        Transaction tran = session.beginTransaction();  
        
        Employee employee = new Employee();
        employee.setName("emplyeename");
        Role role = new Role();
        role.setName("rolename");
        Set<Employee> empSet = new HashSet<Employee>();
        empSet.add(employee);
        Set<Role> roleSet = new HashSet<Role>();
        roleSet.add(role);
        employee.setRoleSet(roleSet);
        role.setEmployeeSet(empSet);
        session.save(employee);
        session.save(role);
        
        tran.commit();
        session.close(); 
	}

}
