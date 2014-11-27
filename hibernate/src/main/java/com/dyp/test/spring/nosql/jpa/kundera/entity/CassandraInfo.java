package com.dyp.test.spring.nosql.jpa.kundera.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * before runing, use the following command to create table in Cassandra DB
 * <code>CREATE TABLE pbosite.cassandra_info(id int,  name text,PRIMARY KEY(id))WITH COMPACT STORAGE;</code>
 * 
 */
@Entity 
@Table(name = "cassandra_info") 
public class CassandraInfo {
	
	@Id
    @Column(name="id")
	@GeneratedValue//no effect if don't manual set will be faced with data transform error
    private int id;  
	
	@Column(unique=true,nullable=false)  
    private String name;  

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString()
	{
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
