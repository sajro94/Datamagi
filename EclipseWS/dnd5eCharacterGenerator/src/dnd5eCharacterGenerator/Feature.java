package dnd5eCharacterGenerator;

public class Feature extends Choice {
	private String desc;
	private String fullDesc;
	private Feature improvement;
	private int level;

	public Feature(String name, String desc, int level) {
		super(name);
		this.desc = desc;
		this.level = level;
		setFullDesc("");
	}

	@Override
	public String toString() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	@Override
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

	public Feature getImprovement() {
		return improvement;
	}

	public void setImprovement(Feature improvement) {
		this.improvement = improvement;
	}

	public String getFullDesc() {
		if (!fullDesc.equals("")) {
			return fullDesc;
		} else if (level > 0) {
			return String.format("%s%nLevel: %s%n%n%s", name, level, desc);
		} else {
			return String.format("%s%nRacial%n%n%s", name, desc);
		}
	}

	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}

}
