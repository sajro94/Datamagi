package dnd5eCharacterGenerator;

public class LightArmor extends Armor {

	public LightArmor(String name, int baseAc) {
		super(name, baseAc);
	}

	public int getActualAC(int dex) {
		return baseAC + dex;
	}

}
