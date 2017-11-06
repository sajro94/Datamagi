package classes;

public class Gift {
	private String desc;
	private double price;
	private Person giver;

	public Gift(String desc) {
		super();
		this.desc = desc;
	}

	public void setGiver(Person giver) {
		this.giver = giver;
	}

	public Person getGiver() {
		return new Person(giver);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}
}
