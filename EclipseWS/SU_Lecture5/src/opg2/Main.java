package opg2;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Konto k1 = new Konto("test", 21);
		for (int i = 0; i < 10; i++) {
			Random rand = new Random();
			int num = rand.nextInt(1000) + 1000;
			k1.indsætBeløb(num);
			System.out.printf("Balance: %d\n", k1.getSaldo());
		}
	}

}
