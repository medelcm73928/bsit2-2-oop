public class ATMService {

    // ---------- OVERLOADING ----------

    public void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f%n", amount);
    }

    public void deposit(Account account, double amount, String note) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f%n", amount);
        System.out.println("Note: " + note);
    }

    // ---------- VARARGS ----------

    public double depositAll(Account account, double... amounts) {
        double total = 0;

        for (double amount : amounts) {
            account.deposit(amount);
            total += amount;
        }

        return total;
    }

    // ---------- PASS-BY-VALUE ----------

    public void tryToReplace(Account account) {
        account = new SavingsAccount(
                "XX-000",
                "Ghost Account",
                0,
                0
        );

        System.out.println("Inside the method: " + account);

        /*
         * Java is pass-by-value.
         * The reference is copied into this method.
         * Reassigning the copied reference does not change
         * the original account variable in main().
         */
    }

    public void addBonus(Account account, double bonus) {
        account.deposit(bonus);

        /*
         * The copied reference still points to the same Account object.
         * Therefore, changing the object's balance is visible to main().
         */
    }

    // ---------- TRANSFER ----------

    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException {

        // Withdraw first. If it fails, the deposit never happens.
        from.withdraw(amount);

        // Deposit only after the withdrawal succeeds.
        to.deposit(amount);
    }
}
