package randomRace;

import java.util.ArrayList;

public class Race {
	private ArrayList<RacialFeature> features;
	private String name;

	public Race(String name) {
		setName(name);
		setFeatures(new ArrayList<>());
	}

	public void addFeature(RacialFeature rf) {
		this.features.add(rf);
	}

	public ArrayList<RacialFeature> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<RacialFeature> features) {
		this.features = features;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
