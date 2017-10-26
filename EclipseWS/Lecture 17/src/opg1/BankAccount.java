package opg1;

public class BankAccount {
	private double balance;
	private int id;
	private static int numberOfAccounts = 1;

	/**
	 * Creates an object of the class with an inital balance and a unique id which
	 * automatically increments every time a new object is created.<br>
	 * 
	 * @param initialBalance
	 *            a double determining the initial balance of the bank account.<br>
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
		this.id = numberOfAccounts;
		numberOfAccounts++;
	}

	/**
	 * Mutates the balance by adding the parameter amount to the current
	 * balance.<br>
	 *
	 * @param amount
	 *            a double specifying the amount to add to the account(amount >
	 *            0).<br>
	 */
	public void deposit(double amount) {
		balance += amount;
	}

	/**
	 * Mutates the balance by subtracting the parameter amount from the current
	 * balance. <br>
	 *
	 * @param amount
	 *            a double specifying the amount to add to the account(amount >
	 *            0).<br>
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}

	/**
	 * Accesses the balance and returns it.<br>
	 *
	 * @return double
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Accesses the id and returns it.<br>
	 *
	 * @return int
	 */
	public int getId() {
		return id;
	}

}
