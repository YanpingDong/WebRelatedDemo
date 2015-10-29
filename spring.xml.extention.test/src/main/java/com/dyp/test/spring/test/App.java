package com.dyp.test.spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    public static void main( String[] args )
    {
    	DataSourceInfo d = (DataSourceInfo) context.getBean("myDataSourcce");
        System.out.println(d);
    }
}
