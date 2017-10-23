package absence;

public class AbsenceSystem {
	/**
	 * Print the absence table on the screen
	 */
	public void printAbsence(int[][] absence) {
		System.out.println("______________FRAVÆRS TABEL______________");
		System.out.println("|Mo||01|02|03|04|05|06|07|08|09|10|11|12|");
		System.out.println("|St||___________________________________|");
		for (int i = 0; i < absence.length; i++) {
			System.out.printf("|%02d||", i + 1);
			for (int d : absence[i]) {
				System.out.printf("%02d|", d);
			}
			System.out.printf("%n");
		}
	}

	/**
	 * Returns the total number of absent days for the given student during the last
	 * 12 months.
	 */
	public int totalAbsence(int[][] absence, int studentNumber) {
		if (studentNumber <= absence.length && studentNumber > 0) {
			int sum = 0;
			for (int d : absence[studentNumber - 1]) {
				sum += d;
			}
			return sum;
		}
		return Integer.MIN_VALUE;
	}

	/**
	 * Returns the average monthly number of absent days for the given student.
	 */
	public double averageMonth(int[][] absence, int studentNumber) {
		// TODO
		return (double) totalAbsence(absence, studentNumber) / (double) 12;
	}

	/**
	 * Returns the number of students without any absence during the last 12 months.
	 *
	 */
	public int studentWithoutAbsenceCount(int[][] absence) {
		int count = 0;
		for (int i = 1; i <= absence.length; i++) {
			count += totalAbsence(absence, i) == 0 ? 1 : 0;
		}
		return count;
	}

	/**
	 * Returns the student with the most absence during the last 12 months. If more
	 * than one student has the most absence, return any one of them.
	 */
	public int mostAbsentStudent(int[][] absence) {
		int max = Integer.MIN_VALUE;
		int studId = 0;
		for (int i = 1; i <= absence.length; i++) {
			int test = totalAbsence(absence, i);
			if (test > max) {
				max = test;
				studId = i;
			}
		}
		return studId;
	}

	/**
	 * Resets the absence to 0 for the given student during the last 12 months.
	 */
	public void reset(int[][] absence, int studentNumber) {
		if (studentNumber <= absence.length && studentNumber != 0) {
			for (int i = 0; i < absence[studentNumber - 1].length; i++) {
				absence[studentNumber - 1][i] = 0;
			}
		}
	}
}
