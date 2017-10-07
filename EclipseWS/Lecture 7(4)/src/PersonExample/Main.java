package PersonExample;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Flemming", null, "Pedersen", "Børglumvej 22, 8200", 32560, 4);
		p1.setBirthday(1994, 7, 13);
		p1.calculateYearSalary();
		p1.printPerson();
		System.out.println(p1.leapYear(400));
		System.out.println(p1.leapYear(800));
		System.out.println(p1.leapYear(1000));
		System.out.println(p1.leapYear(64));
		System.out.println(p1.leapYear(240));
		System.out.println(p1.leapYear(324));
		System.out.println(p1.leapYear(137));
		System.out.println(p1.leapYear(60));
		System.out.println(p1.leapYear(2017));
		System.out.println(p1.getInitials());
		System.out.println(p1.getUsername());
		System.out.println(p1.birthdatWeekday(2, 2017));
	}

}
