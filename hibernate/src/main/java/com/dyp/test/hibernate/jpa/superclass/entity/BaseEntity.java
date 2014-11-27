package com.dyp.test.hibernate.jpa.superclass.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class BaseEntity implements Serializable
{
	protected static final long serialVersionUID = 1L;
	private Integer id;// 数据库主键
	private String name;
	 
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 public Integer getId() {
	  return id;
	 }
	 public void setId(Integer id) {
	  this.id = id;
	 }
	 

}
