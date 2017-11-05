package opg3;

import java.util.Random;

public class MainApp {

	public static void main(String[] args) {
		Car[] cars = new Car[5];
		cars[0] = new Car("XX25677", 1996);
		cars[1] = new Car("BT90390", 2008);
		cars[2] = new Car("JT68465", 2015);
		cars[3] = new Car("MR52416", 2016);
		cars[4] = new Car("LR53438", 2017);

		Random r = new Random(1200);
		for (int i = 0; i < cars.length; i++) {
			cars[i].setPricePerDay(r.nextInt(401) + 100);
		}

		Rental r1 = new Rental(12, 7, "27-11-2017");
		r1.addCar(cars[0]);
		r1.addCar(cars[1]);
		r1.addCar(cars[2]);
		Rental r2 = new Rental(13, 7, "29-11-2017");
		r2.addCar(cars[2]);
		r2.addCar(cars[3]);
		r2.addCar(cars[4]);

		System.out.println(r1.getPrice());
		System.out.println(r2.getPrice());

	}

}
