package opg4;

import java.util.Random;

public class Spiller {
	private int kapital;
	private String navn;
	private int feltNummer;

	public int getKapital() {
		return this.kapital;
	}

	public String getNavn() {
		return this.navn;
	}

	public int getFeltNummer() {
		return this.feltNummer;
	}

	public void addMoney(int a) {
		this.kapital += a;
	}

	public void removeMoney(int a) {
		this.kapital -= a;
	}

	public void move() {
		Random rand = new Random();
		int num = rand.nextInt(5) + rand.nextInt(5) + 2;
		this.feltNummer += num;
	}

	public Spiller(String navn) {
		this.navn = navn;
		this.kapital = 20000;
		this.feltNummer = 0;
	}
}
