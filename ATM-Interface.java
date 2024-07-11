import java.util.Scanner;

public class ATMInterface {
    private static double accountBalance = 1000.0;  // Initial account balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositFunds();
                    break;
                case 3:
                    withdrawFunds();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void checkBalance() {
        System.out.println("Your account balance: $" + accountBalance);
    }

    private static void depositFunds() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: $");
        double depositAmount = scanner.nextDouble();

        if (depositAmount > 0) {
            accountBalance += depositAmount;
            System.out.println("Deposit successful. Your new balance: $" + accountBalance);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private static void withdrawFunds() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: $");
        double withdrawAmount = scanner.nextDouble();

        if (withdrawAmount > 0 && withdrawAmount <= accountBalance) {
            accountBalance -= withdrawAmount;
            System.out.println("Withdrawal successful. Your new balance: $" + accountBalance);
        } else if (withdrawAmount > accountBalance) {
            System.out.println("Insufficient funds. Your current balance is: $" + accountBalance);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
}
