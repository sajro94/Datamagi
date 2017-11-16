package application.model;

public class ExtraService {
	private String name;
	private double price;

	public ExtraService(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

}
