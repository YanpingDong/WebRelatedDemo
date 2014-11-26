package com.dyp.test.spring.hibernate.jpa.entity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dyp.test.spring.hibernate.jpa.entity.SpringInfo;
import com.dyp.test.spring.hibernate.jpa.entity.SpringInfoDao;

public class SpringInfoDaoTest {

	@Test
	public void test() {

		ClassPathXmlApplicationContext ctx = 
		 new ClassPathXmlApplicationContext("springJPAcontext.xml"); 
		SpringInfoDao infoDao = ctx.getBean("springInfoDao", SpringInfoDao.class);
        SpringInfo info = new SpringInfo();
        info.setName("spring_name");
        infoDao.save(info);
        
	}

}
