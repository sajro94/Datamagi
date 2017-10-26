package dnd5eCharacterGenerator;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javafx.scene.Parent;

public class Race {
	ArrayList<Feature> features;
	ArrayList<Pair<Ability, Integer>> ABSI;
	String name;
	ArrayList<Runnable> statChangers;

	public Race(String name) {
		this.features = new ArrayList<>();
		this.ABSI = new ArrayList<>();
		this.name = name;
		statChangers = new ArrayList<>();
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
