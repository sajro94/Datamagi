package opg2;

import java.util.ArrayList;
import java.util.Random;

public class SwimmerApp {

	public static void main(String[] args) {
		ArrayList<Swimmer> swimmers = new ArrayList<>();

		Random rand = new Random();

		ArrayList<Double> boTimes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			boTimes.add(rand.nextInt(51) + 10 + rand.nextDouble());
		}
		Swimmer bo = new Swimmer("Bo", 17, boTimes, "Club");

		ArrayList<Double> mikkelTimes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			mikkelTimes.add(rand.nextInt(51) + 10 + rand.nextDouble());
		}
		Swimmer mikkel = new Swimmer("Mikkel", 17, mikkelTimes, "Club");

		swimmers.add(mikkel);
		swimmers.add(bo);

		TrainingPlan planA = new TrainingPlan('A', 15, 22);

		planA.addSwimmer(mikkel);
		planA.addSwimmer(bo);
		planA.addSwimmer(bo);
		planA.addSwimmer(mikkel);
		planA.addSwimmer(bo);
		planA.addSwimmer(bo);
		planA.addSwimmer(mikkel);
		planA.addSwimmer(bo);
		planA.addSwimmer(bo);
		planA.addSwimmer(mikkel);
		planA.addSwimmer(bo);
		planA.addSwimmer(bo);

		for (Swimmer S : planA.getSwimmers()) {
			System.out.println(S.getName());
			System.out.println(S.getClub());
			System.out.println(S.getYearGroup());
			System.out.println(S.bestLapTime());
			System.out.println("________________________________");
		}

	}

}
