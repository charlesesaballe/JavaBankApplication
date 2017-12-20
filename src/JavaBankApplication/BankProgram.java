package JavaBankApplication;

// ************************************************************************
// - The program class for the BankApplication exercise
// ************************************************************************
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import java.util.ArrayList;

import java.text.DecimalFormat;

public class BankProgram {

	private static ArrayList<Account> accountList = new ArrayList<Account>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = -1;

		while (choice != 0) {

			switch (choice) {
			case 1:
				listAccounts();
				break;
			case 2:
				addAccount();
				break;
			case 3:
				depositMoney();
				break;
			case 4:
				withdrawMoney();
				break;
			case 5:
				deleteAccount();
				break;
			}

			displayMenu();
			choice = Integer.parseInt(input.nextLine());
		}

		System.out.println("\nThe program ends now. Bye!");
		input.close();
	}

	private static void displayMenu() {
		String line = "-----------------------------------------------------"
				+ "---------------------------------------------------------------";
		System.out.println(line);
		System.out.print(" 0 = Quit | 1 = List accounts | 2 = Add an account | " +
						 "3 = Deposit money | 4 = Withdraw money | 5 = Delete an account \n");
		System.out.println(line);
		System.out.print("Enter your choice: ");
	}


	private static void listAccounts() {
		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		System.out.println("\n*** Account list ***\n");
		for (Account accountListObject : accountList) {
			System.out.print("Number: " + accountListObject.getAccountNumber() + " | Balance: " + twoDecimals.format(accountListObject.getBalance()) + " euros \n");
		}

	}

	private static void addAccount() {
		Scanner input = new Scanner(System.in);
		System.out.print("\n*** Add an account ***\n");
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		
		if (findAccount(accountNumber) == null) {
			accountList.add(new Account(accountNumber));
			System.out.print("\nAccount created successfully! \n");
		} else {
			System.out.print("\nAccount not created. Account " + accountNumber + " exists already!\n");
		}
	}

	// Finds an account in accountList by given account number.
	// Returns either a reference to the account object
	// OR null if the account is not found in accountList.
	private static Account findAccount(String accountNumber) {
		Account myAccount = null;
		for (Account accountListObject : accountList) {
			if (accountListObject.getAccountNumber().equals(accountNumber)) {
				myAccount = accountListObject;
			}
		}
		
		return myAccount;
	}

	private static void depositMoney() {
		Scanner input = new Scanner(System.in);
		System.out.print("\n*** Deposit money to an account ***\n");
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		
		
		if (findAccount(accountNumber) == null) {
			System.out.print("\nAccount " + accountNumber + " does not exist!\n");
		} else {
			System.out.print("Enter the amount to be deposited: ");
			double amount = Double.parseDouble(input.nextLine().replace(',', '.'));
			
			if (amount < 0) {
				System.out.print("\nCannot deposit a negative amount!\n");
			} else {
				findAccount(accountNumber).deposit(amount);
				System.out.print("\nDeposit completed successfully!\n");
			}
			
		}
		
		
		
		
	}

	private static void withdrawMoney() {
		Scanner input = new Scanner(System.in);
		System.out.print("\n*** Withdraw money from an account ***\n");
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		
		
		if (findAccount(accountNumber) == null) {
			System.out.print("\nAccount " + accountNumber + " does not exist!\n");
		} else {
			System.out.print("Enter the amount to be withdrawn: ");
			double amount = Double.parseDouble(input.nextLine().replace(',', '.'));
			
			if (amount < 0) {
				System.out.print("\nCannot withdraw a negative amount!\n");
			} else {
				if (findAccount(accountNumber).withdraw(amount) == true) {
					System.out.print("\nWithdrawal completed successfully!\n");
				} else {
					System.out.print("\nWithdrawal not completed. Available balance is too low.\n");	
				}
			}	
			
		}
		
		}

	private static void deleteAccount() {;
		Scanner input = new Scanner(System.in);
		System.out.print("\n*** Delete an account ***\n");
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		
		
		if (findAccount(accountNumber) == null) {
			System.out.print("\nNothing deleted. Account " + accountNumber + " does not exist!\n");
		} else {
			accountList.remove(findAccount(accountNumber));
			System.out.print("\nAccount deleted successfully!\n");
		}
	}
}
// End
