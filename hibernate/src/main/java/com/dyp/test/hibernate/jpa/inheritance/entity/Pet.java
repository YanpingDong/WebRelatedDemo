package com.dyp.test.hibernate.jpa.inheritance.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "animal_type", discriminatorType = DiscriminatorType.STRING)
public class Pet implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;

	 private String name;

	 private double weight;

	 public Pet() {
	 }

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
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

	 public double getWeight() {
	  return weight;
	 }

	 public void setWeight(double weight) {
	  this.weight = weight;
	 }
}
