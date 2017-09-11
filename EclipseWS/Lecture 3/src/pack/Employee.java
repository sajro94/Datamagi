package pack;

public class Employee { // Class
	private String name; // Felt / attribut
	private boolean trainee; // Felt / attribut
	private int age;
	private String firstname;
	private String lastname;

	// Constructor
	public Employee(String fn, String ln, int inputAge) {
		this.name = ln + ", " + fn;
		this.trainee = true;
		this.age = inputAge;
		this.firstname = fn;
		this.lastname = ln;
	}

	// Accessor-metoder
	public String getName() {
		return this.name;
	}

	public boolean isTrainee() {
		return this.trainee;
	}

	public int getAge() {
		return this.age;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	// Mutator-metoder
	public void setName(String inputName) {
		this.name = inputName;
	}

	public void setTrainee(boolean trainee) {
		this.trainee = trainee;
	}

	public void setAge(int inputAge) {
		this.age = inputAge;
	}

	public void increaseAgeByOne() {
		this.age += 1;
	}

	public void setFirstname(String fn) {
		this.firstname = fn;
	}

	public void setLastname(String ln) {
		this.lastname = ln;
	}

	@Override
	public String toString() {
		return this.name + " is trainee: " + this.trainee;
	}

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("Name: " + this.name);
		System.out.println("Trainee " + this.trainee);
		System.out.println();
	}
}
