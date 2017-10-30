package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Archetype extends Choice {
	public Archetype(String name) {
		super(name);
		features = new ArrayList<>();
	}

	private ArrayList<Feature> features;

	public void addFeature(Feature feature) {
		features.add(feature);
	}

	public ArrayList<Feature> getFeatures() {
		return features;
	}

	public Feature getFeature(int level) {
		return features.get(level);
	}

}
