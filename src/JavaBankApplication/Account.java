package JavaBankApplication;


// ************************************************************************
// - The class for Account objects
// ************************************************************************
public class Account {
	// Fields

	private String accountNumber;
	private double balance = 0;
	// Constructor

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	// Methods
	public void deposit(double amount) {
		this.balance += amount;
	}
	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}
	
	public boolean withdraw(double amount) {
		if (balance <= amount) {
			return false;
		} else {
			balance = balance - amount;
			return true;
		}
	}
		

}
// End