package opg2;

import java.util.Arrays;
import java.util.Random;

public class MultipleChoice {
	private char[] correctAnswer = { 'B', 'C', 'A', 'A', 'B', 'A', 'C', 'D', 'A', 'C' };
	private char[][] studentAnswers;
	private int[] corrPerQuest = new int[10];
	private Random random = new Random(105); // Sikrer at vi altid får de samme tilfældige tal

	public MultipleChoice(int numberOfStudents) {
		studentAnswers = new char[numberOfStudents][10];
		for (int i = 0; i < studentAnswers.length; i++) {
			for (int j = 0; j < studentAnswers[i].length; j++) {
				int tal = random.nextInt(4); // tilfældigt tal fra 0-3
				char c = (char) (tal + 'A'); // laver tallet om til en char fra A-C
				studentAnswers[i][j] = c;
			}
		}
	}

	public void printStudentAnswers() {
		for (int i = 0; i < studentAnswers.length; i++) {
			System.out.print("Student " + (i + 1) + " resultat: ");
			for (int j = 0; j < studentAnswers[i].length; j++) {
				if (j != 0) {
					System.out.print(", ");
				}
				System.out.print(studentAnswers[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Udskriver for hver studerende antallet af rigtige svar
	 */
	public void printCorrectAnswersPrStudent() {
		int studID = 1;
		for (char[] d : studentAnswers) {
			int corr = 0;
			for (int i = 0; i < d.length; i++) {
				if (d[i] == correctAnswer[i]) {
					corr++;
				}
			}
			System.out.printf("%02d: %02d rigtige svar.%n", studID, corr);
		}
	}

	/**
	 * Udskriver for hvert spørgsmål antallet af rigtige svar
	 */
	public void printCorrectAnswerPrQuestion() {
		for (int i = 0; i < studentAnswers.length; i++) {
			for (int j = 0; j < studentAnswers[i].length; j++) {
				if (studentAnswers[i][j] == correctAnswer[j]) {
					corrPerQuest[j]++;
				}
			}
		}
		System.out.println(Arrays.toString(corrPerQuest));
	}

}
