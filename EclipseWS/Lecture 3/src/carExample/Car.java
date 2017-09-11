package carExample;

public class Car {
	private double fuelEfficiency; // In km/l
	private double fuel; // Maximum amount of fuel

	public Car(double fe) {
		this.fuelEfficiency = fe;
		this.fuel = 0;
	}

	public void drive(double distance) {
		double fuelCost = distance / this.fuelEfficiency;
		if (fuelCost > this.fuel) {
			double dryOut = this.fuel * this.fuelEfficiency;
			System.out.println("Car ran dry after " + dryOut + " kilometers.");
		} else {
			this.fuel -= fuelCost;
		}
	}

	public void addFuel(double f) {
		this.fuel += f;
	}

	public double getFuelInTank() {
		return this.fuel;
	}
}
