import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private int pin;
    private double balance;
    private ArrayList<String> transactionHistory;
    private Scanner scanner;

    // Constructor
    public ATM(int pin, double initialBalance) {
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Method to start the ATM session
    public void start() {
        System.out.println("Welcome to the ATM!");
        if (!enterPin()) {
            System.out.println("Too many incorrect attempts. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n1. Balance Inquiry");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Withdraw Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> showBalance();
                case 2 -> depositCash();
                case 3 -> withdrawCash();
                case 4 -> changePin();
                case 5 -> viewTransactionHistory();
                case 6 -> {
                    System.out.println("Thank you for using the ATM. Have a GoodDay ");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to verify PIN with retry and last warning
    private boolean enterPin() {
        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {
            System.out.print("Enter 4-digit PIN: ");
            int enteredPin = scanner.nextInt();
            if (verifyPIN(enteredPin)) {
                return true;
            } else {
                attempts++;
                if (attempts == maxAttempts - 1) {
                    System.out.println("Incorrect PIN. 1 attempt remaining!");
                } else if (attempts < maxAttempts) {
                    System.out.println("Incorrect PIN. Please try again.");
                }
            }
        }
        return false; // Return false after 3 failed attempts
    }

    // Method to display balance
    private void showBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    // Method to deposit cash
    private void depositCash() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
        System.out.println("Deposit successful. Current balance: $" + balance);
    }

    // Method to withdraw cash
    private void withdrawCash() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        } else {
            transactionHistory.add("Failed Withdrawal: $" + amount);
            System.out.println("Insufficient balance.");
        }
    }

    // Method to change PIN
    private void changePin() {
        System.out.print("Enter current PIN: ");
        int currentPin = scanner.nextInt();
        System.out.print("Enter new 4-digit PIN: ");
        int newPin = scanner.nextInt();

        if (verifyPIN(currentPin)) {
            pin = newPin;
            transactionHistory.add("PIN Changed");
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect current PIN.");
        }
    }

    // Method to view transaction history
    private void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Method to check if the entered PIN is correct
    private boolean verifyPIN(int enteredPin) {
        return pin == enteredPin;
    }

    // Main method to run the program
    public static void main(String[] args) {
        ATM atm = new ATM(1234, 1000.0); // Example account with PIN 1234 and initial balance $1000
        atm.start();
    }
}
