package dnd5eCharacterGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Character {

	private String name;
	private int level;
	private String className;
	private String archName;
	private ArrayList<Skill> skillProfs;
	private ArrayList<Feature> charFeatures;
	private String raceName;

	private ArrayList<Feature> classFeatures;
	private ArrayList<Feature> raceFeatures;
	private ArrayList<Feature> archeFeatures;

	private Ability[] abilities;

	public ArrayList<Feature> getFeatures() {
		return charFeatures;
	}

	public ArrayList<Skill> getSkills() {
		return skillProfs;
	}

	private void featureList(ArrayList<Feature> features) {
		if (features != null) {
			boolean done = false;
			for (int i = 0; i < features.size() && !done; i++) {
				if (features.get(i).getLevel() <= level) {
					charFeatures.add(features.get(i));
					features.remove(i);
				} else {
					done = true;
				}
			}
		}
	}

	private void executeFeature(OptionFeature test) {
		ArrayList<Choice> choices = test.getChoices();
		if (choices.get(0).getClass().equals(Archetype.class)) {
			singleChoice(choices, "Archetype");
		}
	}

	private boolean xClose;

	private void singleChoice(ArrayList<Choice> choices, String choiceType) {
		ChoiceWindow chw = new ChoiceWindow(MainApp.stage, choiceType);
		chw.setChoices(choices);
		xClose = false;
		chw.setOnCloseRequest(event -> xClosed());
		chw.showAndWait();
		if (!xClose) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(String.format("%s Selected", choiceType));
			switch (choiceType) {
			case "Archetype":
				setArchetype(chw.getArch());
				alert.setContentText(String.format("You selected the %s archetype.", archName));
				break;
			case "Feature":

			}

			alert.setTitle("Archetype Selected");
			alert.showAndWait();
		}
	}

	private void xClosed() {
		xClose = true;
	}

	public String featuresToString() {
		String content = "";
		for (Feature f : charFeatures) {
			content += String.format("%s: %s%n", f.getName(), f.getDesc());
		}
		return content;
	}

	public void addSkill(Skill s) {
		skillProfs.add(s);
	}

	public Character(String name) {
		this.name = name;
		skillProfs = new ArrayList<>();
		charFeatures = new ArrayList<>();
		this.level = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCharClass(Class charClass) {
		this.classFeatures = charClass.getFeatures();
		className = charClass.getName();
		Collections.sort(classFeatures, (o1, o2) -> o1.getLevel() - o2.getLevel());
		System.out.println(classFeatures);
		featureList(classFeatures);
	}

	public int getLevel() {
		return level;
	}

	public void levelUp() {
		this.level++;
		featureList(classFeatures);
		featureList(raceFeatures);
		featureList(archeFeatures);
	}

	public String getArchName() {
		return archName;
	}

	public void setArchetype(Archetype archetype) {
		archeFeatures = archetype.getFeatures();
		archName = archetype.getName();
		featureList(archeFeatures);
	}

	public void setRace(Race race) {
		this.raceFeatures = race.getFeatures();
		this.raceName = race.getName();
		featureList(raceFeatures);
	}

	public String skillsToString() {
		String result = "";
		for (Skill s : skillProfs) {
			result += String.format("%s, ", s.getName());
		}
		return result;
	}

	public void resetSkills() {
		skillProfs.clear();
	}

	public ArrayList<Feature> getArcheFeatures() {
		return archeFeatures;
	}

	public ArrayList<Feature> getRaceFeatures() {
		return raceFeatures;
	}

	public ArrayList<Feature> getClassFeatures() {
		return classFeatures;
	}

	public String getRaceName() {
		return raceName;
	}

	public String getClassName() {
		return className;
	}

}
