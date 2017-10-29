package opg1_4_1;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner in = scanner.useLocale(Locale.US);
		boolean integer = false;
		int num = 0;
		while (!integer) {
			System.out.println("Write a whole number:");
			if (in.hasNextInt()) {
				num = in.nextInt();
				integer = true;
			} else {
				integer = false;
				System.out.println("Please write a whole number, and nothing else");
			}
		}
		if (num < 0) {
			System.out.println("Number is negative");
		} else if (num > 0) {
			System.out.println("Number is positive");
		} else {
			System.out.println("Number is zero");
		}
		scanner.close();
	}

}
