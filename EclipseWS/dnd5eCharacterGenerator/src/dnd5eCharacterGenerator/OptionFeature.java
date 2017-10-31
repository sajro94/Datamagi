package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class OptionFeature extends Feature {

	private ArrayList<Choice> choices;
	private boolean chosen;
	private boolean multi;
	private int limit;

	public OptionFeature(String name, String desc, int level, boolean multi) {
		super(name, desc, level);
		choices = new ArrayList<>();
		chosen = false;
		setMulti(multi);
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

	public boolean isMulti() {
		return multi;
	}

	public void setMulti(boolean multi) {
		this.multi = multi;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
