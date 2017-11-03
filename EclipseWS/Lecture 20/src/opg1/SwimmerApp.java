package opg1;

import java.util.ArrayList;
import java.util.Random;

public class SwimmerApp {

	public static void main(String[] args) {
		ArrayList<Swimmer> swimmers = new ArrayList<>();

		Random rand = new Random();
		ArrayList<Double> janTimes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			janTimes.add(rand.nextInt(51) + 10 + rand.nextDouble());
		}
		Swimmer jan = new Swimmer("Jan", 17, janTimes, "Club");
		ArrayList<Double> boTimes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			boTimes.add(rand.nextInt(51) + 10 + rand.nextDouble());
		}
		Swimmer bo = new Swimmer("bo", 17, boTimes, "Club");
		ArrayList<Double> mikkelTimes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			mikkelTimes.add(rand.nextInt(51) + 10 + rand.nextDouble());
		}
		Swimmer mikkel = new Swimmer("Mikkel", 17, mikkelTimes, "Club");

		swimmers.add(mikkel);
		swimmers.add(bo);
		swimmers.add(jan);

		TrainingPlan planA = new TrainingPlan('A', 15, 22);
		TrainingPlan planB = new TrainingPlan('B', 22, 15);
		mikkel.setPlan(planB);
		bo.setPlan(planA);
		jan.setPlan(planA);
		for (Swimmer s : swimmers) {
			System.out.println(s.bestLapTime());
			System.out.println("______________________________");
		}
		int totalWeek = 0;
		for (Swimmer s : swimmers) {
			totalWeek += s.allTrainingHours();
		}
		System.out.println(totalWeek);

	}

}
