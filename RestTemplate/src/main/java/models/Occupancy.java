package models;

public class Occupancy {
	private boolean occ_full;

	private int occ_index;

	private int occ_pct;

	private int occ_avail;

	private String occ_date;

	public void setOcc_full(boolean occ_full) {
		this.occ_full = occ_full;
	}

	public boolean getOcc_full() {
		return this.occ_full;
	}

	public void setOcc_index(int occ_index) {
		this.occ_index = occ_index;
	}

	public int getOcc_index() {
		return this.occ_index;
	}

	public void setOcc_pct(int occ_pct) {
		this.occ_pct = occ_pct;
	}

	public int getOcc_pct() {
		return this.occ_pct;
	}

	public void setOcc_avail(int occ_avail) {
		this.occ_avail = occ_avail;
	}

	public int getOcc_avail() {
		return this.occ_avail;
	}

	public void setOcc_date(String occ_date) {
		this.occ_date = occ_date;
	}

	public String getOcc_date() {
		return this.occ_date;
	}

}