import java.util.Scanner;

public class Account {
    // class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Class Constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    //Function for deposit Money
    void deposit(int amount) {
        if(amount !=0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //Function for Withdraw money
    void withdraw(int amount) {
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }
    //Function to show previous transaction
    void getpreviousTransaction() {
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction <0){
            System.out.println("withdraw: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction ocurred");
        }
    }
    //Function calculating interest of current funds after a number of years
    void calculateInterest(int years){
        double interestRate = 0.185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("the current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + "years, you balance will be: " + newBalance);
    }
    //Function that showing the menu
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your Id is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your Balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();
            switch (option){
                //Case A allows user to check their balance
                case 'A':
                    System.out.println("========================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("========================");
                    System.out.println();
                    break;
                    // Case B, allows the user to deposit money
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                    //Case C allows the user to withdraw money
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                    //Case D allows user to view their most recent transaction
                case 'D':
                   System.out.println("========================");
                   getpreviousTransaction();
                    System.out.println("========================");
                    System.out.println();
                    break;
                    //Case E calculates the accrued interest rate after a number of years
                case 'E':
                    System.out.println("Enter how many years of accrued interest rate: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                    //Case F exit the program
                case 'F':
                    System.out.println("========================");
                    break;
                    //the default case let's user know they entered an invalid character
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, ");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thanks you for banking with us! ");
    }


}
