package opg4_1;

import java.util.ArrayList;

public class Episode {
	private int number;
	private ArrayList<String> guestCast;
	private int lengthMinutes;

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
