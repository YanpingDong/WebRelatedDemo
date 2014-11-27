package com.dyp.test.hibernate.entity.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
/*
 * For cassandra:
 * CREATE TABLE pbosite.one_group(id int,  name text,PRIMARY KEY(id))WITH COMPACT STORAGE;
 */
@Entity  
@Table(name = "one_group") 
public class Group {
	 
	 @Id  
	 @GeneratedValue  
 	 private int id;  
	 private String name;  
	 
	 @OneToMany(mappedBy = "group", cascade = { CascadeType.ALL }/*, targetEntity=Single.class*/)  
	 @OrderBy("name ASC") 
	 private List<Single> singles = new ArrayList<Single>();  
	  
	 
	 public List<Single> getSingles() {
		return singles;
	}

	public void setSingles(List<Single> singles) {
		this.singles = singles;
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
	 
}
