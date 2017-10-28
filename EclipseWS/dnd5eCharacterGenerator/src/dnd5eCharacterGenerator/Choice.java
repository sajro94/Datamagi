package dnd5eCharacterGenerator;

public class Choice {
	protected String name;

	public Choice(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
}
