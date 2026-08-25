package atm;

public class ATMService {

    public void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f%n", amount);
    }

    public void deposit(Account account, double amount, String note) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f with note: %s%n", amount, note);
    }

    public double depositAll(Account account, double... amounts) {
        double total = 0;
        for (double amount : amounts) {
            account.deposit(amount);
            total += amount;
        }
        return total;
    }

    public void tryToReplace(Account account) {
        account = new SavingsAccount("XX-000", "Ghost Account", 0, 0);
        System.out.println("Inside the method  : " + account);
        /*
         * EXPLANATION: Java is strictly pass-by-value. When the variable 'account'
         * is passed into this method, a copy of the object reference is handed over.
         * Reassigning 'account = new ...' changes only the local copy of the reference
         * pointing to a new memory address. The caller's variable in main() still points
         * to the original object reference.
         */
    }

    public void addBonus(Account account, double bonus) {
        account.deposit(bonus);
        /*
         * EXPLANATION: Even though Java is pass-by-value, the value passed is the
         * object's reference (memory address). Because both the caller and this method
         * point to the exact same object in heap memory, calling methods or mutating
         * fields on that reference directly alters the underlying object, making the
         * change visible back in main().
         */
    }

    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException {
        from.withdraw(amount);
        to.deposit(amount);
    }
}