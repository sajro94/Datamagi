package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Trip {
	private String name;
	private LocalTime time;
	private double price;
	private boolean includesLunch;
	private String location;
	private LocalDate date;

	public Trip(String name, LocalTime time, double price, boolean includesLunch, String location, LocalDate date) {
		this.name = name;
		this.time = time;
		this.price = price;
		this.includesLunch = includesLunch;
		this.location = location;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public LocalTime getTime() {
		return time;
	}

	public double getPrice() {
		return price;
	}

	public boolean isIncludesLunch() {
		return includesLunch;
	}

	public String getLocation() {
		return location;
	}

	public LocalDate getDate() {
		return date;
	}

}
