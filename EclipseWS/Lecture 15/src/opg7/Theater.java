package opg7;

import java.util.Scanner;

public class Theater {
	private int[][] theater = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
			{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
			{ 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 }, { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
			{ 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };
	private Scanner scan = new Scanner(System.in);

	public int[][] getTheater() {
		return theater;
	}

	public void buyTicket() {
		boolean error;
		System.out.printf("Input %S for at købe til bestemt pris.%nInput %S for at købe en bestemt plads.%n", "a", "b");
		String input = scan.nextLine();
		if (input.equalsIgnoreCase("B")) {
			error = ticketByPlace();
		} else {
			error = ticketByPrice();
		}
		if (!error) {
			System.out.println("There was an error!");
		}
	}

	public void closeScanner() {
		scan.close();
	}

	private boolean ticketByPlace() {
		System.out.println("Input your prefered row(1 - 9):");
		int row = scan.nextInt();
		System.out.println("Input your preferred column(1-10):");
		int col = scan.nextInt();
		if (row - 1 > 9 && col - 1 > 10) {
			if (theater[col][row] != 0) {
				System.out.println("Please choose a new seat, this seat is taken.");
				return ticketByPlace();
			} else {
				theater[col][row] = 0;
				System.out.printf("You have now taken the following seat: Row %s/Col %s.%n", row, col);
				return true;
			}
		} else {
			System.out.println("Please read and follow instructions.");
			return ticketByPlace();
		}
	}

	private boolean ticketByPrice() {
		System.out.println("Input your preferred price(10-50):");
		int price = scan.nextInt();
		if (price % 10 == 0 && price >= 10 && price <= 50) {

		} else if (price > 10 && price < 60) {
			int topOff = price % 10;
			price = price - topOff;
			System.out.println("We have changed your preferred price to " + price + ".");
		} else {
			return ticketByPrice();
		}
		for (int i = theater.length - 1; i >= 0; i--) {
			int halfWay = Math.round(theater[i].length / 2);
			int neg = -1;
			for (int j = halfWay; j < 10 && j >= 0;) {
				if (theater[i][j] == price) {
					System.out.printf("We found the following seat for you: Row %s/Col %s.%n", i + 1, j + 1);
					theater[i][j] = 0;
					return true;
				}
				j += neg;
				if (neg < 0) {
					neg--;
				} else {
					neg++;
				}
				neg = neg * -1;
			}
		}
		System.out
				.println("We didn't find any possible seat for you at that price, please try a lower or higher price.");
		return ticketByPrice();
	}

}
