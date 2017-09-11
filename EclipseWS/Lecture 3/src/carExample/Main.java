package carExample;

public class Main {

	public static void main(String[] args) {
		Car volvo = new Car(18);
		volvo.drive(12);
		volvo.addFuel(15);
		System.out.println(volvo.getFuelInTank());
		volvo.drive(100);
		System.out.println(volvo.getFuelInTank());
	}

}
