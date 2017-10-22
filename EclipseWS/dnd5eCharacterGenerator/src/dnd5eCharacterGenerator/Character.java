package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Character {

	private String name;
	private int level;
	private Race race;
	private Class charClass;
	private Archetype archetype;
	private ArrayList<Skill> skills;

	private ArrayList<Feature> featureList() {
		ArrayList<Feature> result = new ArrayList<>();

		ArrayList<Feature> collective = new ArrayList<>();
		collective.addAll(race.getFeatures());
		collective.addAll(charClass.getFeatures());
		collective.addAll(archetype.getFeatures());
		collective.sort((o1, o2) -> o1.getLevel() - o2.getLevel());
		for (Feature f : collective) {
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

	public void addSkill(Skill s) {
		skills.add(s);
	}

	public Character(String name) {
		this.name = name;
		skills = new ArrayList<>();
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

	public Archetype getArchetype() {
		return archetype;
	}

	public void setArchetype(Archetype archetype) {
		this.archetype = archetype;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String skillsToString() {
		String result = "";
		for (Skill s : skills) {
			result += String.format("%s, ", s.getName());
		}
		return result;
	}

}
