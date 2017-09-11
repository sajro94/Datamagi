package accountExample;

public class Main {

	public static void main(String[] args) {
		SavingsAccount a1 = new SavingsAccount(1200);
		SavingsAccount a2 = new SavingsAccount(1200, 12);
		System.out.println(a1);
		a1.addInterest();
		System.out.println(a1);
		a1.addInterest();
		System.out.println(a1);
		System.out.println(a2);
		a2.addInterest();
		System.out.println(a2);
		a2.addInterest();
		System.out.println(a2);
		a2.addInterest();
	}

}
