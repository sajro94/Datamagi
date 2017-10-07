package opg5_d;

public class Copier {
	private int paper;

	public int getPater() {
		return this.paper;
	}

	public void insertPaper(int p) {
		if (this.paper + p <= 500) {
			this.paper += p;
			System.out.println("Inserted " + p + " pieces of paper!");
			System.out.println("Now contains " + this.paper + " pieces of paper!");
		} else {
			int ex = p + this.paper - 500;
			System.out.println("You tried to insert " + ex + " pieces of paper too much!");
		}
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
