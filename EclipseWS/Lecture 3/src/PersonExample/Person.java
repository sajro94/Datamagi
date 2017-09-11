package PersonExample;

public class Person {
	private String name;
	private String adress;
	private int monthlySalary;
	private double yearSalary;
	private int hirings;

	public Person() {

	}

	public Person(String n, String a, int ms, int h) {
		this.name = n;
		this.adress = a;
		this.monthlySalary = ms;
		this.hirings = h;
	}

	public void setHirings(int h) {
		this.hirings = h;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setAdress(String a) {
		this.adress = a;
	}

	public void setMonthlySalary(int s) {
		this.monthlySalary = s;
	}

	public void increaseHirings() {
		this.hirings += 1;
	}

	public int getHirings() {
		return this.hirings;
	}

	public String getName() {
		return this.name;
	}

	public String getAdress() {
		return this.adress;
	}

	public int getMonthlySalary() {
		return this.monthlySalary;
	}

	public void calculateYearSalary() {
		double temp = this.monthlySalary * 12;
		this.yearSalary = temp * 1.025;
	}

	public void printPerson() {
		System.out.println("*****************************************");
		System.out.println("Name: " + name);
		System.out.println("Adress: " + adress);
		System.out.println("Salary: ");
		System.out.println("   Monthly: " + monthlySalary);
		System.out.println("   Yearly: " + yearSalary);
	}
}
