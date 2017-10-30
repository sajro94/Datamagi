package dnd5eCharacterGenerator;

public class Ability {
	private String name;
	private int score;
	private int mod;

	public Ability(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		if (score % 2 == 1) {
			this.mod = (score - 11) / 2;
		} else {
			this.mod = (score - 10) / 2;
		}
	}

	public int getMod() {
		return mod;
	}

}
