package com.mybatis.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.client.UserMapper;
import com.mybatis.entity.User;
import com.mybatis.entity.UserExample;
import com.mybatis.entity.UserExample.Criteria;

public class ExampleDemo {
	public static void main(String[] args) {
		String resource = "com/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		List<User> users = null;
		try {
			UserMapper audioInfoMapper = session.getMapper(UserMapper.class);
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andOffice_idLike("%1%");
			//TODO Criteria的使用存在问题,如果上面的是addAccessNum的话,不会自动转成下划线形式access_num
			example.setOrderByClause("id");
			example.setDistinct(true);
			users = audioInfoMapper.selectByExample(example);
		} finally {
			session.close();
		}
		for (User user : users) {
			System.out.println(user.getId() + "--" + user.getName());
		}
	}
}
