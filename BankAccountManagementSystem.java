package package1;

import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Check balance method
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance: $" + balance);
    }
}

public class BankAccountManagementSystem {

	public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        
        // Creating a new account
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        
        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);
        int choice;

        do {
            System.out.println("\nBank Account Management System");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.displayAccountDetails();
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank Account Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();

	}

}
