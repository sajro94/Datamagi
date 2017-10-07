package opg6;

import java.util.Scanner;

public class Date {
	private int month;
	private int day;

	public void setDate() {
		Scanner in = new Scanner(System.in);
		System.out.println("Give a number from 1 to 12 to signify month:");
		this.month = in.nextInt();
		System.out.println("Give a number from 1 to 31 to signify day:");
		this.day = in.nextInt();
		in.close();
	}

	public String getSeason() {
		String res = "";
		String season = "";
		if (this.month <= 3) {
			season = "Winter";
		} else if (this.month <= 6) {
			season = "Spring";
		} else if (this.month <= 9) {
			season = "Summer";
		} else if (this.month <= 12) {
			season = "Fall";
		}

		if (this.month % 3 == 0 && this.day >= 21) {
			switch (season) {
			case "Winter":
				res = "Spring";
				break;
			case "Spring":
				res = "Summer";
				break;
			case "Summer":
				res = "Fall";
				break;
			case "Fall":
				res = "Winter";
				break;
			}
		} else {
			res = season;
		}

		return res;
	}
}
