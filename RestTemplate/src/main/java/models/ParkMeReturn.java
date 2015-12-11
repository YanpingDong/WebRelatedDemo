package models;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ParkMeReturn {
	//private Integer facilityCount;
	private List<LotInfo> facilities;
	
	/*public Integer getFacilityCount() {
		return facilityCount;
	}
	public void setFacilityCount(Integer facilityCount) {
		this.facilityCount = facilityCount;
	}*/
	public List<LotInfo> getFacilities() {
		return facilities;
	}
	public void setFacilities(List<LotInfo> facilities) {
		this.facilities = facilities;
	}
	@Override
	public String toString()
	{
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
