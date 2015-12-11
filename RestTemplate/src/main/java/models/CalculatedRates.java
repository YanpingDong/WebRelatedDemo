package models;

public class CalculatedRates {
	private String quoted_duration;
	private int rate_cost;
	private String rate_type;

	public String getQuoted_duration() {
		return quoted_duration;
	}

	public void setQuoted_duration(String quoted_duration) {
		this.quoted_duration = quoted_duration;
	}

	public int getRate_cost() {
		return rate_cost;
	}

	public void setRate_cost(int rate_cost) {
		this.rate_cost = rate_cost;
	}

	public String getRate_type() {
		return rate_type;
	}

	public void setRate_type(String rate_type) {
		this.rate_type = rate_type;
	}
}
