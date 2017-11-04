package statGenerator;

public class MainApp {

	public static void main(String[] args) {
		Generator g = new StandardCardGen();
		g.generate();
		g.printStats();
	}
}
