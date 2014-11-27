package com.dyp.test.hibernate.jpa.inheritance.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("cat")
public class Cat extends Pet {
	 private String HairBall;
	
	 public String getHairBall() {
	  return HairBall;
	 }
	
	 public void setHairBall(String hairBall) {
	  HairBall = hairBall;
	 }

}