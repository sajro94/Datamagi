package dnd5eCharacterGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionFeature extends Feature {

	public static final OptionFeature ABSI = new OptionFeature("Ability Score Increase",
			"Increase one ability score by two, or two ability scores by 1", 2, true, Arrays.asList(Ability.ABILITIES));

	private ArrayList<Choice> choices;
	private boolean chosen;
	private boolean multi;
	private int limit;

	public OptionFeature(OptionFeature another) {
		super(another.name, another.getDesc(), another.getLevel());
		this.choices = new ArrayList<>(another.getChoices());
		this.chosen = another.chosen;
		this.multi = another.multi;
		this.limit = another.limit;
	}

	public OptionFeature(String name, String desc, int level, boolean multi) {
		super(name, desc, level);
		choices = new ArrayList<>();
		chosen = false;
		setMulti(multi);
	}

	public OptionFeature(String name, String desc, int limit, boolean multi, List<Choice> list) {
		super(name, desc, 0);
		choices = new ArrayList<>();
		choices.addAll(list);
		chosen = false;
		setMulti(multi);
		setLimit(limit);
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
