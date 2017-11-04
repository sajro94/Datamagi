package statGenerator;

import dieRoller.AnnotationRoller;
import dieRoller.BadAnnotationException;

public class Generic extends Generator {
	protected int[] stats;
	protected String desc;
	protected boolean fixed;

	public Generic() {
		stats = new int[6];
		desc = "A stat Generator";
		fixed = false;
	}

	@Override
	public void generate(String annotation) {
		for (int i = 0; i < 6; i++) {
			try {
				stats[i] = AnnotationRoller.dieAnnotator(annotation);
			} catch (BadAnnotationException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void generate() {
		generate("4d6dl1");
	}

}
