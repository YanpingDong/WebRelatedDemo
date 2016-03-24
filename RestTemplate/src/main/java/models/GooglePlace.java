package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class GooglePlace {

	/**
	 * params introduce are here:
	 * https://developers.google.com/places/web-service/search
	 */
	private String icon;
	private Geometry geometry;
	private String name;
	private OpeningHours opening_hours;
	private List<Photo> photos;
	private String[] html_attributions[];
	private String place_id;
	private String scope;
	private List<AltPlace> alt_ids;
	private int price_level;
	private double rating;
	private String[] types;
	private String vicinity;
	private String formatted_address;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OpeningHours getOpening_hours() {
		return opening_hours;
	}

	public void setOpening_hours(OpeningHours opening_hours) {
		this.opening_hours = opening_hours;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public String[][] getHtml_attributions() {
		return html_attributions;
	}

	public void setHtml_attributions(String[][] html_attributions) {
		this.html_attributions = html_attributions;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public List<AltPlace> getAlt_ids() {
		return alt_ids;
	}

	public void setAlt_ids(List<AltPlace> alt_ids) {
		this.alt_ids = alt_ids;
	}

	public int getPrice_level() {
		return price_level;
	}

	public void setPrice_level(int price_level) {
		this.price_level = price_level;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public String getVicinity() {
		return vicinity;
	}

	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
}
