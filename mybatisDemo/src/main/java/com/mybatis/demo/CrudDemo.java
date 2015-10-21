package com.mybatis.demo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.client.UserMapper;
import com.mybatis.entity.User;

public class CrudDemo {
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
    	User user = null;
    	try {
    		UserMapper userMapper = session.getMapper(UserMapper.class);
    		user=userMapper.selectByPrimaryKey("1");
    	} finally {
    	  session.close();
    	}
    	System.out.println("查询单个信息：id="+user.getId()+"， 姓名="+user.getName());
    	
    	session=sqlSessionFactory.openSession();
    	try {
    		UserMapper userMapper = session.getMapper(UserMapper.class);
    		userMapper.deleteByPrimaryKey("3");
      	} finally {
      	  session.commit();
      	  session.close();
      	}
    	System.out.println("删除文件成功：id=3");
	}
}
