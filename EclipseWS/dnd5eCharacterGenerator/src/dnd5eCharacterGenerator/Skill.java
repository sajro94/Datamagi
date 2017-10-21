package dnd5eCharacterGenerator;

public class Skill {
	private String name;
	private String desc;
	private Ability ability;

	public Skill(String name, String desc, Ability ability) {
		this.name = name;
		this.desc = desc;
		this.ability = ability;
	}

	public String getName() {
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
