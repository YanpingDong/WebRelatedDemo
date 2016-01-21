package com.dyp.test.hibernate.entity.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/*
 * For cassandra:
 * CREATE TABLE pbosite.many_single(id int,  name text, self_define_groupid text,PRIMARY KEY(id))WITH COMPACT STORAGE;
 */
@Entity  
@Table(name = "many_single") 
public class Single {
	 @Id  
	 @GeneratedValue 
	 private int id;  
	 private String name; 
	
	 /*
	  * targetEntity:表示该属性关联的实体类型.该属性通常不必指定,ORM框架根据属性类型自动判断targetEntity. 
	  */
	 @ManyToOne(cascade = CascadeType.ALL/*, targetEntity=com.dyp.test.hibernate.entity.onetomany.Group.class*/)
	 /*
	  * 其默认的名称为实体Group的名称+下划线+实体Group的主键名称 =group_id
	  */
	 @JoinColumn(name="self_define_groupid")
	 private Group group;  
	  
	 
	 public Group getGroup() {  
	  return group;  
	 }  
	  
	 public void setGroup(Group group) {  
	  this.group = group;  
	 }  
	  
	  
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
