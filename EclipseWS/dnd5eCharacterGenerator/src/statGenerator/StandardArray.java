package statGenerator;

public class StandardArray extends Generator {

	public StandardArray() {
		super();
		desc = "Gives a standard array of [15,14,13,12,10,8]";
		fixed = false;
	}

	@Override
	public void generate() {
		stats = new int[] { 15, 14, 13, 12, 10, 8 };
	}
}
