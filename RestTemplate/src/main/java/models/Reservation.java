package models;

public class Reservation {
	private String first_name;

	private String last_name;

	private String pk_reservation;

	private String pk_lot;

	private String lot_address;

	private String lot_name;

	private String str_reservation_code;

	private String dt_start_time;

	private String dt_end_time;

	private String dt_expiration_date;

	private int pk_reservation_status;

	private String str_reservation_url;

	private double d_amount_quoted;

	private double d_amount_paid;

	private double d_amount_discounted;

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getFirst_name() {
		return this.first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLast_name() {
		return this.last_name;
	}

	public void setPk_reservation(String pk_reservation) {
		this.pk_reservation = pk_reservation;
	}

	public String getPk_reservation() {
		return this.pk_reservation;
	}

	public void setPk_lot(String pk_lot) {
		this.pk_lot = pk_lot;
	}

	public String getPk_lot() {
		return this.pk_lot;
	}

	public void setLot_address(String lot_address) {
		this.lot_address = lot_address;
	}

	public String getLot_address() {
		return this.lot_address;
	}

	public void setLot_name(String lot_name) {
		this.lot_name = lot_name;
	}

	public String getLot_name() {
		return this.lot_name;
	}

	public void setStr_reservation_code(String str_reservation_code) {
		this.str_reservation_code = str_reservation_code;
	}

	public String getStr_reservation_code() {
		return this.str_reservation_code;
	}

	public void setDt_start_time(String dt_start_time) {
		this.dt_start_time = dt_start_time;
	}

	public String getDt_start_time() {
		return this.dt_start_time;
	}

	public void setDt_end_time(String dt_end_time) {
		this.dt_end_time = dt_end_time;
	}

	public String getDt_end_time() {
		return this.dt_end_time;
	}

	public void setDt_expiration_date(String dt_expiration_date) {
		this.dt_expiration_date = dt_expiration_date;
	}

	public String getDt_expiration_date() {
		return this.dt_expiration_date;
	}

	public void setPk_reservation_status(int pk_reservation_status) {
		this.pk_reservation_status = pk_reservation_status;
	}

	public int getPk_reservation_status() {
		return this.pk_reservation_status;
	}

	public void setStr_reservation_url(String str_reservation_url) {
		this.str_reservation_url = str_reservation_url;
	}

	public String getStr_reservation_url() {
		return this.str_reservation_url;
	}

	public void setD_amount_quoted(double d_amount_quoted) {
		this.d_amount_quoted = d_amount_quoted;
	}

	public double getD_amount_quoted() {
		return this.d_amount_quoted;
	}

	public void setD_amount_paid(double d_amount_paid) {
		this.d_amount_paid = d_amount_paid;
	}

	public double getD_amount_paid() {
		return this.d_amount_paid;
	}

	public void setD_amount_discounted(double d_amount_discounted) {
		this.d_amount_discounted = d_amount_discounted;
	}

	public double getD_amount_discounted() {
		return this.d_amount_discounted;
	}

}