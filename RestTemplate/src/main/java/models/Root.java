package models;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Root {

	private int facilityCount;

	private List<Pacilities> facilities;

	public List<Pacilities> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<Pacilities> facilities) {
		this.facilities = facilities;
	}

	public void setFacilityCount(int FacilityCount) {
		this.facilityCount = FacilityCount;
	}

	public int getFacilityCount() {
		return this.facilityCount;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}