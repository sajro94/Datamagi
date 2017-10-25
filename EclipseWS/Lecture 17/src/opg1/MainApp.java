package opg1;

import java.util.ArrayList;

public class MainApp {

	public static void main(String[] args) {

		ArrayList<BankAccount> bacs = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			bacs.add(new BankAccount(1200.00));
		}

		for (BankAccount b : bacs) {
			System.out.println(b.getId());
		}
	}

}
