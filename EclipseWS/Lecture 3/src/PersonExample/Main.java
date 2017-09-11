package PersonExample;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Jens Hansen", "Børglumvej 22, 8200", 32560, 4);
		p1.calculateYearSalary();
		p1.printPerson();
	}

}
