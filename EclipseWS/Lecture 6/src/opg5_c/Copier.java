package opg5_c;

public class Copier {
	private int paper;

	public int getPater() {
		return this.paper;
	}

	public void insertPaper(int p) {
		this.paper += p;
	}

	public Copier() {

	}

	public void makeCopy() {
		if (this.paper > 0) {
			this.paper--;
			System.out.println("Succesful copy!");
		} else {
			System.out.println("Please insert more paper into the copier!");
		}
	}
}
