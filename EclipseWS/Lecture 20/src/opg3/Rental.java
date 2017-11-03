package opg3;

import java.util.ArrayList;

public class Rental {
	private int number;
	private int days;
	private String date;
	private ArrayList<Car> cars;

	public Rental(int number, int days, String date) {

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
}
