package opg4_3;

import java.util.ArrayList;

public class Episode {
	private int number;
	private static int currentNumber = 1;
	private ArrayList<String> guestCast;
	private int lengthMinutes;

	Episode(ArrayList<String> guestCast, int lengthMinutes) {
		number = currentNumber;
		currentNumber++;
		this.guestCast = guestCast;
		this.lengthMinutes = lengthMinutes;
	}

	public int getNumber() {
		return number;
	}

	public int getLength() {
		return lengthMinutes;
	}

	public ArrayList<String> getGuestCast() {
		return new ArrayList<>(guestCast);
	}

}
