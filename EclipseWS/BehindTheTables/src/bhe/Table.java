package bhe;

public class Table {

	private String link;
	private String name;

	public Table(String link, String name) {
		setLink(link);
		setName(name);
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
