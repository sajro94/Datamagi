package opg5_g;

public class Main {

	public static void main(String[] args) {
		Copier cp = new Copier();
		cp.makeCopy(2);
		cp.insertPaper(480);
		cp.makePaperJam();
		cp.makeCopy(6);
		cp.insertPaper(50);
	}

}
