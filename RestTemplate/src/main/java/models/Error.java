package models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Error {

	private String errorDescription;

	private int errorCode;

	public void setErrorDescription(String ErrorDescription) {
		this.errorDescription = ErrorDescription;
	}

	public String getErrorDescription() {
		return this.errorDescription;
	}

	public void setErrorCode(int ErrorCode) {
		this.errorCode = ErrorCode;
	}

	public int getErrorCode() {
		return this.errorCode;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
