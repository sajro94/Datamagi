package dnd5eCharacterGenerator;

public abstract class Armor extends Item {
	protected int baseAC;

	public Armor(String name, int baseAc) {
		super(name);
		this.baseAC = baseAc;
	}

	public int getActualAC() {
		return baseAC;
	}
}
