public class SavingsAccount extends Account {

    private static final double MAINTAINING_BALANCE = 500.00;

    public SavingsAccount(
            String accountNumber,
            String ownerName,
            double openingBalance) {

        super(accountNumber, ownerName, openingBalance);
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than 0"
            );
        }

        if (getBalance() - amount < MAINTAINING_BALANCE) {
            double shortBy =
                    MAINTAINING_BALANCE - (getBalance() - amount);

            throw new InsufficientFundsException(shortBy);
        }

        applyWithdrawal(amount);
    }
}
