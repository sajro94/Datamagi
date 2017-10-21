package dnd5eCharacterGenerator;

import java.util.ArrayList;

public class Database {
	private ArrayList<Class> classes;

	public Database() {
		classes = new ArrayList<>();
	}

	public ArrayList<Class> getClasses() {
		return classes;
	}

	public void addClass(Class c) {
		classes.add(c);
	}

}
