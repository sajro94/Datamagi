package statGenerator;

public class Roll2x3d6_dl1 extends Generator {

	public Roll2x3d6_dl1() {
		super();
		desc = "Creates stats by rolling 3d6 6 times.";
		fixed = false;
	}

	@Override
	public void generate() {
		for (int i = 0; i < stats.length; i++) {
			int roll1 = 0;
			for (int j = 0; j < 3; j++) {
				roll1 += dieRoller(1, 6);
			}
			int roll2 = 0;
			for (int j = 0; j < 3; j++) {
				roll2 += dieRoller(1, 6);
			}
			stats[i] = roll2 > roll1 ? roll2 : roll1;
		}
	}

}
