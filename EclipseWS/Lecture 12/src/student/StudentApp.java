package student;

public class StudentApp {

	public static void main(String[] args) {
		Student s1 = new Student("Hanne", 20);
		Student s2 = new Student("Margrethe", 12);

		s2.addGrade(7);
		s2.addGrade(12);
		s2.addGrade(10);

		System.out.printf("%s har et gennemsnit på: %.1f\n", s2.getName(), s2.averageGrade());
		System.out.printf("%s har et gennemsnit på: %.1f\n", s1.getName(), s1.averageGrade());
		System.out.printf("%s har fået %s som sin højeste karakter.\n", s2.getName(), s2.maxGrade());
		System.out.printf("%s har fået %s som sin laveste karakter.\n", s2.getName(), s2.minGrade());

		System.out.println("Karaktererne for " + s2.getName());
		for (int i = 0; i < s2.getNumberOfGrades(); i++) {
			System.out.println(s2.getGrades()[i]);
		}
	}

}
