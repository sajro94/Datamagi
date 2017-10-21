package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Archetype {
	private String name;
	private ArrayList<Feature> features;

	public Archetype(String name) {
		features = new ArrayList<>();
		this.name = name;
	}

	public void addFeature(Feature feature) {
		features.add(feature);
	}

	public ArrayList<Feature> getFeatures() {
		return features;
	}

	public Feature getFeature(int level) {
		return features.get(level);
	}

	public String getName() {
		return name;
	}

}
