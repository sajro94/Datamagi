package statGenerator;

public class Roll3d6 extends Generator {

	public Roll3d6() {
		super();
		desc = "Creates stats by rolling 3d6 6 times.";
		fixed = false;
		name = "3d6 once";
	}

	@Override
	public void generate() {
		for (int i = 0; i < stats.length; i++) {
			int roll = 0;
			for (int j = 0; j < 3; j++) {
				int check = dieRoller(1, 6);
				roll += check;
			}
			stats[i] = roll;
		}
	}

}
