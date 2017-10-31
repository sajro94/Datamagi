package dnd5eCharacterGenerator;

public class Skill extends Choice {
	private String desc;
	private Ability ability;

	static final Skill ACROBATICS = new Skill("Acrobatics", "Make amazing acrobatics!", Ability.DEXTERITY);
	static final Skill ANIMAL_HANDLING = new Skill("Animal Handling", "Train and handle animals", Ability.WISDOM);
	static final Skill ATHLETICS = new Skill("Ahtletics", "Jump and climb", Ability.STRENGTH);
	static final Skill HISTORY = new Skill("History", "Knowledge about the past", Ability.INTELLIGENCE);
	static final Skill INSIGHT = new Skill("Insight", "Knowing when people are lying", Ability.WISDOM);
	static final Skill INTIMIDATION = new Skill("Intimidation", "Coercing people to do what you want",
			Ability.CHARISMA);
	static final Skill NATURE = new Skill("Nature", "Understanding plants and beasts.", Ability.INTELLIGENCE);
	static final Skill PERCEPTION = new Skill("Perception", "Your awareness of your surroundings", Ability.WISDOM);
	static final Skill STEALTH = new Skill("Stealth", "Passing unseen.", Ability.DEXTERITY);
	static final Skill SURVIVAL = new Skill("Survival", "Your ability to travel in the wild", Ability.WISDOM);

	public Skill(String name, String desc, Ability ability) {
		super(name);
		this.desc = desc;
		this.ability = ability;
	}

	@Override
	public String toString() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

}
