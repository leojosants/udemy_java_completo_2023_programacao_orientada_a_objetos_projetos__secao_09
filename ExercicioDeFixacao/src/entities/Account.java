package entities;

public class Account {
	/*
	 * attributes
	 */
	private int number;
	private String holder;
	private double balance;

	/*
	 * constructor
	 */
	public Account(int number, String holder) {
		this.number = number;
		this.holder = holder;
		this.balance = 0.0;
	}

	/*
	 * constructor - overload
	 */
	public Account(int number, String holder, double initialDepositAmount) {
		this.number = number;
		this.holder = holder;
		this.deposit(initialDepositAmount);
	}

	/*
	 * getters and setters
	 */
	public int getNumber() {
		return this.number;
	}

	public String getHolder() {
		return this.holder;
	}

	public void setHolder(String name) {
		this.holder = this.getHolder() + "" + name;
	}

	public double getBalance() {
		return this.balance;
	}

	private void setBalance(double amount) {
		this.balance = amount;
	}

	/*
	 * methods
	 */
	public void deposit(double amount) {
		this.setBalance(this.getBalance() + amount);
	}

	public void withdraw(double amount) {
		double withdrawalFee = 5.00;
		this.setBalance(this.getBalance() - amount - withdrawalFee);
	}

	@Override
	public String toString() {
		return String.format("Conta %d, ", this.getNumber()) + String.format("Titular: %s, ", this.getHolder())
				+ String.format("Saldo: R$ %.2f", this.getBalance());
	}
}
