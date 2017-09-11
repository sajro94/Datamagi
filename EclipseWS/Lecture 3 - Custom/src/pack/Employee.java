package pack;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String str) {
		this.name = str;
	}

	private boolean trainee;

	public boolean getTrainee() {
		return this.trainee;
	}

	public void setTrainee(boolean b) {
		this.trainee = b;
	}

	private Date hired;

	public void setDate(int y, int m, int d) {
		Calendar c = GregorianCalendar.getInstance();
		c.set(y, m, d);
		this.hired = c.getTime();
	}

	public static String nl = System.getProperty("line.separator");

	public String getDate() {
		return hired.toString();
	}

	private double salary;

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double d) {
		this.salary = d;
	}

	public Employee() {
		this.name = "Default Name";
		this.trainee = false;
		hired = new Date();
	}

	public Employee(String n) {
		this.name = n;
		this.trainee = false;
		hired = new Date();
	}

	public Employee(String n, boolean b) {
		this.name = n;
		this.trainee = b;
		hired = new Date();
	}

	public Employee(String n, boolean b, double s) {
		this.name = n;
		this.trainee = b;
		hired = new Date();
		this.salary = s;
	}

	@Override
	public String toString() {
		return "*****************************************" + nl + "Name: " + this.name + nl + "Trainee : " + trainee
				+ nl + "Salary: " + salary + nl + "Hired: " + hired.toString() + nl
				+ "*****************************************";

	}
}
