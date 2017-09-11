package accountExample;

public class SavingsAccount {
	private double balance;
	private double interestRate;

	public void setBalance(double b) {
		this.balance = b;
	}

	public void setInterestRate(double ir) {
		this.interestRate = ir;
	}

	public void deposit(double d) {
		this.balance += d;
	}

	public void withdraw(double w) {
		this.balance -= w;
	}

	public void addInterest() {
		this.balance = balance * (1 + this.interestRate / 100);
	}

	public double getBalance() {
		return this.balance;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public SavingsAccount(double b) {
		this.balance = b;
		this.interestRate = 5.5;
	}

	public SavingsAccount(double b, double ir) {
		this.balance = b;
		this.interestRate = ir;
	}

	@Override
	public String toString() {
		return "Balance: " + this.balance;
	}
}
