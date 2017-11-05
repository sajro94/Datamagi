package statGenerator;

import java.util.Random;
import dnd5eCharacterGenerator.Ability;

public abstract class Generator {
	protected int[] stats;
	protected String desc;
	protected boolean fixed;
	protected String name;

	public Generator() {
		stats = new int[6];
		desc = "A stat Generator";
		fixed = false;
	}

	@Override
	public final String toString() {
		return name;
	}

	public final boolean isFixed() {
		return fixed;
	}

	public final String getDesc() {
		return desc;
	}

	public final int[] getStats() {
		return stats;
	}

	public abstract void generate();

	public final void printStats() {
		System.out.printf("|%s|", Ability.ABILITIES[0].getName().substring(0, 3).toUpperCase());
		for (int i = 1; i < 6; i++) {
			System.out.printf("%s|", Ability.ABILITIES[i].getName().substring(0, 3).toUpperCase());
		}
		System.out.println();
		System.out.printf("| %02d|", stats[0]);
		for (int i = 1; i < 6; i++) {
			System.out.printf(" %02d|", stats[i]);
		}
	}

	protected final int dieRoller(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}

	public void generate(String annotation) {
		generate();
	}

}
