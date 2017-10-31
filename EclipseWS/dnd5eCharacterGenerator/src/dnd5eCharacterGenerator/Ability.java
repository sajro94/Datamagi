package dnd5eCharacterGenerator;

public class Ability {
	public static final Ability STRENGTH = new Ability("Strength");
	public static final Ability DEXTERITY = new Ability("Dexterity");
	public static final Ability CONSTITUTION = new Ability("Constitution");
	public static final Ability INTELLIGENCE = new Ability("Intelligence");
	public static final Ability WISDOM = new Ability("Wisdom");
	public static final Ability CHARISMA = new Ability("Charisma");
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
