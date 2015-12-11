package com.parkme.models;

public class ErrorObject extends BasedToString{
	private Integer errorCode;
	private String ErrorDescription;

	public ErrorObject(Integer errorCode, String errorDescription) {
		super();
		this.errorCode = errorCode;
		ErrorDescription = errorDescription;
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return ErrorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		ErrorDescription = errorDescription;
	}
}
