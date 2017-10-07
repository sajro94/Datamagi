package dicegames;

/**
 * This class models one pair of dices. This is useful for games where you have
 * to throw two dice at once.
 */
public class PairOfDices {
	/**
	 * The first die in the pair.
	 */
	private Die die1;
	/**
	 * The second die in the pair.
	 */
	private Die die2;
	private int dieThrows = 0;
	private int[] rolls;
	private int pairs = 0;
	private int high = 0;

	public int getDieThrows() {
		return dieThrows;
	}

	public int[] getRolls() {
		return rolls;
	}

	public int getPairs() {
		return pairs;
	}

	public String numberOfPairs() {
		return String.format("You rolled %s pairs!", this.pairs);
	}

	public String numbers1To6() {
		return String.format(
				"You rolled %s ones.\nYou rolled %s twoes.\nYou rolled %s threes.\nYou rolled %s fours.\nYou rolled %s fives.\nYou rolled %s sixes.",
				this.rolls[0], this.rolls[1], this.rolls[2], this.rolls[3], this.rolls[4], this.rolls[5]);
	}

	public String highestNumber() {
		return String.format("Your highest roll was %s.", this.high);
	}

	public int getHigh() {
		return high;
	}

	/**
	 * Constructor for objects of class PairOfDices
	 */

	public String rollResult() {
		return String.format("Your rolled a %s and a %s, giving a sum of %s", die1.getFaceValue(), die2.getFaceValue(),
				sumOfDies());
	}

	public PairOfDices() {
		die2 = new Die();
		die1 = new Die();
		rolls = new int[6];
		for (int i = 0; i < 6; i++) {
			rolls[i] = 0;
		}
	}

	public PairOfDices(int sides) {
		die1 = new Die(sides);
		die2 = new Die(sides);
		rolls = new int[sides];
		for (int i = 0; i < sides; i++) {
			rolls[i] = 0;
		}
	}

	public void resetPairOfDies() {
		dieThrows = 0;
		for (int i = 0; i < rolls.length; i++) {
			rolls[i] = 0;
		}
		pairs = 0;
		high = 0;
	}

	public void rollBothDies() {
		die1.roll();
		rolls[die1.getFaceValue() - 1]++;
		die2.roll();
		rolls[die2.getFaceValue() - 1]++;
		dieThrows++;
		if (die1.getFaceValue() == die2.getFaceValue()) {
			pairs++;
		}
		if (sumOfDies() > high) {
			high = sumOfDies();
		}
	}

	public int sumOfDies() {
		return die1.getFaceValue() + die2.getFaceValue();
	}

}
