package opg2;

public class Person {
	private String name;
	private String title;
	private boolean senior;

	public Person(String name, String title, boolean senior) {
		setName(name);
		setTitle(title);
		setSenior(senior);
	}

	public boolean isSenior() {
		return senior;
	}

	public void setSenior(boolean senior) {
		this.senior = senior;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", title, name, senior ? "(senior)" : "");
	}

}
