package opg4And6;

/**
 * Class describing a student
 *
 */
public class Student {
	private String name;
	private boolean active;
	private int age;

	/**
	 * Create an inactive student.
	 */
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		this.active = false;
	}

	/**
	 * Create a student where 'active' is given as a parameter
	 */
	public Student(String name, int age, boolean active) {
		this.name = name;
		this.age = age;
		this.active = active;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}

	/**
	 * Increase the age of the student by 1 year.
	 */
	public void increaseAge() {
		age++;
	}

	@Override
	public String toString() {
		return "Name: \t" + name + "\n Age: \t" + age + "\n + Active: \t "
				+ active;
	}
}
