import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        double balance = 0;
        int choice;
        boolean isRunning = true;

        System.out.println("==========BANKING SYSTEM==========");

        while (isRunning) {
            System.out.println("======OPTIONS MENU======");
            System.out.println("1. Show balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.println("=======================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            while (choice > 5 || choice < 1) {
                System.out.println("Invalid input.");
                System.out.print("Please reenter your choice: ");
                choice = scanner.nextInt();
            }

            switch (choice) {
                case 1:
                    showBalance(balance);
                    break;
                case 2:
                    balance = deposit(balance);
                    break;
                case 3:
                    balance = withdraw(balance);
                    break;
                case 4:
                    showHistory();
                    break;
                case 5:
                    isRunning = false;
                    break;
            }
        }

        System.out.println("=======================");
        System.out.println("Thank you! Goodbye");
    }


    static void showBalance(double balance) {
        System.out.printf("Your current balance is: $%.2f%n", balance);
        System.out.println("=======================");
    }

    static double deposit(double balance) {
        double amount;
        System.out.print("Enter the amount to deposit: ");
        amount = scanner.nextDouble();

        while (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            System.out.print("Please reenter the amount to deposit: ");
            amount = scanner.nextDouble();
        }

        balance += amount;
        transactionHistory.add(String.format("Deposited:   +$%.2f  | Balance: $%.2f", amount, balance));
        System.out.printf("$%.2f has been added to your account successfully.%n", amount);
        System.out.println("=======================");
        return balance;
    }

    static double withdraw(double balance) {
        double amount;
        System.out.print("Enter the amount to withdraw: ");
        amount = scanner.nextDouble();

        while (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            System.out.print("Please reenter the amount to withdraw: ");
            amount = scanner.nextDouble();
        }

        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal cancelled.");
            System.out.println("=======================");
            return balance;
        }

        balance -= amount;
        transactionHistory.add(String.format("Withdrawn:   -$%.2f  | Balance: $%.2f", amount, balance));
        System.out.printf("$%.2f has been withdrawn from your account.%n", amount);
        System.out.println("=======================");
        return balance;
    }

    static void showHistory() {
        System.out.println("====TRANSACTION HISTORY====");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (int i = 0; i < transactionHistory.size(); i++) {
                System.out.println((i + 1) + ". " + transactionHistory.get(i));
            }
        }
        System.out.println("=======================");
    }
}