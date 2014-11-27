package com.dyp.test.spring.nosql.jpa.kundera;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dyp.test.hibernate.entity.onetomany.Group;
import com.dyp.test.hibernate.entity.onetomany.Single;
import com.dyp.test.spring.nosql.jpa.kundera.entity.CassandraInfo;
import com.dyp.test.spring.nosql.jpa.kundera.entity.CassandraInfoDao;
/**
 * before runing, use the following command to create table in Cassandra DB
 * <code>CREATE TABLE pbosite.cassandra_info(id int,  name text,PRIMARY KEY(id))WITH COMPACT STORAGE;</code>
 * for the detail : https://github.com/impetus-opensource/Kundera
 */
public class CassandraInfoDaoTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = 
				 new ClassPathXmlApplicationContext("springKundera2CassandraJPA.xml"); 
		CassandraInfoDao infoDao = ctx.getBean("cassandraInfoDao", CassandraInfoDao.class);
		CassandraInfo info = new CassandraInfo();
		info.setId(5); 
        info.setName("spring_name_wehere");
        infoDao.save(info);
        infoDao.get();
        
        Group group = new Group();  
        group.setName("animal"); 
        group.setId(1);
        Single user = new Single();  
        user.setName("little dog"); 
        user.setId(1);
        user.setGroup(group);  
        Single user1 = new Single();  
        user1.setName("little cat");  
        user1.setId(2);
        user1.setGroup(group);  
        
        group.getSingles().add(user);  
        group.getSingles().add(user1);  
        
        infoDao.saveG(group);
        infoDao.saveS(user1);
        infoDao.saveS(user);
        
	}

}
