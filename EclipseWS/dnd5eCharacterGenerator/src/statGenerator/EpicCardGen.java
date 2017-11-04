package statGenerator;

public class EpicCardGen extends Generator {

	public EpicCardGen() {
		super();
		desc = "Generate stats based on a deck of 18 card 3 of each card from 1 to 6.";
		fixed = false;
	}

	private void swap(int[] array, int i1, int i2) {
		int temp = array[i1];
		array[i1] = array[i2];
		array[i2] = temp;
	}

	@Override
	public void generate() {
		int[] deck = { 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6 };
		int deckLength = 17;
		for (int i = 0; i < stats.length; i++) {
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				int roll = dieRoller(0, deckLength);
				sum += deck[roll];
				swap(deck, roll, deckLength);
				deckLength--;
			}
			stats[i] = sum;
		}

	}
}
