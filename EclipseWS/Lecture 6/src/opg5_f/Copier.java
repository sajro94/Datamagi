package opg5_f;

public class Copier {
	private int paper;
	private boolean paperStuck;

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

	public void makePaperJam() {
		this.paperStuck = true;
	}

	public void makeCopy(int c) {
		if (this.paper - c >= 0) {
			this.paper--;
			System.out.println("Succesful copy!");
		} else {
			int ms = (this.paper - c) * -1;
			System.out.println(
					"Please insert more paper into the copier!\nYou need to insert " + ms + " pieces of paper!");
		}
	}
}
