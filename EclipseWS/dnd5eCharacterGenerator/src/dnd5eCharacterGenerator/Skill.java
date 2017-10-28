package dnd5eCharacterGenerator;

public class Skill extends Choice {
	private String desc;
	private Ability ability;

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
