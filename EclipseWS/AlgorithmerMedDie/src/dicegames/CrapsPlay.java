package dicegames;

import java.util.Scanner;

public class CrapsPlay {
	private Die die1;
	private Die die2;
	private boolean won;
	private int point;
	private boolean done;
	private Scanner scan;
	private boolean sessionDone;
	private int wins;
	private int losses;

	public CrapsPlay() {
		die1 = new Die();
		die2 = new Die();
		won = false;
		point = 0;
		done = false;
		scan = new Scanner(System.in);
		sessionDone = false;
		wins = 0;
		losses = 0;
	}

	private void welcomeToGame() {
		System.out.println("Velkommen til Craps, spillet handler om at rulle rigtigt!");
		System.out.println("Starter du med at slå 7 eller 11 vinder du!");
		System.out.println("Starter du med at slå 2, 3 eller 12, taber du...");
		System.out.println("Slår du alt andet, skal du forsøge at slå det igen, dog uden at slå 7!");
		System.out.println("Hvis du stopper med at slå uden at have vundet, taber du også.");
	}

	private int sum() {
		return die1.getFaceValue() + die2.getFaceValue();
	}

	private void sessionOver() {
		System.out.printf("Du har vundet %s gange, og tabt %s gange.\n", wins, losses);
		scan.close();
	}

	private void resetVariables() {
		point = 0;
		won = false;
		done = false;
		sessionDone = false;
	}

	public void startGame() {
		welcomeToGame();
		while (!sessionDone) {
			resetVariables();
			while (!done) {
				System.out.println("Ønsker du at slå med terningerne? (Ja/Nej)");
				String answer = this.scan.nextLine().toLowerCase();
				if (answer.equals("ja")) {
					takeTurn();
				} else if (answer.equals("nej")) {
					done = true;
				} else {
					System.out.println("Skriv venligst Ja eller Nej som dit svar.");
				}
			}
			gameOver();
			System.out.println("Ønsker du at fortsætte med et nyt spil?(Ja/Nej)");
			String answer = scan.nextLine().toLowerCase();
			if (answer.equals("ja")) {
				sessionDone = false;
			} else if (answer.equals("nej")) {
				sessionDone = true;
			}
		}
		sessionOver();
	}

	private void takeTurn() {
		this.die1.roll();
		this.die2.roll();
		System.out.printf("Du slog %s.\n", sum());
		if (point == 0) {
			if (sum() == 7 || sum() == 11) {
				won = true;
				done = true;
			} else if (sum() == 2 || sum() == 3 || sum() == 12) {
				won = false;
				done = true;
			} else {
				point = sum();
				done = false;
			}
		} else {
			if (sum() == 7) {
				won = false;
				done = true;
			} else if (sum() == point) {
				won = true;
				done = true;
			} else {
				done = false;
			}
		}
	}

	private void gameOver() {
		if (won) {
			System.out.println("Tillykke du vandt spillet!");
			wins++;
		} else {
			System.out.println("Desværre, du tabte spillet...");
			losses++;
		}
	}
}
