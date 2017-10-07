package opg4;

public class Card {
	private String shorthand;

	public Card(String c) {
		this.shorthand = c;
	}

	public String getDescription() {
		String val = this.shorthand.substring(0, 1);
		String col = this.shorthand.substring(1, 1);
		if (this.shorthand.contains("10")) {
			val = "10";
		}
		switch (val) {
		case "2":
			val = "Two";
			break;
		case "3":
			val = "Three";
			break;
		case "4":
			val = "Four";
			break;
		case "5":
			val = "Five";
			break;
		case "6":
			val = "Six";
			break;
		case "7":
			val = "Seven";
			break;
		case "8":
			val = "Eight";
			break;
		case "9":
			val = "Nine";
			break;
		case "10":
			val = "Ten";
			break;
		case "A":
			val = "Ace";
			break;
		case "J":
			val = "Jack";
			break;
		case "K":
			val = "King";
			break;
		case "Q":
			val = "Queen";
			break;
		default:
			val = "Unknown";
			break;
		}

		switch (col) {
		case "D":
			col = "Diamonds";
			break;
		case "H":
			col = "Hearts";
			break;
		case "S":
			col = "Spades";
			break;
		case "C":
			col = "Clubs";
			break;
		default:
			col = "Unknown";
			break;
		}

		return val + " of " + col;
	}

}
