package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Equipment {
	private ArrayList<Item> choices;

	public Equipment(Item choice) {
		choices = new ArrayList<>();
		choices.add(choice);
	}

	public void addChoice(Item choice) {
		choices.add(choice);
	}

	public ArrayList<Item> getChoices() {
		return choices;
	}
}
