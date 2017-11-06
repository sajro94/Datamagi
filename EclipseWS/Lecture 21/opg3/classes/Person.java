package classes;

import java.util.ArrayList;

public class Person {
	private String name;
	private int age;
	private ArrayList<Gift> received = new ArrayList<>();

	public Person(String name, int age) {
		this.name = name;
		setAge(age);
	}

	public Person(Person person) {
		this.name = person.name;
		this.age = person.age;
		this.received = person.getReceived();
	}

	public void addGift(Gift g) {
		received.add(g);
	}

	public ArrayList<Gift> getReceived() {
		return new ArrayList<>(received);
	}

	public double totalGiftValue() {
		double totalValue = 0.00;
		for (Gift g : received) {
			totalValue += g.getPrice();
		}
		return totalValue;
	}

	@Override
	public String toString() {
		return name;
	}

	public ArrayList<Person> getGivers() {
		ArrayList<Person> givers = new ArrayList<>();
		for (Gift g : received) {
			givers.add(g.getGiver());
		}
		return givers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
