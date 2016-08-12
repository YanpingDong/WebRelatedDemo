package org.bootapp.model;

import org.hibernate.validator.constraints.NotBlank;

public class Jsr303ValidationTestModel {
	
	@NotBlank(message="this info cann't be null")  
	private String notNullInfo;

	public String getNotNullInfo() {
		return notNullInfo;
	}

	public void setNotNullInfo(String notNullInfo) {
		this.notNullInfo = notNullInfo;
	} 
}
