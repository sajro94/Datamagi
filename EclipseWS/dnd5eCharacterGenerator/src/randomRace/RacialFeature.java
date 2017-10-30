package randomRace;

public class RacialFeature {
	private String name; // The Features name.
	private String desc; // A short description of the feature
	private String full; // The full description of the feature
	private String type; // This is used when multiple features might need to override each other
	private int power; // This is uses to determine which feature is the "strongest" feature when
	// overriding
	private int rp; // The cost of the feature in RP

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFull() {
		return full;
	}

	public void setFull(String full) {
		this.full = full;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

}
