import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SavingsAccount account = new SavingsAccount(
                "SA-1001",
                "Juan Dela Cruz",
                5000.00
        );

        boolean running = true;

        System.out.println("=================================");
        System.out.println("     LICEO ATM MACHINE");
        System.out.println("=================================");

        System.out.println(
                "Account : "
                        + account.getAccountNumber()
                        + "  ("
                        + account.getOwnerName()
                        + ")"
        );

        System.out.println(
                "Type    : "
                        + account.getAccountType()
        );

        System.out.println(
                "Balance : PHP "
                        + String.format("%.2f", account.getBalance())
        );

        System.out.println("---------------------------------");

        while (running) {

            System.out.println("[1] Check Balance");
            System.out.println("[2] Deposit");
            System.out.println("[3] Withdraw");
            System.out.println("[4] Deposit Multiple Amounts");
            System.out.println("[5] Pass-by-Value Demo");
            System.out.println("[0] Exit");

            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

            int choice;

            try {

                choice = Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: Please type a number, not letters."
                );

                System.out.println("---------------------------------");
                continue;
            }

            switch (choice) {

                case 1:
                    checkBalance(account);
                    break;

                case 2:
                    depositMoney(account, scanner);
                    break;

                case 3:
                    withdrawMoney(account, scanner);
                    break;

                case 4:
                    depositMultiple(account, scanner);
                    break;

                case 5:
                    passByValueDemo(account);
                    break;

                case 0:
                    running = false;
                    System.out.println(
                            "Thank you for using Liceo ATM!"
                    );
                    break;

                default:
                    System.out.println(
                            "Error: Invalid option."
                    );
            }

            if (running) {
                System.out.println("---------------------------------");
            }
        }

        scanner.close();
    }

    // Option 1
    public static void checkBalance(Account account) {

        System.out.println(
                "Current balance: PHP "
                        + String.format("%.2f", account.getBalance())
        );
    }

    // Option 2
    public static void depositMoney(
            Account account,
            Scanner scanner) {

        try {

            System.out.print("Enter amount to deposit: ");

            double amount = Double.parseDouble(
                    scanner.nextLine()
            );

            account.deposit(amount);

            System.out.println(
                    "Deposited PHP "
                            + String.format("%.2f", amount)
                            + ". New balance: PHP "
                            + String.format("%.2f", account.getBalance())
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Error: Please enter a valid number."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // Option 3
    public static void withdrawMoney(
            Account account,
            Scanner scanner) {

        try {

            System.out.print("Enter amount to withdraw: ");

            double amount = Double.parseDouble(
                    scanner.nextLine()
            );

            account.withdraw(amount);

            System.out.println(
                    "Withdrawn PHP "
                            + String.format("%.2f", amount)
                            + ". New balance: PHP "
                            + String.format("%.2f", account.getBalance())
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Error: Please enter a valid number."
            );

        } catch (InsufficientFundsException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            System.out.println(
                    "---------------------------------"
            );
        }
    }

    // Option 4
    public static void depositMultiple(
            Account account,
            Scanner scanner) {

        try {

            System.out.print(
                    "How many amounts would you like to deposit? "
            );

            int count = Integer.parseInt(
                    scanner.nextLine()
            );

            if (count <= 0) {
                throw new IllegalArgumentException(
                        "Number of amounts must be greater than 0."
                );
            }

            double[] amounts = new double[count];

            for (int i = 0; i < count; i++) {

                System.out.print(
                        "Enter amount " + (i + 1) + ": "
                );

                amounts[i] = Double.parseDouble(
                        scanner.nextLine()
                );
            }

            depositAll(account, amounts);

            System.out.println(
                    "Multiple deposits successful."
            );

            System.out.println(
                    "New balance: PHP "
                            + String.format("%.2f", account.getBalance())
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Error: Please enter valid numbers."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // Varargs method
    public static void depositAll(
            Account account,
            double... amounts) {

        for (double amount : amounts) {
            account.deposit(amount);
        }
    }

    // Option 5
    public static void passByValueDemo(
            Account account) {

        System.out.println(
                "Before method: PHP "
                        + String.format("%.2f", account.getBalance())
        );

        ParameterDemo.changeBalance(account);

        System.out.println(
                "After method: PHP "
                        + String.format("%.2f", account.getBalance())
        );

        ParameterDemo.reassignAccount(account);

        System.out.println(
                "The original account still exists."
        );
    }
}
