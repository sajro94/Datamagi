package opg3;

public class Car {
	private String license;
	private double pricePerDay;
	private int purchaseYear;

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

}
