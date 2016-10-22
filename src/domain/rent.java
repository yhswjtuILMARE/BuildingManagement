package domain;

public class rent {
	
	private String rent_id;
	private String building_address;
	private String rentperson_name;
	private String rentperson_phone;
	private double building_cash;
	
	
	public String getRent_id() {
		return rent_id;
	}
	public void setRent_id(String rent_id) {
		this.rent_id = rent_id;
	}
	public String getBuilding_address() {
		return building_address;
	}
	public void setBuilding_address(String building_address) {
		this.building_address = building_address;
	}
	public String getRentperson_name() {
		return rentperson_name;
	}
	public void setRentperson_name(String rentperson_name) {
		this.rentperson_name = rentperson_name;
	}
	public String getRentperson_phone() {
		return rentperson_phone;
	}
	public void setRentperson_phone(String rentperson_phone) {
		this.rentperson_phone = rentperson_phone;
	}
	public double getBuilding_cash() {
		return building_cash;
	}
	public void setBuilding_cash(double building_cash) {
		this.building_cash = building_cash;
	}
}
