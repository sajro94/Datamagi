package statGenerator;

import java.util.Arrays;
import java.util.Random;

public class DieRoller {
	public static int dieRoller(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}

	public static int dieRoller(int min, int max, int dies) {
		Random rand = new Random();
		int result = 0;
		for (int i = 0; i < dies; i++) {
			result += rand.nextInt(max - min + 1) + min;
		}
		return result;
	}

	public static int dieRoller(int min, int max, int dies, int drops) {
		Random rand = new Random();
		int result = 0;
		int[] minRoll = new int[drops];
		for (int i = 0; i < drops; i++) {
			minRoll[i] = rand.nextInt(max - min + 1) + min;
			result += minRoll[i];
		}
		Arrays.sort(minRoll);

		for (int i = drops; i < dies; i++) {
			int roll = rand.nextInt(max - min + 1) + min;
			result += roll;
			boolean done = false;
			for (int j = drops - 1; j >= 0 && !done; j--) {
				if (roll < minRoll[j]) {
					minRoll[j] = roll;
					done = true;
				}
			}
			Arrays.sort(minRoll);
		}

		for (int i = 0; i < drops; i++) {
			result -= minRoll[i];
		}
		return result;
	}

	public static int dieRoller(int min, int max, int dies, int drops, int reroll) {
		Random rand = new Random();
		int result = 0;
		int[] minRoll = new int[drops];
		for (int i = 0; i < drops; i++) {
			minRoll[i] = rand.nextInt(max - min + 1) + min;
			while (minRoll[i] <= reroll) {
				minRoll[i] = rand.nextInt(max - min + 1) + min;
			}
			result += minRoll[i];
		}
		Arrays.sort(minRoll);

		for (int i = drops; i < dies; i++) {
			int roll = rand.nextInt(max - min + 1) + min;
			while (roll <= reroll) {
				roll = rand.nextInt(max - min + 1) + min;
			}
			result += roll;
			boolean done = false;
			for (int j = drops - 1; j >= 0 && !done; j--) {
				if (roll < minRoll[j]) {
					minRoll[j] = roll;
					done = true;
				}
			}
			Arrays.sort(minRoll);
		}

		for (int i = 0; i < drops; i++) {
			result -= minRoll[i];
		}
		return result;
	}
}
