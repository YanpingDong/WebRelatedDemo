package models;

public class Asset {
	private String medium;

	private String thumbnail;

	private String full;

	private String[] asset_types;

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getMedium() {
		return this.medium;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getThumbnail() {
		return this.thumbnail;
	}

	public void setFull(String full) {
		this.full = full;
	}

	public String getFull() {
		return this.full;
	}

	public void setAsset_types(String[] asset_types) {
		this.asset_types = asset_types;
	}

	public String[] getAsset_types() {
		return this.asset_types;
	}

}