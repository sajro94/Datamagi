package dnd5eCharacterGenerator;

public class HeavyArmor extends Armor {

	public HeavyArmor(String name, int baseAc) {
		super(name, baseAc);
	}

	@Override
	public int getActualAC() {
		return baseAC;
	}

}
