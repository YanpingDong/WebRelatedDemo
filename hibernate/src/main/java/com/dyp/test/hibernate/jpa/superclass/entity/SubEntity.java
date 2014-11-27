package com.dyp.test.hibernate.jpa.superclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="sub_entity")
public class SubEntity extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
    
}
