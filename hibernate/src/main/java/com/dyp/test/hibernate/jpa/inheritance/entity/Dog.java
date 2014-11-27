package com.dyp.test.hibernate.jpa.inheritance.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("dog")
public class Dog extends Pet {
 private String trick;

 public String getTrick() {
  return trick;
 }

 public void setTrick(String trick) {
  this.trick = trick;
 }

}
