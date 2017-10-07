package dicegames;

import java.util.Scanner;

public class PlayPairOfDice {

	private Scanner scan;
	private boolean done;
	private PairOfDices dice;

	public PlayPairOfDice() {
		this.scan = new Scanner(System.in);
		this.done = false;
		this.dice = new PairOfDices();
	}

	public void startGame() {
		while (!done) {
			System.out.println("Ønsker du at slå med terningerne? (Ja/Nej)");
			String answer = this.scan.nextLine().toLowerCase();
			if (answer.equals("ja")) {
				takeTurn();
			} else if (answer.equals("nej")) {
				this.done = true;
			} else {
				System.out.println("Skriv venligst Ja eller Nej som dit svar.");
			}
		}
		gameOver();
	}

	private void takeTurn() {
		this.dice.rollBothDices();
		System.out.printf("Du rullede en sum af %s, med en %s'er og en %s'er.\n", this.dice.sumOfDices(),
				this.dice.getFace1(), this.dice.getFace2());
	}

	private void printNumberLine(String num, int value) {
		System.out.printf("Du slog %s %s.\n", value, num);
	}

	private void gameOver() {
		System.out.printf("Dit største kast var %s.\n", this.dice.getHigh());
		System.out.printf("Du rullede %s par.\n", this.dice.getPairs());
		printNumberLine("enere", this.dice.getOnes());
		printNumberLine("toere", this.dice.getTwoes());
		printNumberLine("treere", this.dice.getThrees());
		printNumberLine("firere", this.dice.getFours());
		printNumberLine("femere", this.dice.getFives());
		printNumberLine("sekesere", this.dice.getSixes());
		this.scan.close();
	}
}
