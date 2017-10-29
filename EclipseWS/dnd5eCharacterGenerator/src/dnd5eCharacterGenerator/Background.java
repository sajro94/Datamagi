package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Background extends Choice {
	private ArrayList<Skill> skills;
	private ArrayList<Prof> tools;
	private ArrayList<Item> equipment;
	private ArrayList<Prof> languages;
	private Feature feature;
	private ArrayList<String> traits;
	private ArrayList<String> ideals;
	private ArrayList<String> bonds;
	private ArrayList<String> flaws;

	public Background(String name, ArrayList<Skill> skills, ArrayList<Prof> profs, ArrayList<Item> equipment,
			ArrayList<Prof> languages, Feature feature, ArrayList<String> traits, ArrayList<String> ideals,
			ArrayList<String> bonds, ArrayList<String> flaws) {
		super(name);
		setSkills(skills);
		setProfs(profs);
		setEquipment(equipment);
		setLanguages(languages);
		setFeature(feature);
		setTraits(traits);
		setIdeals(ideals);
		setBonds(bonds);
		setFlaws(flaws);

	}

	public ArrayList<Prof> getProfs() {
		return tools;
	}

	public void setProfs(ArrayList<Prof> profs) {
		this.tools = profs;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}

	public ArrayList<Item> getEquipment() {
		return equipment;
	}

	public void setEquipment(ArrayList<Item> equipment) {
		this.equipment = equipment;
	}

	public ArrayList<Prof> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<Prof> languages) {
		this.languages = languages;
	}

	public ArrayList<String> getFlaws() {
		return flaws;
	}

	public void setFlaws(ArrayList<String> flaws) {
		this.flaws = flaws;
	}

	public ArrayList<String> getBonds() {
		return bonds;
	}

	public void setBonds(ArrayList<String> bonds) {
		this.bonds = bonds;
	}

	public ArrayList<String> getIdeals() {
		return ideals;
	}

	public void setIdeals(ArrayList<String> ideals) {
		this.ideals = ideals;
	}

	public ArrayList<String> getTraits() {
		return traits;
	}

	public void setTraits(ArrayList<String> traits) {
		this.traits = traits;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}
}
