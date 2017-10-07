package dicegames;

public class Player {
	// Class to handle information about a player in the game of pig.
	private String name;
	private int points;
	private int rounds;
	private int rolls;

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public void addRounds(int rounds) {
		this.rounds += rounds;
	}

	public int getRolls() {
		return rolls;
	}

	public void setRolls(int rolls) {
		this.rolls = rolls;
	}

	public void addRolls(int rolls) {
		this.rolls += rolls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void addPoints(int points) {
		this.points += points;
	}

	public double averageRolls() {
		return rolls / rounds;
	}

}
