package classes;

import java.util.ArrayList;

public class Car {
	private String license;
	private double pricePerDay;
	private int purchaseYear;
	private ArrayList<Rental> rentals = new ArrayList<>();

	public Car(String license, int purchaseYear) {
		setLicense(license);
		setPurchaseYear(purchaseYear);
	}

	public String getLicense() {
		return license;
	}

	private void setLicense(String license) {
		this.license = license;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getPurchaseYear() {
		return purchaseYear;
	}

	private void setPurchaseYear(int purchaseYear) {
		this.purchaseYear = purchaseYear;
	}

	void addRental(Rental rental) {
		rentals.add(rental);
	}

	void removeRental(Rental rental) {
		rentals.remove(rental);
	}

	public ArrayList<Rental> getRentals() {
		return new ArrayList<>(rentals);
	}

	public int longestRental() {
		int maxDays = rentals.get(0).getDays();
		for (int i = 1; i < rentals.size(); i++) {
			maxDays = rentals.get(i).getDays() > maxDays ? rentals.get(i).getDays() : maxDays;
		}
		return maxDays;
	}

}
