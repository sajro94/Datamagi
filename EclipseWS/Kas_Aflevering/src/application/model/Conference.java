package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Conference {
	private String name;
	private ArrayList<Registration> registrations = new ArrayList<>();
	private String location;
	private ArrayList<Hotel> hotels = new ArrayList<>();
	private LocalDate startDate;
	private LocalDate endDate;
	private double pricePerDay;
	private ArrayList<Trip> trips = new ArrayList<>();

	public Conference(String name, String location, LocalDate startDate, LocalDate endDate, double pricePerDay) {
		this.name = name;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pricePerDay = pricePerDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	void addRegistration(Registration registration) {
		registrations.add(registration);
	}

	void removeRegistration(Registration registration) {
		registrations.remove(registration);
	}

	public void addHotel(Hotel hotel) {
		hotels.add(hotel);
	}

	public ArrayList<Hotel> getHotels() {
		return new ArrayList<>(hotels);
	}

	public void addTrip(Trip trip) {
		trips.add(trip);
	}

	public ArrayList<Trip> getTrips() {
		return new ArrayList<>(trips);
	}
}
