package dicegames;

import java.util.Scanner;

public class PigPlay {
	private Die die;
	private Player player1;
	private Player player2;
	private Scanner scan;
	private boolean done;
	private int winAmount;
	private boolean computer;
	private int turnRolls;

	// The constructor of the PigPlay class.
	public PigPlay() {
		die = new Die();
		player1 = new Player();
		player2 = new Player();
		scan = new Scanner(System.in);
		done = false;
		winAmount = 100;
		computer = false;
		turnRolls = 0;
	}

	// Method used for handling taking a turn for the computer, it is very much the
	// same as a human turn, but a seperate method since the logic might be
	// drastically different.
	private int computerTurn() {
		int result = 0;
		this.turnRolls = 0;
		boolean done = false;
		while (!done) {
			this.turnRolls++;
			die.roll();
			int roll = die.getFaceValue();
			if (roll == 1) {
				done = true;
				result = 0;
			} else {
				result += roll;
				double randNum = Math.random();
				if (result / 20 > randNum) {
					done = true;
				} else {
					done = false;
				}
			}
		}
		return result;
	}

	// Method to handle when a human player has to take a turn.
	private int takeTurn() {
		int result = 0;
		this.turnRolls = 0;
		boolean done = false;
		while (!done) {
			this.turnRolls++;
			die.roll();
			int roll = die.getFaceValue();
			if (roll == 1) {
				System.out.println("Desværre slog du 1, og får derfor ingen point!");
				done = true;
				result = 0;
			} else {
				result += roll;
				System.out.printf("Du slog %s, vil du fortsætte(ja) eller få %s point?\n", roll, result);
				String answer = scan.nextLine().toLowerCase();
				if (answer.equals("ja")) {
					done = false;
				} else {
					done = true;
				}
			}
		}
		return result;
	}

	// A method used for displaying and getting basic information from the players.
	// Has a single parameter which is a string to change whether to ask for the
	// name of player 2 or the computer.
	private void welcomeToGame(String computerHuman) {
		System.out.println("Velkommen til 100.");
		System.out.println("Slå med terning, stop før du slår et, og gem dine point!");
		System.out.println("Hvad er første spillers navn?");
		player1.setName(scan.nextLine());
		System.out.printf("Hvad er %s navn?\n", computerHuman);
		player2.setName(scan.nextLine());
		System.out.printf("Velkommen til 100 %s vs %s\n", player1.getName(), player2.getName());
		System.out.println("Hvor mange point vil i spille til?");
		if (scan.hasNextInt()) {
			winAmount = scan.nextInt();
		}
		System.out.printf("I spiller til %s point.\n", winAmount);
	}

	// This method initializes the game and is used to ask whether this is a game
	// against the computer or another human. The only method except the constructor
	// that can be called from outside the class.
	public void initialize() {
		System.out.println("Vil du spille mod en computer?");
		String answer = scan.nextLine().toLowerCase();
		if (answer.equals("ja")) {
			computer = true;
		} else {
			computer = false;
		}
		startGame();
	}

	// Method for actually starting and running the game.
	private void startGame() {
		if (computer) {
			welcomeToGame("computerens");
		} else {
			welcomeToGame("anden spillers");
		}
		Player active = player1;
		int result = 0;
		while (!done) {
			active.addRounds(1);
			if (active.equals(player2) && computer) {
				System.out.println("Det er nu computerens tur, stand by.");
				result = computerTurn();
				active.addRolls(turnRolls);
			} else {
				System.out.printf("Det er nu %s. Tryk på Enter når du er klar.\n", active.getName());
				scan.nextLine();
				result = takeTurn();
				active.addRolls(turnRolls);
			}
			active.addPoints(result);
			System.out.printf("%s fik %s point. %s har nu et total af %s Point.\n", active.getName(), result,
					active.getName(), active.getPoints());
			if (active.getPoints() >= winAmount) {
				System.out.printf("Tillykke %s du har vundet!\n", active.getName());
				System.out.printf("%s havde i gennemsnit %s slag per runde\n", player1.getName(),
						player1.averageRolls());
				System.out.printf("%s havde i gennemsnit %s slag per runde\n", player2.getName(),
						player2.averageRolls());
				done = true;
			} else {
				if (active.equals(player1)) {
					active = player2;
				} else if (active.equals(player2)) {
					active = player1;
				}
			}
		}
	}

}
