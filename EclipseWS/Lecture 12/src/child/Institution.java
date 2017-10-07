package child;

public class Institution {
	private final int MAX_CHILDREN = 100;
	private String name;
	private String adress;
	private int numberOfChildren = 0;
	private Child[] children = new Child[100];

	public Institution(String name, String adress) {
		this.name = name;
		this.adress = adress;
	}

	public void addChild(Child child) {
		if (numberOfChildren < MAX_CHILDREN) {
			children[numberOfChildren] = child;
			numberOfChildren++;
		}
	}

	public double averageAge() {
		int totalAge = 0;
		for (int i = 0; i < numberOfChildren; i++) {
			totalAge += children[i].getAge();
		}
		return (double) totalAge / numberOfChildren;
	}

	public int girlsCount() {
		int girls = 0;
		for (int i = 0; i < numberOfChildren; i++) {
			if (!children[i].isBoy()) {
				girls++;
			}
		}
		return girls;
	}

	public int boysCount() {
		int boys = 0;
		for (int i = 0; i < numberOfChildren; i++) {
			if (children[i].isBoy()) {
				boys++;
			}
		}
		return boys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

}
