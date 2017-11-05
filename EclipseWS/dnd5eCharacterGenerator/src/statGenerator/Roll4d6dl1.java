package statGenerator;

public class Roll4d6dl1 extends Generator {

	public Roll4d6dl1() {
		super();
		desc = "Creates stats by rolling 4d6 drop lowest 6 times.";
		fixed = false;
		name = "4d6 once, drop lowest die";
	}

	@Override
	public void generate() {
		for (int i = 0; i < stats.length; i++) {
			int roll = 0;
			int min = dieRoller(1, 6);
			roll += min;
			for (int j = 0; j < 3; j++) {
				int check = dieRoller(1, 6);
				roll += check;
				min = check < min ? check : min;
			}
			roll -= min;
			stats[i] = roll;
		}
	}

}
