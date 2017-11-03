package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Race extends Choice {
	ArrayList<Feature> features;
	ArrayList<Ability> ABSI;
	String name;
	ArrayList<Runnable> statChangers;

	public Race(String name) {
		super(name);
		this.features = new ArrayList<>();
		this.ABSI = new ArrayList<>();
		statChangers = new ArrayList<>();
	}

	public ArrayList<Ability> getAbsi() {
		return this.ABSI;
	}

	public void addFeature(Feature f) {
		this.features.add(f);
	}

	public ArrayList<Feature> getFeatures() {
		return this.features;
	}

	public void addAbsi(Ability ability) {
		ABSI.add(ability);

	}
}
