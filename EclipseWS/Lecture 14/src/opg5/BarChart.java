package opg5;

import java.util.ArrayList;
import java.util.Scanner;

public class BarChart {
	private final int BAR_MAX = 40;
	private ArrayList<Integer> list = new ArrayList<>();
	private ArrayList<String> titles = new ArrayList<>();

	public ArrayList<Integer> readValues() {
		System.out.println(
				"Indtast nogle positive tal. Efter hvert Tal skriver du dens titel. Formen er: (<titel> <tal>) "
						+ "Indtast \"stop\" for at afslutte: ");

		Scanner in = new Scanner(System.in);
		String n = in.nextLine();
		while (!n.equalsIgnoreCase("stop")) {
			String[] args = n.split(" ");
			list.add(Integer.parseInt(args[1]));
			titles.add(args[0]);
			n = in.nextLine();
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

	private int longestTitle() {
		int max = Integer.MIN_VALUE;
		for (String s : titles) {
			if (s.length() > max) {
				max = s.length();
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
		int tL = longestTitle();
		for (int i = 0; i < list.size(); i++) {
			int d = list.get(i);
			String t = titles.get(i);
			double ratio = (double) d / (double) max;
			double length = ratio * BAR_MAX;
			String bar = "";
			for (int j = 1; j <= (int) length; j++) {
				bar += "*";
			}
			System.out.printf("%" + tL + "s|%s%n", t, bar);
		}
	}
}
