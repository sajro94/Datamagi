package opg2;

import java.time.LocalDate;

public class Rental {
	private int number;
	private int days;
	private LocalDate startDate;
	private double price;

	/**
	 *
	 * @param number
	 *            an int referencing the item rented.<br>
	 * @param days
	 *            an int referencing how many days to rent.<br>
	 * @param price
	 *            a double holding the price per day of the rent.<br>
	 * @param startDate
	 *            a LocalDate for when the rental period starts.<br>
	 */
	public Rental(int number, int days, double price, LocalDate startDate) {
		this.number = number;
		this.days = days;
		this.startDate = startDate;
		this.price = price;
	}

	/**
	 * Returns the price field.<br>
	 *
	 * @return double<br>
	 */
	public double getPricePrDay() {
		return price;
	}

	/**
	 * sets how many days the rental periods lasts.<br>
	 *
	 * @param days
	 *            an int.<br>
	 */
	public void setDays(int days) {
		this.days = days;
	}

	/**
	 * Return the days field<br>
	 *
	 * @return int<br>
	 */
	public int getDays() {
		return days;
	}

	/**
	 * Returns the startDate field<br>
	 *
	 * @return LocalDate<br>
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * Returns the endDate based on startDate and days.<br>
	 *
	 * @return LocalDate
	 */
	public LocalDate getEndDate() {
		return startDate.plusDays(days);
	}

	/**
	 * Returns the total price for the period.<br>
	 *
	 * @return double<br>
	 */
	public double getTotalPrice() {
		return price * days;
	}

	@Override
	public String toString() {
		return String.format("Number: %s%nStart Date: %s%nEnd Date: %s", number, startDate, getEndDate());
	}
}
