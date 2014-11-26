package com.dyp.test.spring.hibernate.jpa.datasource.entity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dyp.test.spring.hibernate.jpa.entity.SpringInfo;
import com.dyp.test.spring.hibernate.jpa.entity.SpringInfoDao;
/**
 * There are two way to set datasource
 * 1. set datasource configuration in persistence.xml 
 * 2. set datasource configuration in springJPADataSource.xml, then U can commit
 *    the same config in persistence.xml such as hibernate.dialect、hibernate.connection.username
 *    and so on
 *
 */
public class SpringDataSourceInfoDaoTest {

	@Test
	public void test() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springJPADataSource.xml"); 
		SpringDataSourceInfoDao infoDao = ctx.getBean("springDataSourceInfoDao", SpringDataSourceInfoDao.class);
		SpringDataSourceInfo info = new SpringDataSourceInfo();
        info.setName("spring_data_source_name");
        infoDao.save(info);
       
	}

}
