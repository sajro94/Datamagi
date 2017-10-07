package opg2;

public class Konto {
	private int nr;
	private int saldo;
	private String kontotype;

	public int getNr() {
		return this.nr;
	}

	public int getSaldo() {
		return this.saldo;
	}

	public String getKontoType() {
		return this.kontotype;
	}

	public void setKontoType(String type) {
		this.kontotype = type;
	}

	public void indsætBeløb(int amount) {
		this.saldo += amount;
		System.out.printf("Indsætter %d krone%s\n", amount, amount > 1 ? "r" : "");
	}

	public Konto(String konto, int nr) {
		this.kontotype = konto;
		this.nr = nr;
		this.saldo = 0;
	}

}
