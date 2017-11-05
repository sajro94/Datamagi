package opg3;

import java.util.ArrayList;

public class Rental {
	private int number;
	private int days;
	private String date;
	private ArrayList<Car> cars;

	public Rental(int number, int days, String date) {
		cars = new ArrayList<>();
		setNumber(number);
		setDays(days);
	}

	public ArrayList<Car> getCars() {
		return new ArrayList<>(cars);
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		double totalPPD = 0.00;
		for (Car c : cars) {
			totalPPD += c.getPricePerDay();
		}
		return totalPPD * days;
	}
}
