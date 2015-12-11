package models;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LotInfo {
	private Integer f_id;

	private String name;

	private String address;

	private String building_address;

	private Integer distance;

	private Double[] point ;

	private String url;

	private String format;

	private String type;

	private String operator;

	private List<Phone> phones ;

	private String[] hrs ;

	private String[] pmt_types ;

	private Integer cost_index;

	private List<Map<String,String>> rates ;

	private String currency;

	private String currency_iso;

	private Integer spaces_total;

	private Integer occupancy_pct;

	private List<Occupancy> occupancy ;

	private String[] ppoly_arr ;

	private List<Peps> peps ;

	private String[] asset_thumbs ;

	private List<Asset> assets ;

	private List<Amenitie> lot_amenities ;

	private List<Reservation> reservations ;

	private Integer review_count;

	private Integer review_score;

	private List<Review> reviews ;

	private String t_qp;

	private String note;

	private Integer ts;
	
	private CalculatedRates calculatedRates;

	public Integer getF_id() {
		return f_id;
	}

	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBuilding_address() {
		return building_address;
	}

	public void setBuilding_address(String building_address) {
		this.building_address = building_address;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Double[] getPoint() {
		return point;
	}

	public void setPoint(Double[] point) {
		this.point = point;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String[] getHrs() {
		return hrs;
	}

	public void setHrs(String[] hrs) {
		this.hrs = hrs;
	}

	public String[] getPmt_types() {
		return pmt_types;
	}

	public void setPmt_types(String[] pmt_types) {
		this.pmt_types = pmt_types;
	}

	public Integer getCost_index() {
		return cost_index;
	}

	public void setCost_index(Integer cost_index) {
		this.cost_index = cost_index;
	}

	public List<Map<String, String>> getRates() {
		return rates;
	}

	public void setRates(List<Map<String, String>> rates) {
		this.rates = rates;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrency_iso() {
		return currency_iso;
	}

	public void setCurrency_iso(String currency_iso) {
		this.currency_iso = currency_iso;
	}

	public Integer getSpaces_total() {
		return spaces_total;
	}

	public void setSpaces_total(Integer spaces_total) {
		this.spaces_total = spaces_total;
	}

	public Integer getOccupancy_pct() {
		return occupancy_pct;
	}

	public void setOccupancy_pct(Integer occupancy_pct) {
		this.occupancy_pct = occupancy_pct;
	}

	public List<Occupancy> getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(List<Occupancy> occupancy) {
		this.occupancy = occupancy;
	}

	public String[] getPpoly_arr() {
		return ppoly_arr;
	}

	public void setPpoly_arr(String[] ppoly_arr) {
		this.ppoly_arr = ppoly_arr;
	}

	public List<Peps> getPeps() {
		return peps;
	}

	public void setPeps(List<Peps> peps) {
		this.peps = peps;
	}

	public String[] getAsset_thumbs() {
		return asset_thumbs;
	}

	public void setAsset_thumbs(String[] asset_thumbs) {
		this.asset_thumbs = asset_thumbs;
	}

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	public List<Amenitie> getLot_amenities() {
		return lot_amenities;
	}

	public void setLot_amenities(List<Amenitie> lot_amenities) {
		this.lot_amenities = lot_amenities;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Integer getReview_count() {
		return review_count;
	}

	public void setReview_count(Integer review_count) {
		this.review_count = review_count;
	}

	public Integer getReview_score() {
		return review_score;
	}

	public void setReview_score(Integer review_score) {
		this.review_score = review_score;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getT_qp() {
		return t_qp;
	}

	public void setT_qp(String t_qp) {
		this.t_qp = t_qp;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getTs() {
		return ts;
	}

	public void setTs(Integer ts) {
		this.ts = ts;
	}

	public CalculatedRates getCalculatedRates() {
		return calculatedRates;
	}

	public void setCalculatedRates(CalculatedRates calculatedRates) {
		this.calculatedRates = calculatedRates;
	}

	@Override
	public String toString()
	{
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}