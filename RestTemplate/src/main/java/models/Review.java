package models;

public class Review {
	private int stars;

	private String review;

	private String name;

	private String review_date;

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getStars() {
		return this.stars;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReview() {
		return this.review;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}

	public String getReview_date() {
		return this.review_date;
	}

}