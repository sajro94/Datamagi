package dnd5eCharacterGenerator;

public class MediumArmor extends Armor {

	public MediumArmor(String name, int baseAc) {
		super(name, baseAc);
	}

	public int getActualAC(int dex, boolean feat) {
		int max = 2;
		if (feat) {
			max = 3;
		}
		if (dex > max) {
			dex = max;
		}
		return baseAC + dex;
	}

}
