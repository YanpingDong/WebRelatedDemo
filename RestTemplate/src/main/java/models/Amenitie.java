package models;

public class Amenitie {
	private int id;

	private boolean value;

	private String name;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}