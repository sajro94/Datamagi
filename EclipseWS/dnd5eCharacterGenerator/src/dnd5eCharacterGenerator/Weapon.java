package dnd5eCharacterGenerator;

public class Weapon extends Item {

	private Die dmgDie;
	private int dies;
	private String dmgType;

	public Weapon(String name, Die die, int dies, String dmgType) {
		super(name);
		this.dmgDie = die;
		this.dies = dies;
		this.dmgType = dmgType;
	}

	public Die getDmgDie() {
		return dmgDie;
	}

	public void setDmgDie(Die dmgDie) {
		this.dmgDie = dmgDie;
	}

	public int getDies() {
		return dies;
	}

	public void setDies(int dies) {
		this.dies = dies;
	}

	public String getDmgType() {
		return dmgType;
	}

	public void setDmgType(String dmgType) {
		this.dmgType = dmgType;
	}

}
