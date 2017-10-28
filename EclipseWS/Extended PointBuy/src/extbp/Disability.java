package extbp;

public class Disability {
	private String name;
	private int value;
	private String desc;

	public Disability(String name, int value, String desc) {
		setName(name);
		setValue(value);
		setDesc(desc);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.format("%-28s| %s", name, value < 0 ? "+?" : "+" + value);
	}
}
