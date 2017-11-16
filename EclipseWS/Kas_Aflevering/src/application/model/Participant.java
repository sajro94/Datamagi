package application.model;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.*;

public class Participant {

	private String name;
	private String address;
	private String city;
	private String country;
	private LocalDate arrival;
	private String firm;
	private boolean lecturer;
	private String phone;
	private LocalDate departure;
	private String firmPhone;

	public Participant(String name, String address, String city, String country, LocalDate arrival, String firm,
			boolean lecturer, String phone, LocalDate departure, String firmPhone) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.arrival = arrival;
		this.firm = firm;
		this.lecturer = lecturer;
		this.phone = phone;
		this.departure = departure;
		this.firmPhone = firmPhone;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getArrival() {
		return arrival;
	}

	public void setArrival(LocalDate arrival) {
		this.arrival = arrival;
	}

	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
	}

	public boolean isLecturer() {
		return lecturer;
	}

	public void setLecturer(boolean lecturer) {
		this.lecturer = lecturer;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDate departure) {
		this.departure = departure;
	}

	public String getFirmPhone() {
		return firmPhone;
	}

	public void setFirmPhone(String firmPhone) {
		this.firmPhone = firmPhone;
	}

	public int getParticipationDays() {
		return (int) DAYS.between(arrival, departure) + 1;
	}

}
