package statGenerator;

import java.util.ArrayList;
import java.util.Random;

public class Generator {
	private ArrayList<Integer> deck;
	private int[] stats;

	public Generator() {
		stats = new int[6];
	}

	public void printStats() {
		System.out.printf("|%02d|", stats[0]);
		for (int i = 1; i < 6; i++) {
			System.out.printf("%02d|", stats[i]);
		}
	}

	public void ironmanGen() {
		for (int i = 0; i < stats.length; i++) {
			stats[i] = dieRoller(1, 6);
		}
	}

	public int dieRoller(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min) + min;
	}

	public void cardGen() {
		deck = new ArrayList<>();
		deck.add(1);
		deck.add(1);
		deck.add(2);
		deck.add(2);
		deck.add(3);
		deck.add(3);
		deck.add(3);
		deck.add(4);
		deck.add(4);
		deck.add(4);
		deck.add(5);
		deck.add(5);
		deck.add(5);
		deck.add(5);
		deck.add(6);
		deck.add(6);
		deck.add(6);
		deck.add(6);
		Random rand = new Random();
		int counter = 0;
		while (deck.size() != 0) {
			for (int i = 0; i < 3; i++) {
				int rando = rand.nextInt(deck.size());
				stats[counter] += deck.get(rando);
				deck.remove(rando);
			}
			counter++;
		}
	}
}
