package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Database {
	private ArrayList<Class> classes;
	private ArrayList<Race> races;

	public Database() {
		classes = new ArrayList<>();
		races = new ArrayList<>();
	}

	public ArrayList<Class> getClasses() {
		return classes;
	}

	public void addClass(Class c) {
		classes.add(c);
	}

	public void addRace(Race r) {
		races.add(r);
	}

	public ArrayList<Race> getRaces() {
		return races;
	}

}
