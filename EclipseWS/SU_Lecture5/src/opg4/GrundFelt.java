package opg4;

public class GrundFelt extends Felt {
	private int v�rdi;
	private int leje;
	private Spiller ejer;

	public void k�b(Spiller S) {
		if (S.getKapital() >= this.v�rdi && this.ejer == null) {
			this.ejer = S;
			S.removeMoney(this.v�rdi);
		}
	}

	public void betal(Spiller S) {
		if (S.getKapital() >= this.getLeje()) {
			S.removeMoney(this.getLeje());
			this.ejer.addMoney(this.getLeje());
		}
	}

	public GrundFelt(String navn, int v�rdi, int leje) {
		super(navn);
		this.v�rdi = v�rdi;
		this.setLeje(leje);
	}

	public int getLeje() {
		return leje;
	}

	public void setLeje(int leje) {
		this.leje = leje;
	}

}
