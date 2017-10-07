package PersonExample;

public class Person {
	private String firstName;
	private String lastName;
	private String middleName;
	private String adress;
	private int monthlySalary;
	private double yearSalary;
	private int hirings;
	private int year;
	private int month;
	private int day;

	public String getInitials() {
		if (this.middleName == null) {
			return this.firstName.substring(0, 2) + this.lastName.substring(0, 1);
		} else {
			return this.firstName.substring(0, 1) + this.middleName.substring(0, 1) + this.lastName.substring(0, 1);
		}
	}

	public String birthdatWeekday(int d, int y) {
		String[] week = { "mandag", "tirsdag", "onsdag", "torsdag", "fredag", "lørdag", "søndag" };
		String weekday = week[d];
		int diff = 0;
		for (int i = this.year + 1; i <= y; i++) {
			if (leapYear(i)) {
				diff += 2;
			} else {
				diff += 1;
			}
		}

		for (int i = 1; i <= diff; i++) {
			if (d == 6) {
				d = 0;
			} else {
				d++;
			}
		}

		return "You were born on a " + weekday + " this year your birthday falls on a " + week[d];
	}

	public String getUsername() {

		if (this.middleName == null) {
			int diff = this.firstName.length() - this.lastName.length();
			if (diff < 0) {
				diff = diff * -1;
			}
			return this.firstName.substring(0, 2).toUpperCase() + diff
					+ this.lastName.substring(this.lastName.length() - 2).toLowerCase();
		} else {
			return this.firstName.substring(0, 2).toUpperCase() + this.middleName.length()
					+ this.lastName.substring(this.lastName.length() - 2).toLowerCase();
		}
	}

	public int age(int ny, int nm, int nd) {
		int dy = ny - this.year;
		if (nm > this.month) {
			return dy;
		} else if (nm == this.month && nd >= this.day) {
			return dy;
		} else {
			return dy - 1;
		}
	}

	public void setBirthday(int y, int m, int d) {
		this.year = y;
		this.month = m;
		this.day = d;
	}

	public boolean leapYear(int y) {
		boolean res = false;
		if (y % 4 == 0) {
			res = true;
			if (y % 100 == 0) {
				res = false;
				if (y % 400 == 0) {
					res = true;
				}
			}
		} else {
			res = false;
		}
		return res;
	}

	public Person() {

	}

	public Person(String fn, String mn, String ln, String a, int ms, int h) {
		this.firstName = fn;
		this.lastName = ln;
		this.middleName = mn;
		this.adress = a;
		this.monthlySalary = ms;
		this.hirings = h;
	}

	public void setHirings(int h) {
		this.hirings = h;
	}

	public void setName(String fn, String mn, String ln) {
		this.firstName = fn;
		this.lastName = ln;
		this.middleName = mn;
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
		if (this.middleName != null) {
			return this.firstName + " " + this.middleName + " " + this.lastName;
		} else {
			return this.firstName + " " + this.lastName;
		}
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
		System.out.println("Name: " + getName());
		System.out.println("Adress: " + adress);
		System.out.println("Salary: ");
		System.out.println("   Monthly: " + monthlySalary);
		System.out.println("   Yearly: " + yearSalary);
		System.out.println("Age: " + age(2017, 9, 20));
	}
}
