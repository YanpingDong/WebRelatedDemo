package com.dyp.test.hibernate.jpa.inheritance.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("dog")
public class Dog extends Pet {
	private static final long serialVersionUID = 1111198642878094081L;
    private String trick;

	 public String getTrick() {
	  return trick;
	 }
	
	 public void setTrick(String trick) {
	  this.trick = trick;
	 }

}
