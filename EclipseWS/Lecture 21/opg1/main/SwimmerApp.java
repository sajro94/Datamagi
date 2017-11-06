package main;

import java.util.ArrayList;
import java.util.Random;

import classes.Swimmer;
import classes.TrainingPlan;

public class SwimmerApp {

	public static void main(String[] args) {
		ArrayList<Swimmer> swimmers = new ArrayList<>();

		Random rand = new Random(21);
		ArrayList<Double> janTimes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			janTimes.add(rand.nextInt(51) + 10 + rand.nextDouble());
		}
		ArrayList<Double> boTimes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			boTimes.add(rand.nextInt(51) + 10 + rand.nextDouble());
		}
		ArrayList<Double> mikkelTimes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			mikkelTimes.add(rand.nextInt(51) + 10 + rand.nextDouble());
		}

		TrainingPlan planA = new TrainingPlan('A', 15, 22);
		planA.createSwimmer("Mikkel", 17, mikkelTimes, "Club");
		planA.createSwimmer("Bo", 17, boTimes, "Club");
		TrainingPlan planB = new TrainingPlan('B', 22, 15);
		planB.createSwimmer("Jan", 17, janTimes, "Club");

	}

}
