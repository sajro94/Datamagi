package dnd5eCharacterGenerator;

public class Ability extends Choice {
	public static final Ability STRENGTH = new Ability("Strength");
	public static final Ability DEXTERITY = new Ability("Dexterity");
	public static final Ability CONSTITUTION = new Ability("Constitution");
	public static final Ability INTELLIGENCE = new Ability("Intelligence");
	public static final Ability WISDOM = new Ability("Wisdom");
	public static final Ability CHARISMA = new Ability("Charisma");
	public final static Choice[] ABILITIES = { STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA };
	private int score;
	private int mod;

	public Ability(String name) {
		super(name);
	}

	public Ability(Ability other) {
		super(other.name);
	}

	public Ability(Ability other, int score) {
		super(other.name);
		this.score = score;
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

	public boolean equals(Ability other) {
		if (name.equals(other.getName())) {
			return true;
		}
		return false;
	}

	public void addScore(int score2) {
		this.score += score2;
	}

}
