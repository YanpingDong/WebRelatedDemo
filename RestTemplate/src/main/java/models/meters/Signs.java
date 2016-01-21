package models.meters;


public class Signs extends BasedToString{
	private Float[] point;

	private String description;

	private String image;

	public void setPoint(Float[] point) {
		this.point = point;
	}

	public Float[] getPoint() {
		return this.point;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return this.image;
	}

}