package opg1_4_5;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in).useLocale(Locale.US);
		boolean integer = false;
		int num = 0;
		while (!integer) {
			System.out.println("Write a whole number less than 1000000000:");
			if (in.hasNextInt()) {
				num = in.nextInt();
				integer = true;
			} else {
				integer = false;
				System.out.println("Please write a whole number, and nothing else");
			}
		}
		if (num < 0) {
			num = num * -1;
		}

		if (num < 10) {
			System.out.println("Digits: 1");
		} else if (num < 100) {
			System.out.println("Digits: 2");
		} else if (num < 1000) {
			System.out.println("Digits: 3");
		} else if (num < 10000) {
			System.out.println("Digits: 4");
		} else if (num < 100000) {
			System.out.println("Digits: 5");
		} else if (num < 1000000) {
			System.out.println("Digits: 6");
		} else if (num < 10000000) {
			System.out.println("Digits: 7");
		} else if (num < 100000000) {
			System.out.println("Digits: 8");
		} else if (num < 1000000000) {
			System.out.println("Digits: 9");
		}
		in.close();
	}

}
