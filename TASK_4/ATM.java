
import java.util.Scanner;

public class ATM {
    private String cardNumber = "1234567890";
    private String pin = "1234";
    private double balance = 1000.0;
    private boolean loggedIn = false;

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }

    public void start() {
        welcomeScreen();
    }

    private void welcomeScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM");
        while (!loggedIn) {
            System.out.print("Please insert your card (enter card number): ");
            String inputCardNumber = scanner.nextLine();
            if (inputCardNumber.equals(cardNumber)) {
                authenticateUser(scanner);
            } else {
                System.out.println("Invalid card number. Please try again.");
            }
        }
    }

    private void authenticateUser(Scanner scanner) {
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter your PIN: ");
            String inputPin = scanner.nextLine();
            if (inputPin.equals(pin)) {
                loggedIn = true;
                mainMenu(scanner);
                return;
            } else {
                attempts--;
                System.out.println("Incorrect PIN. You have " + attempts + " attempts left.");
            }
        }
        System.out.println("Your card has been blocked due to multiple incorrect PIN entries.");
        System.exit(0);
    }

    private void mainMenu(Scanner scanner) {
        while (loggedIn) {
            System.out.println("\nMain Menu");
            System.out.println("1. Withdraw Cash");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Check Balance");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Select a transaction: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    withdrawCash(scanner);
                    break;
                case "2":
                    depositCash(scanner);
                    break;
                case "3":
                    checkBalance();
                    break;
                case "4":
                    changePin(scanner);
                    break;
                case "5":
                    exit();
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }

    private void withdrawCash(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Please take your cash: " + amount);
            printReceipt("Withdraw", amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    private void depositCash(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        balance += amount;
        System.out.println("Successfully deposited: " + amount);
        printReceipt("Deposit", amount);
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + balance);
        printReceipt("Balance Check", balance);
    }

    private void changePin(Scanner scanner) {
        System.out.print("Enter your old PIN: ");
        String oldPin = scanner.nextLine();
        if (oldPin.equals(pin)) {
            System.out.print("Enter new PIN: ");
            String newPin = scanner.nextLine();
            System.out.print("Confirm new PIN: ");
            String confirmPin = scanner.nextLine();
            if (newPin.equals(confirmPin)) {
                pin = newPin;
                System.out.println("PIN successfully changed.");
            } else {
                System.out.println("PIN confirmation does not match.");
            }
        } else {
            System.out.println("Incorrect old PIN.");
        }
    }

    private void printReceipt(String transactionType, double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want a receipt? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("\n--- Receipt ---");
            System.out.println("Transaction: " + transactionType);
            System.out.println("Amount: " + amount);
            System.out.println("New Balance: " + balance);
            System.out.println("----------------");
        }
    }

    private void exit() {
        System.out.println("Thank you for using the ATM.");
        loggedIn = false;
        System.exit(0);
    }
}
