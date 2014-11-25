package com.dyp.test.hibernate.entity.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity  
public class Employee {
	@Id  
	@GeneratedValue 
	private int id;  
	
	private String name;  
	/*
	 * 这个注解表示是多对多关系的一边，mappedBy 属性定义了Emplyee为双向关系的维护端 
	 * Note：需要注意的是,有且只有一个实体的@ManyToMany注解需要指定mappedBy属性,指向targetEntity的集合属性名称 
	 */
	@ManyToMany( fetch = FetchType.LAZY, targetEntity=Role.class, mappedBy="employeeSet") 
	private Set<Role> roleSet = new HashSet<Role>();//角色集合 
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
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
}
