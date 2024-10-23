# ATM Machine Simulation in Java

This project simulates an ATM machine with essential banking operations such as balance inquiry, deposit, withdrawal, PIN change, and viewing transaction history. It uses Java’s OOP features, such as classes and methods, and allows users to interact with the ATM through a command-line interface.

## Features
- **Balance Inquiry**: Displays the current account balance.
- **Cash Deposit**: Allows users to deposit money into their account.
- **Cash Withdrawal**: Allows users to withdraw money, ensuring sufficient balance.
- **PIN Change**: Allows users to change their PIN after verifying the current one.
- **Transaction History**: Displays the history of deposits, withdrawals, failed withdrawal attempts, and PIN changes.
- **Security**: The ATM allows up to 3 attempts to enter the correct PIN before locking the session.

## Code Breakdown

### 1. Class Declaration and Attributes
The `ATM` class contains the following attributes:
- `pin`: Stores the user's 4-digit PIN.
- `balance`: Keeps track of the account balance.
- `transactionHistory`: A list to store all transactions.
- `scanner`: A `Scanner` object to handle user input.

### 2. Constructor
The constructor `ATM(int pin, double initialBalance)` initializes the ATM with a PIN and an initial balance, and sets up the transaction history.

### 3. ATM Session (`start()` method)
This method initiates the ATM session and presents the user with a menu to choose operations. It keeps running until the user selects the option to exit.

### 4. PIN Verification (`enterPin()` method)
This method allows the user to input their PIN, with up to 3 attempts. If the correct PIN is entered, the user can proceed with ATM operations.

### 5. Operations
- **Balance Inquiry**: Displays the current balance to the user (`showBalance()` method).
- **Deposit Cash**: Adds a specified amount to the account balance and updates the transaction history (`depositCash()` method).
- **Withdraw Cash**: Withdraws a specified amount from the account balance if there are sufficient funds, and logs the transaction (`withdrawCash()` method).
- **Change PIN**: Allows the user to change their PIN after verifying the current PIN (`changePin()` method).
- **Transaction History**: Displays all past transactions (`viewTransactionHistory()` method).

### 6. PIN Verification (`verifyPIN()` method)
This method checks whether the entered PIN matches the stored PIN.

### 7. Main Method
The `main` method creates an `ATM` object with a sample initial PIN (1234) and balance ($1000), then starts the session.

## How to Run
1. Clone the repository or download the code.
2. Compile and run the `ATM.java` file in your preferred IDE or command line:
   ```bash
   javac ATM.java
   java ATM

## Example Output
```bash
Welcome to the ATM!
Enter 4-digit PIN: 
1234

1. Balance Inquiry
2. Deposit Cash
3. Withdraw Cash
4. Change PIN
5. View Transaction History
6. Exit

Choose an option: 1
Your current balance is: $1000.0

Choose an option: 2
Enter the amount to deposit: 500
Deposit successful. Current balance: $1500.0

Choose an option: 3
Enter the amount to withdraw: 200
Withdrawal successful. Current balance: $1300.0

Choose an option: 5
Transaction History:
Deposited: $500.0
Withdrew: $200.0

Choose an option: 6
Thank you for using the ATM. Have a GoodDay!
