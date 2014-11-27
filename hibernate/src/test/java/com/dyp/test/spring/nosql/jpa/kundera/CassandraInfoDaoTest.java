package com.dyp.test.spring.nosql.jpa.kundera;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dyp.test.spring.nosql.jpa.kundera.entity.CassandraInfo;
import com.dyp.test.spring.nosql.jpa.kundera.entity.CassandraInfoDao;
/**
 * before runing, use the following command to create table in Cassandra DB
 * <code>CREATE TABLE pbosite.cassandra_info(id int,  name text,PRIMARY KEY(id))WITH COMPACT STORAGE;</code>
 *
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
	}

}
