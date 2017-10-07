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
	// Variable to store number of rolls.
	private int rolls;
	// Variables to store number of facevalues.
	private int sixes;
	private int fives;
	private int fours;
	private int threes;
	private int twoes;
	private int ones;
	// Variable to store number of pairs rolled
	private int pairs;
	// Variable to store highest number rolled
	private int high;

	/**
	 * Constructor for objects of class PairOfDices
	 */
	public PairOfDices() {
		this.die1 = new Die();
		this.die2 = new Die();
	}

	public PairOfDices(int sides) {
		this.die1 = new Die(sides);
		this.die2 = new Die(sides);
	}

	public void resetPairOfDice() {
		this.rolls = 0;
		this.sixes = 0;
		this.fives = 0;
		this.fours = 0;
		this.threes = 0;
		this.twoes = 0;
		this.ones = 0;
		this.pairs = 0;
		this.high = 0;
	}

	private void testDie(Die die) {
		if (die.getFaceValue() == 6) {
			this.sixes++;
		} else if (die.getFaceValue() == 5) {
			this.fives++;
		} else if (die.getFaceValue() == 4) {
			this.fours++;
		} else if (die.getFaceValue() == 3) {
			this.threes++;
		} else if (die.getFaceValue() == 2) {
			this.twoes++;
		} else if (die.getFaceValue() == 1) {
			this.ones++;
		}
	}

	private void testPair(Die die1, Die die2) {
		if (die1.getFaceValue() == die2.getFaceValue()) {
			pairs++;
		}
	}

	public void rollBothDices() {
		this.rolls++;
		this.die1.roll();
		this.die2.roll();
		testDie(this.die1);
		testDie(this.die2);
		testPair(this.die1, this.die2);
		if (sumOfDices() > this.high) {
			this.high = sumOfDices();
		}
	}

	public int sumOfDices() {
		return this.die1.getFaceValue() + this.die2.getFaceValue();
	}

	public int getFace1() {
		return die1.getFaceValue();
	}

	public int getFace2() {
		return die2.getFaceValue();
	}

	public int getRolls() {
		return rolls;
	}

	public int getSixes() {
		return sixes;
	}

	public int getFives() {
		return fives;
	}

	public int getFours() {
		return fours;
	}

	public int getThrees() {
		return threes;
	}

	public int getTwoes() {
		return twoes;
	}

	public int getOnes() {
		return ones;
	}

	public int getPairs() {
		return pairs;
	}

	public int getHigh() {
		return high;
	}

}
