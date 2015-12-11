package models;

import java.util.List;
import java.util.Map;

public class LotInfoReturn {
	private Integer f_id;

	private String name;

	private String address;

	private String building_address;

	private Integer distance;

	private Double[] point ;

	private List<Phone> phones ;

	private String[] hrs ;


	private Integer cost_index;

    private List<Map<String,String>> rates ;

	private String currency;

	private String currency_iso;
	
	private Integer spaces_total;

	private Integer occupancy_pct;


	//private List<poly> poly ; 宸插純鐢�

	//TODO ppoly_arr鐩墠鎷垮埌鐨勬槸绌虹殑,鏃犳硶纭畾鏍煎紡

	private List<Peps> peps ;
	
	private Double[] pep_pt ;

	private Boolean reservation ;
	
	private Integer amount ;

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

	public List<Peps> getPeps() {
		return peps;
	}

	public void setPeps(List<Peps> peps) {
		this.peps = peps;
	}

	public Double[] getPep_pt() {
		return pep_pt;
	}

	public void setPep_pt(Double[] pep_pt) {
		this.pep_pt = pep_pt;
	}

	public Boolean getReservation() {
		return reservation;
	}

	public void setReservation(Boolean reservation) {
		this.reservation = reservation;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}


}