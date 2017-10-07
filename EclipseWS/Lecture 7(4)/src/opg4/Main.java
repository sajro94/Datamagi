package opg4;

public class Main {

	public static void main(String[] args) {
		Tips t1 = new Tips(2, 165);
		System.out.println(t1.tip());
		Card c1 = new Card("D10");
		System.out.println(c1.getDescription());
	}

}
