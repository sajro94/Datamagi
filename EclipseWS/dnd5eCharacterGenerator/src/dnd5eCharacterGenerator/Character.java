package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Character {

	private String name;
	private Class charClass;
	private Archetype archetype;
	private int level;

	private ArrayList<Feature> featureList() {
		ArrayList<Feature> result = new ArrayList<>();
		for (Feature f : charClass.getFeatures()) {
			if (f.getLevel() <= level) {
				if (f.getImprovement() != null && f.getImprovement().getLevel() <= level) {
					Feature test = f.getImprovement();
					while (test.getImprovement() != null && test.getImprovement().getLevel() <= level) {
						test = test.getImprovement();
					}
					result.add(test);
				} else {
					result.add(f);
				}
			}
		}
		return result;
	}

	public String featuresToString() {
		String content = "";
		for (Feature f : featureList()) {
			content += String.format("%s: %s%n", f.getName(), f.getDesc());
		}
		return content;
	}

	public Character(String name) {
		this.name = name;
		setLevel(1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class getCharClass() {
		return charClass;
	}

	public void setCharClass(Class charClass) {
		this.charClass = charClass;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
