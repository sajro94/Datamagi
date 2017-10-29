package dnd5eCharacterGenerator;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Character {

	private String name;
	private int level;
	private Race race;
	private Class charClass;
	private Archetype archetype;
	private ArrayList<Skill> skills;
	private ArrayList<Feature> features;
	private ArrayList<Feature> doneFeatures;

	public ArrayList<Feature> getFeatures() {
		return features;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	private ArrayList<Feature> featureList() {
		ArrayList<Feature> result = new ArrayList<>();

		ArrayList<Feature> collective = new ArrayList<>();
		collective.addAll(race != null ? race.getFeatures() : new ArrayList<Feature>());
		collective.addAll(charClass != null ? charClass.getFeatures() : new ArrayList<Feature>());
		collective.addAll(archetype != null ? archetype.getFeatures() : new ArrayList<Feature>());
		collective.sort((o1, o2) -> o1.getLevel() - o2.getLevel());
		for (Feature f : collective) {
			if (f.getLevel() <= level) {
				if (f.getImprovement() != null && f.getImprovement().getLevel() <= level) {
					Feature test = f.getImprovement();
					while (test.getImprovement() != null && test.getImprovement().getLevel() <= level) {
						test = test.getImprovement();
					}
					if (test.getClass().equals(OptionFeature.class)) {
						OptionFeature ofTest = (OptionFeature) test;
						if (!doneFeatures.contains(ofTest)) {
							doneFeatures.add(ofTest);
							executeFeature(ofTest);
						}
					}
					result.add(test);
				} else {
					if (f.getClass().equals(OptionFeature.class)) {
						OptionFeature ofTest = (OptionFeature) f;
						if (!doneFeatures.contains(ofTest)) {
							doneFeatures.add(ofTest);
							executeFeature(ofTest);
						}
					}
					result.add(f);
				}
			}
		}
		return result;
	}

	private void executeFeature(OptionFeature test) {
		ArrayList<Choice> choices = test.getChoices();
		if (choices.get(0).getClass().equals(Archetype.class)) {
			System.out.println("Archetype Feature!");
			ChoiceWindow chw = new ChoiceWindow(MainApp.stage, "Archetype Feature");
			chw.setChoices(choices);
			chw.showAndWait();
			setArchetype(chw.getArch());
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Archetype Selected");
			alert.setContentText(String.format("You selected the %s archetype.", archetype.getName()));
			alert.setTitle("Archetype Selected");
			alert.showAndWait();
		}
		features = featureList();
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
		features = new ArrayList<>();
		this.level = 0;
		doneFeatures = new ArrayList<>();
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
		features = featureList();
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

	public void resetSkills() {
		skills.clear();
	}

}
