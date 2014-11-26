package com.dyp.test.spring.hibernate4.entity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TableInfoDaoTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = 
				 new ClassPathXmlApplicationContext("springHibernate4DataSource.xml"); 
		TableInfoDao infoDao = ctx.getBean("tableInfoDao", TableInfoDao.class);
        TableInfo info = new TableInfo();
        info.setName("spring_name");
        infoDao.save(info);
	}

}
