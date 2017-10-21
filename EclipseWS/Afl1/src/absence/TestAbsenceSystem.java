package absence;

public class TestAbsenceSystem {

	public static void main(String[] args) {
		int[][] absence17t = { { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
				{ 5, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0 } };

		AbsenceSystem absenceSystem = new AbsenceSystem();
		absenceSystem.printAbsence(absence17t);
		System.out.printf("Gennemsnitlig Frav�r for elev nummer %s er %s dage per m�ned.%n", 3,
				absenceSystem.averageMonth(absence17t, 3));
		System.out.printf("Den mest frav�rende elev er elev nummer %s.%n", absenceSystem.mostAbsentStudent(absence17t));
		System.out.printf("%s elever har ikke haft noget frav�r.%n",
				absenceSystem.studentWithoutAbsenceCount(absence17t));
		System.out.printf("Elev nummer %s har v�ret frav�rende i alt %s dage.%n", 3,
				absenceSystem.totalAbsence(absence17t, 3));
		absenceSystem.reset(absence17t, 4);
		absenceSystem.printAbsence(absence17t);
	}
}
