package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Database {
	private ArrayList<Class> classes;
	private ArrayList<Race> races;

	public Database() {
		classes = new ArrayList<>();
		races = new ArrayList<>();
		createClasses();
		createRaces();
	}

	public ArrayList<Class> getClasses() {
		return classes;
	}

	public void addClass(Class c) {
		classes.add(c);
	}

	public void addRace(Race r) {
		races.add(r);
	}

	public ArrayList<Race> getRaces() {
		return races;
	}

	private void createClasses() {
		Class c1 = new Class("Vighter", Die.D10, Ability.STRENGTH, Ability.DEXTERITY, 2);
		OptionFeature f1 = new OptionFeature("Fighting Style", "", 1, false);
		Feature f1o1 = new Feature("Archery", "+2 attack when making an attack with a ranged weapon.", 1);
		Feature f1o2 = new Feature("Defense", "+1 armor class while wearing armor", 1);
		Feature f1o3 = new Feature("Dueling",
				"+2 damage when hitting with a melee weapon wielded in one hand, and you have no weapon in the other hand.",
				1);
		Feature f1o4 = new Feature("Great Weapons Fighting",
				"When you deal damage with a melee weapon, you wield in two hands, you can reroll 1's and 2's, the weapon must have the two-handed or versatile property",
				1);
		Feature f1o5 = new Feature("Protection",
				"While wielding a shield you can as a reaction grant disadvantage on an attack roll against an ally within 5 feet.",
				1);
		Feature f1o6 = new Feature("Two-Weapon Fighting",
				"When dual wielding you can add your ability modifier to the damage of the off hand attack.", 1);
		ArrayList<Choice> fiStl = new ArrayList<>();
		fiStl.add(f1o1);
		fiStl.add(f1o2);
		fiStl.add(f1o3);
		fiStl.add(f1o4);
		fiStl.add(f1o5);
		fiStl.add(f1o6);
		f1.setChoices(fiStl);

		Feature f2 = new Feature("Second Wind", "Use a bonus action to heal for 1d10+Vighter Level hp", 1);
		Feature f3 = new Feature("Maneuvers",
				"Your learn two maneuvers, plus one additional at 3rd, 7th, 10th, 15th, 18th", 2);
		Feature f4 = new Feature("Action Surge", "Gain the use of an extra Action and possible Bonus Action", 2);
		OptionFeature f5 = new OptionFeature("Martial Archetype", "Choose your archetype", 3, false);
		Feature f6 = new Feature("ABSI", "Gain +1 to two stats, +2 to one stat, or a feat", 4);
		Feature f7 = new Feature("ABSI", "Gain +1 to two stats, +2 to one stat, or a feat", 8);
		Feature f8 = new Feature("ABSI", "Gain +1 to two stats, +2 to one stat, or a feat", 12);
		Feature f9 = new Feature("ABSI", "Gain +1 to two stats, +2 to one stat, or a feat", 16);
		Feature f10 = new Feature("ABSI", "Gain +1 to two stats, +2 to one stat, or a feat", 19);
		Feature f11 = new Feature("Extra Attack",
				"When you use your Attack action you may attack twice rather than once.", 5);
		Feature f12 = new Feature("Extra Attack",
				"When you use your Attack action you may attack three times rather than once.", 11);
		Feature f13 = new Feature("Extra Attack",
				"When you use your Attack action you may attack four times rather than once.", 20);
		Feature f14 = new Feature("Indomitable", "You can reroll a saving throw once per long rest.", 9);
		Feature f15 = new Feature("Indomitable", "You can reroll a saving throw twice per long rest.", 13);
		Feature f16 = new Feature("Indomitable", "You can reroll a saving throw three times per long rest.", 17);
		f11.setImprovement(f12);
		f12.setImprovement(f13);
		f14.setImprovement(f15);
		f15.setImprovement(f16);

		c1.addFeature(f1);
		c1.addFeature(f2);
		c1.addFeature(f3);
		c1.addFeature(f4);
		c1.addFeature(f6);
		c1.addFeature(f7);
		c1.addFeature(f8);
		c1.addFeature(f9);
		c1.addFeature(f10);
		c1.addFeature(f11);
		c1.addFeature(f14);

		Archetype a1 = new Archetype("Survivalist");
		Feature af1 = new Feature("Ranger of the Wild",
				"Choose three of the following options:\nForager\nStrider\nTracker\nTrapper\nTrainer\nTraveler", 3);
		Feature af2 = new Feature("Hunter's Quarry", "You can mark a target to deal extra damage on attacks", 3);
		Feature af3 = new Feature("Wilderness Guide", "You can travel in the wild better than anyone", 7);
		Feature af4 = new Feature("Hide in Plain Sight", "You can hide even when not completely hidden", 10);
		Feature af5 = new Feature("Stand Against the Tide", "You can grant disadvantage on some attacks", 15);
		Feature af6 = new Feature("Sicth Sense", "You can fight against hidden and even invisible creatures", 18);
		a1.addFeature(af1);
		a1.addFeature(af2);
		a1.addFeature(af3);
		a1.addFeature(af4);
		a1.addFeature(af5);
		a1.addFeature(af6);

		c1.addArchetype(a1);
		ArrayList<Choice> artps = new ArrayList<>();
		artps.add(a1);
		f5.setChoices(artps);
		c1.addFeature(f5);

		Skill s1 = Skill.ACROBATICS;
		Skill s2 = Skill.ANIMAL_HANDLING;
		Skill s3 = Skill.ATHLETICS;
		Skill s4 = Skill.HISTORY;
		Skill s5 = Skill.INSIGHT;
		Skill s6 = Skill.INTIMIDATION;
		Skill s7 = Skill.PERCEPTION;
		Skill s8 = Skill.SURVIVAL;

		c1.addSkill(s1);
		c1.addSkill(s2);
		c1.addSkill(s3);
		c1.addSkill(s4);
		c1.addSkill(s5);
		c1.addSkill(s6);
		c1.addSkill(s7);
		c1.addSkill(s8);

		addClass(c1);
	}

	private void createRaces() {
		Race r1 = new Race("Lizardfolk");
		Feature rf1 = new Feature("Bite",
				"Your fanged maw is a natural weapon which you are proficient with. It deals 1d6 points of piercing damage.",
				0);
		Feature rf2 = new Feature("Cunning Artisan",
				"During a short rest you can create simple equipment from dead creatures.", 0);
		Feature rf3 = new Feature("Hold Breath", "You can hold your breath for 15 minutes.", 0);
		OptionFeature orf4 = new OptionFeature("Hunters Lore",
				"You are proficient in two of: Animal Handling, Nature, Perception, Stealth or Survival", 0, true);
		Skill orf4s1 = Skill.ANIMAL_HANDLING;
		Skill orf4s2 = Skill.NATURE;
		Skill orf4s3 = Skill.PERCEPTION;
		Skill orf4s4 = Skill.STEALTH;
		Skill orf4s5 = Skill.SURVIVAL;
		ArrayList<Choice> orf4skls = new ArrayList<>();
		orf4skls.add(orf4s1);
		orf4skls.add(orf4s2);
		orf4skls.add(orf4s3);
		orf4skls.add(orf4s4);
		orf4skls.add(orf4s5);
		orf4.setChoices(orf4skls);
		orf4.setLimit(2);
		Feature rf5 = new Feature("Natural Amor(13+Dex)", "You have a natural armor of 13 + your Dexterity modifier.",
				0);
		Feature rf6 = new Feature("Hungry Jaws",
				"Once per short rest you can as a bonus action make an attack with your bite, and gain temporary hitpoints equal to your Constitution modifier.",
				0);
		Feature rf7 = new Feature("Languages", "You speak, read and write Common and Draconic", 0);

		r1.addFeature(rf1);
		r1.addFeature(rf2);
		r1.addFeature(rf3);
		r1.addFeature(orf4);
		r1.addFeature(rf5);
		r1.addFeature(rf6);
		r1.addFeature(rf7);

		r1.addAbsi(Ability.CONSTITUTION, 2);
		r1.addAbsi(Ability.WISDOM, 1);

		addRace(r1);
	}
}
