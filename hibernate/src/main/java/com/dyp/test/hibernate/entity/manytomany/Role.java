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
public class Role {
	@Id  
	@GeneratedValue 
	private int id;  
	
	private String name;  
	
	@ManyToMany( fetch = FetchType.LAZY, targetEntity=Employee.class)
	/*
	 * @JoinTable 描述了多对多关系的数据表关系，name属性指定中间表名称。 
     * joinColumns 定义中间表与对方 表的外键关系，中间表emplye_rolet的employee_id 列是employee 表的主键列对应的外键列。 
     * inverseJoinColumns 属性定义了中间表与Role的外键关系。 
	 */
	@JoinTable(name = "emplye_role",
	           joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
	           inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName ="id")})
	private Set<Employee> employeeSet = new HashSet<Employee>();//演员 
	 
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
	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}
}
