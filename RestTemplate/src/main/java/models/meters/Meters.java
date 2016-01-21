package models.meters;

import java.util.List;

public class Meters extends BasedToString{
	private String m_id;

	private String address;

	private String operator;

	private String mfg;

	private String name;

	private String code;

	private String m_type;

	private String[] ppoint_arr;

	private String[] pline_arr;

	private String pmt_type;

	private String[] pmt_types;

	private String[] rates;

	private String[] hrs;

	private int spaces_total;

	private List<Occupancy> occupancy;

	private List<Signs> signs;

	private int ts;

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_id() {
		return this.m_id;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setMfg(String mfg) {
		this.mfg = mfg;
	}

	public String getMfg() {
		return this.mfg;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setM_type(String m_type) {
		this.m_type = m_type;
	}

	public String getM_type() {
		return this.m_type;
	}

	public void setPpoint_arr(String[] ppoint_arr) {
		this.ppoint_arr = ppoint_arr;
	}

	public String[] getPpoint_arr() {
		return this.ppoint_arr;
	}

	public void setPline_arr(String[] pline_arr) {
		this.pline_arr = pline_arr;
	}

	public String[] getPline_arr() {
		return this.pline_arr;
	}

	public void setPmt_type(String pmt_type) {
		this.pmt_type = pmt_type;
	}

	public String getPmt_type() {
		return this.pmt_type;
	}

	public void setPmt_types(String[] pmt_types) {
		this.pmt_types = pmt_types;
	}

	public String[] getPmt_types() {
		return this.pmt_types;
	}

	public void setRates(String[] rates) {
		this.rates = rates;
	}

	public String[] getRates() {
		return this.rates;
	}

	public void setHrs(String[] hrs) {
		this.hrs = hrs;
	}

	public String[] getHrs() {
		return this.hrs;
	}

	public void setSpaces_total(int spaces_total) {
		this.spaces_total = spaces_total;
	}

	public int getSpaces_total() {
		return this.spaces_total;
	}

	public void setOccupancy(List<Occupancy> occupancy) {
		this.occupancy = occupancy;
	}

	public List<Occupancy> getOccupancy() {
		return this.occupancy;
	}

	public void setSigns(List<Signs> signs) {
		this.signs = signs;
	}

	public List<Signs> getSigns() {
		return this.signs;
	}

	public void setTs(int ts) {
		this.ts = ts;
	}

	public int getTs() {
		return this.ts;
	}

}