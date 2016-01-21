package models.meters;

public class RegionData extends BasedToString{
	private String abbrev;

	private String tz_name;

	private int offset;

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public String getAbbrev() {
		return this.abbrev;
	}

	public void setTz_name(String tz_name) {
		this.tz_name = tz_name;
	}

	public String getTz_name() {
		return this.tz_name;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getOffset() {
		return this.offset;
	}

}
