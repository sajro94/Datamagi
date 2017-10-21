package opg3;

import java.util.ArrayList;
import java.util.Scanner;

public class BarChart {
	private final int BAR_MAX = 40;
	private ArrayList<Integer> list = new ArrayList<>();

	public ArrayList<Integer> readValues() {
		System.out.println("Indtast nogle positive tal.  " + "Indtast et negativt tal for at afslutte: ");

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n >= 0) {
			list.add(n);
			n = in.nextInt();
		}
		in.close();

		return list;
	}

	/**
	 * Finds and returns the max value in the list.
	 *
	 * @param list
	 *            the list with values.
	 * @return the max value found.
	 */
	public int findMax(ArrayList<Integer> list) {
		// TODO: find max in list
		int max = Integer.MIN_VALUE;
		for (int d : list) {
			if (d > max) {
				max = d;
			}
		}
		return max;
	}

	/**
	 * Prints out a BarChart of the values using the System.out.println method. The
	 * max value will be printed with a width of 40 stars (*).
	 */
	public void printBarChart() {
		int max = findMax(this.list);
		for (int d : this.list) {
			double ratio = (double) d / (double) max;
			double length = ratio * BAR_MAX;
			for (int i = 1; i <= (int) length - 1; i++) {
				System.out.print("*");
			}
			System.out.println("*");
		}
	}
}
