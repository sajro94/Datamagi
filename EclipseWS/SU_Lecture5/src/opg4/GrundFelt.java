package opg4;

public class GrundFelt extends Felt {
	private int værdi;
	private int leje;
	private Spiller ejer;

	public void køb(Spiller S) {
		if (S.getKapital() >= this.værdi && this.ejer == null) {
			this.ejer = S;
			S.removeMoney(this.værdi);
		}
	}

	public void betal(Spiller S) {
		if (S.getKapital() >= this.getLeje()) {
			S.removeMoney(this.getLeje());
			this.ejer.addMoney(this.getLeje());
		}
	}

	public GrundFelt(String navn, int værdi, int leje) {
		super(navn);
		this.værdi = værdi;
		this.setLeje(leje);
	}

	public int getLeje() {
		return leje;
	}

	public void setLeje(int leje) {
		this.leje = leje;
	}

}
