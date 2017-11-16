package application.model;

import java.util.ArrayList;

public class Companion {

	private String name;
	private ArrayList<Trip> trips = new ArrayList<>();

	public Companion(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addTrip(Trip t) {
		trips.add(t);
	}

	public double getTripPrice() {
		double sum = 0.0;
		for (Trip t : trips) {
			sum += t.getPrice();
		}
		return sum;
	}

}
