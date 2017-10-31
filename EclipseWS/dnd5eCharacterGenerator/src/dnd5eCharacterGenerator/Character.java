package dnd5eCharacterGenerator;

import java.util.ArrayList;
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

	@SuppressWarnings("unused")
	private Ability[] abilities;

	public Character(String name) {
		this.name = name;
		skillProfs = new ArrayList<>();
		charFeatures = new ArrayList<>();
		this.level = 1;
		abilities = new Ability[] { Ability.STRENGTH, Ability.DEXTERITY, Ability.CONSTITUTION, Ability.INTELLIGENCE,
				Ability.WISDOM, Ability.CHARISMA };
	}

	public ArrayList<Feature> getFeatures() {
		return charFeatures;
	}

	public ArrayList<Skill> getSkills() {
		return skillProfs;
	}

	private void featureList(ArrayList<Feature> features) {
		if (features != null) {
			while (features.size() != 0 && features.get(0).getLevel() <= level) {
				if (features.get(0).getClass().equals(OptionFeature.class)) {
					executeFeature((OptionFeature) features.get(0));
				}
				charFeatures.add(features.get(0));
				features.remove(0);

			}
		}
	}

	private void executeFeature(OptionFeature test) {
		ArrayList<Choice> choices = test.getChoices();
		if (choices.get(0).getClass().equals(Archetype.class)) {
			makeChoices(choices, "Archetype", test.isMulti(), test.getName(), test.getLimit());
		} else if (choices.get(0).getClass().equals(Skill.class)) {
			makeChoices(choices, "Skill", test.isMulti(), test.getName(), test.getLimit());
		} else if (choices.get(0).getClass().equals(Feature.class)) {
			makeChoices(choices, "Feature", test.isMulti(), test.getName(), test.getLimit());
		}
	}

	private boolean xClose = true;

	private void makeChoices(ArrayList<Choice> choices, String choiceType, boolean multi, String parentFeature,
			int limit) {
		xClose = true;
		while (xClose) {
			ChoiceWindow chw = new ChoiceWindow(MainApp.stage, choiceType);
			chw.setMulti(multi);
			chw.setChoices(choices);
			chw.setLimit(limit);
			xClose = false;
			chw.setOnCloseRequest(event -> xClosed());
			chw.showAndWait();
			if (!xClose) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(String.format("%s%s Selected", choiceType, multi ? "s" : ""));
				switch (choiceType) {
				case "Archetype":
					setArchetype(chw.getArch());
					alert.setContentText(String.format("You selected the %s archetype.", archName));
					break;
				case "Feature":
					Feature temp = chw.getFeature();
					alert.setContentText(String.format("You selected the %s feature", temp.getName()));
					temp.setName(parentFeature + ": " + temp.getName());
					charFeatures.add(temp);
					break;
				case "Skill":
					for (Skill s : chw.getSkills()) {
						addSkill(s);
					}
					alert.setContentText(
							String.format("You selected the %s skill%s", chw.getSkills(), multi ? "s" : ""));
					break;

				}
				alert.showAndWait();

			} else {
				xClose = true;
			}
		}
	}

	private void xClosed() {
		xClose = true;
	}

	private void chooseClassSkills(ArrayList<Skill> input, int limit) {
		ChoiceWindow skillChs = new ChoiceWindow(MainApp.stage, "");
		ArrayList<Choice> choices = new ArrayList<>();
		for (Skill s : input) {
			choices.add(s);
		}
		skillChs.setChoices(choices);
		skillChs.setMulti(true);
		skillChs.setLimit(limit);
		skillChs.showAndWait();
		for (Skill s : skillChs.getSkills()) {
			addSkill(s);
		}
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
		chooseClassSkills(charClass.getSkillList(), charClass.getSkills());
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
