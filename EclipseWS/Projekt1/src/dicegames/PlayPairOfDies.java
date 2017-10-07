package dicegames;

import java.util.Scanner;

public class PlayPairOfDies {

	private PairOfDices pair;
	private Scanner scan;

	public PlayPairOfDies() {
		pair = new PairOfDices();
		scan = new Scanner(System.in);
	}

	public void startGame() {
		welcomeToGame();
		boolean fin = false;
		while (!fin) {
			System.out.println("Want to roll your dies?");
			String line = scan.nextLine();
			if (line.toLowerCase().equals("yes")) {
				takeTurn();
			} else if (line.toLowerCase().equals("no")) {
				fin = true;
			} else {
				System.out.println("Please input either \"yes\" or \"no\"");
			}
		}
		gameOver();
	}

	private void welcomeToGame() {
		System.out.println("Welcome to Pair of Dies!!!");
	}

	private void gameOver() {
		System.out.println("Thanks for playing Pair of Dies!!!");
		scan.close();
		System.out.println(pair.numberOfPairs());
		System.out.println(pair.highestNumber());
		System.out.println(pair.numbers1To6());
	}

	private void takeTurn() {
		pair.rollBothDies();
		System.out.println(pair.rollResult());
	}
}
