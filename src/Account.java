import java.util.ArrayList;
import java.util.List;

public class Account {
    // Encapsulated fields including private PIN and transaction log
    private final String owner;
    private double balance;
    private final String pin;
    private final List<String> transactionHistory;

    public Account(String owner, double openingBalance, String pin) {
        this.owner = owner;
        this.balance = (openingBalance >= 0) ? openingBalance : 0;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
        this.transactionHistory.add(String.format("Account opened | Initial Balance: $%.2f", this.balance));
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    // PIN Authentication guard
    public boolean checkPin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        balance += amount;
        String record = String.format("Deposited: $%.2f | New balance: $%.2f", amount, balance);
        transactionHistory.add(record);
        System.out.println(record);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        String record = String.format("Withdrew: $%.2f | New balance: $%.2f", amount, balance);
        transactionHistory.add(record);
        System.out.println(record);
    }

    public void printTransactionHistory() {
        System.out.println("\n--- TRANSACTION HISTORY ---");
        for (String entry : transactionHistory) {
            System.out.println("- " + entry);
        }
    }
}