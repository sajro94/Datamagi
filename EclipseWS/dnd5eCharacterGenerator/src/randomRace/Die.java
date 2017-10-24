package randomRace;

import java.util.Random;

public class Die {
	private int min;
	private int max;

	public Die(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int roll() {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

}
