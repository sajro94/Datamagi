package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class OptionFeature extends Feature {

	private ArrayList<Choice> choices;
	private boolean chosen;

	public OptionFeature(String name, String desc, int level) {
		super(name, desc, level);
		choices = new ArrayList<>();
		chosen = false;
	}

	public boolean hasBeenChosen() {
		return chosen;
	}

	public void setToChosen() {
		chosen = true;
	}

	public ArrayList<Choice> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<Choice> choices) {
		this.choices = choices;
	}

}
