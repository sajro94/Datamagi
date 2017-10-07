package opg1_4_3;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in).useLocale(Locale.US);
		boolean integer = false;
		int num[] = { 0, 0, 0 };
		for (int i = 0; i < 3; i++) {
			integer = false;
			while (!integer) {
				System.out.println("Write a whole number(" + i + "):");
				if (in.hasNextInt()) {
					num[i] = in.nextInt();
					integer = true;
				} else {
					integer = false;
					System.out.println("Please write a whole number, and nothing else");
				}
			}
		}
		if (num[0] < num[1] && num[1] < num[2]) {
			System.out.println("Increasing!");
		} else if (num[0] > num[1] && num[1] > num[2]) {
			System.out.println("Decreasing!");
		} else {
			System.out.println("Neither!");
		}
		in.close();
	}

}
