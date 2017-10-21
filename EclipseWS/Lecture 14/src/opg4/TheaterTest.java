package opg4;

public class TheaterTest {

	public static void main(String[] args) {
		Theater t = new Theater();
		for (int i = 9; i >= 0; i--) {
			t.buyTicket();
		}
		t.buyTicket();
		t.closeScanner();
	}

}
