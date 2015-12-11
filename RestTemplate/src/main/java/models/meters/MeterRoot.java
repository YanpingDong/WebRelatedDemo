package models.meters;

import java.util.List;

public class MeterRoot extends BasedToString{
	private int MeterCount;

	private RegionData RegionData;

	private String[] Notices;

	private List<Meters> Meters;

	public void setMeterCount(int MeterCount) {
		this.MeterCount = MeterCount;
	}

	public int getMeterCount() {
		return this.MeterCount;
	}

	public void setRegionData(RegionData RegionData) {
		this.RegionData = RegionData;
	}

	public RegionData getRegionData() {
		return this.RegionData;
	}

	public void setNotices(String[] Notices) {
		this.Notices = Notices;
	}

	public String[] getNotices() {
		return this.Notices;
	}

	public void setMeters(List<Meters> Meters) {
		this.Meters = Meters;
	}

	public List<Meters> getMeters() {
		return this.Meters;
	}
	
}
