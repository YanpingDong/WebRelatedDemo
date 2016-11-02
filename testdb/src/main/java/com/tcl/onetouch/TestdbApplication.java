package com.tcl.onetouch;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class TestdbApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TestdbApplication.class, args);
		DataSource datasource = ctx.getBean(DataSource.class);
        if (datasource instanceof HikariDataSource) {
        	System.out.println(datasource);
        	HikariDataSource ds = (HikariDataSource)datasource;
        	System.out.println("Using com.zaxxer.hikari.HikariDataSource, getMaximumPoolSize = "+ds.getMaximumPoolSize());
        }
        if (datasource instanceof BasicDataSource) {
        	System.out.println(datasource);
        	BasicDataSource ds = (BasicDataSource)datasource;
        	System.out.println("Using org.apache.commons.dbcp2.BasicDataSource, getMaxTotal = "+ds.getMaxTotal());
        }
        if (datasource instanceof org.apache.tomcat.jdbc.pool.DataSource) {
        	System.out.println(datasource);
        	org.apache.tomcat.jdbc.pool.DataSource ds = (org.apache.tomcat.jdbc.pool.DataSource)datasource;
        	System.out.println("Using org.apache.tomcat.jdbc.pool.DataSourcem, getMaxActive = "+ds.getMaxActive());
        }
	}
}
