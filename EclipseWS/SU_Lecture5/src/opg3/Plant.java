package opg3;

import java.util.Date;

public class Plant {
	private String name;
	private String genus;
	private String latinName;
	private Date seedDate;

	public String getName() {
		return this.name;
	}

	public String getGenus() {
		return this.genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getLatinName() {
		return this.latinName;
	}

	public void setLatinName(String ln) {
		this.latinName = ln;
	}

	public Date getSeedDate() {
		return this.seedDate;
	}

	public Plant(String name, String genus, String latinName) {
		this.name = name;
		this.genus = genus;
		this.latinName = latinName;
		this.seedDate = new Date();
	}
}
