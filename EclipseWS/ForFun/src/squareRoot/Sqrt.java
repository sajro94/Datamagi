package squareRoot;

import java.util.Random;

public class Sqrt {

	public static void main(String[] args) {
		System.out.println(sqrt(500));

	}

	public static double sqrt(int kat) {
		int halfway = kat / 2;
		Random rand = new Random();
		double num = rand.nextInt(halfway) + 1;
		double test = 0.0;
		while (Math.abs(test - num) > 0.00000000000001) {
			test = kat / num;
			num = (test + num) / 2.0;
		}
		return num;
	}

}
