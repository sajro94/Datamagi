package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Class {
	private String name;
	private ArrayList<Archetype> archetypes;
	private Die hitdie;
	private ArrayList<Skill> skillList;
	private ArrayList<Weapon> weaponProfs;
	private ArrayList<Armor> armorProfs;
	private ArrayList<Prof> otherProfs;
	private Ability[] savingThrows;
	private ArrayList<Equipment> equipment;
	private ArrayList<Feature> features;
	private int skills;

	public Class(String name, Die hitdie, Ability savingThrow1, Ability savingThrow2, int skills) {
		this.name = name;
		this.archetypes = new ArrayList<>();
		this.hitdie = hitdie;
		this.skillList = new ArrayList<>();
		this.weaponProfs = new ArrayList<>();
		this.armorProfs = new ArrayList<>();
		this.otherProfs = new ArrayList<>();
		this.savingThrows = new Ability[2];
		this.savingThrows[0] = savingThrow1;
		this.savingThrows[1] = savingThrow2;
		this.equipment = new ArrayList<>();
		this.features = new ArrayList<>();
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Archetype> getArchetypes() {
		return archetypes;
	}

	public Die getHitDie() {
		return hitdie;
	}

	public ArrayList<Skill> getSkillList() {
		return skillList;
	}

	public ArrayList<Weapon> getWeaponProfs() {
		return weaponProfs;
	}

	public ArrayList<Armor> getArmorProfs() {
		return armorProfs;
	}

	public ArrayList<Prof> getOtherProfs() {
		return otherProfs;
	}

	public Ability[] getSavingThrows() {
		return savingThrows;
	}

	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}

	public void addFeature(Feature f) {
		features.add(f);
	}

	public ArrayList<Feature> getFeatures() {
		return features;
	}

	public void addArchetype(Archetype a) {
		archetypes.add(a);
	}

	public void addSkill(Skill s) {
		skillList.add(s);
	}

	public void addWeapon(Weapon w) {
		weaponProfs.add(w);
	}

	public void addArmor(Armor a) {
		armorProfs.add(a);
	}

	public void addProf(Prof p) {
		otherProfs.add(p);
	}

	public void addEquipment(Equipment e) {
		equipment.add(e);
	}
}
