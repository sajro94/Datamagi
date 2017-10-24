package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Race {
	ArrayList<Feature> features;
	ArrayList<Pair<Ability, Integer>> ABSI;
	String name;

	public Race(String name) {
		this.features = new ArrayList<>();
		this.ABSI = new ArrayList<>();
		this.name = name;
	}

	public void addAbsi(Ability abi, int mod) {
		Pair<Ability, Integer> p = new Pair<>(abi, mod);
		ABSI.add(p);
	}

	public ArrayList<Pair<Ability, Integer>> getAbsi() {
		return this.ABSI;
	}

	public String getName() {
		return this.name;
	}

	public void addFeature(Feature f) {
		this.features.add(f);
	}

	public ArrayList<Feature> getFeatures() {
		return this.features;
	}
}
