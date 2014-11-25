package com.dyp.test.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class User {
	
	@Id  
    @GeneratedValue  
    @Column(name="id")  
    private int id;  
	
	@Column(unique=true,nullable=false)  
    private String name;  
	
	@Column(nullable=false) 
	private String pass;
	
	private int age;
	
	/*
	 *  @Temporal主要是用来指明java.util.Date 或 java.util.Calendar 
	 *  类型的属性具体与数据库（date,time,timestamp）三个类型中的那一个进行映射
	 */
	@Temporal(value=TemporalType.DATE)
	private Date registerTime;

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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
	@Override
	public String toString()
	{
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
