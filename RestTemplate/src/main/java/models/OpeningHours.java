package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class OpeningHours {
	private boolean open_now;

	public boolean isOpen_now() {
		return open_now;
	}

	public void setOpen_now(boolean open_now) {
		this.open_now = open_now;
	}
}
