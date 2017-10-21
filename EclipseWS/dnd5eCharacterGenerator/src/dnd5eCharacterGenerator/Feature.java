package dnd5eCharacterGenerator;

public class Feature {
	private String name;
	private String desc;
	private Feature improvement;
	private int level;

	public Feature(String name, String desc, int level) {
		this.desc = desc;
		this.name = name;
		this.level = level;
	}

	public int getLevel() {
		return level;
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

	public Feature getImprovement() {
		return improvement;
	}

	public void setImprovement(Feature improvement) {
		this.improvement = improvement;
	}

}
