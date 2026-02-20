import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = BankFileHandler.loadAccounts();
        int choice;

        do {
            System.out.println("\n---- MINI BANKING SYSTEM ----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Search Account");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    accounts.add(new Account(accNo, name, bal));
                    BankFileHandler.saveAccounts(accounts);
                    System.out.println("Account Created Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    int depAcc = sc.nextInt();
                    Account acc1 = search(accounts, depAcc);
                    if (acc1 != null) {
                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();
                        acc1.deposit(amt);
                        BankFileHandler.saveAccounts(accounts);
                    } else {
                        System.out.println("Account Not Found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account No: ");
                    int withAcc = sc.nextInt();
                    Account acc2 = search(accounts, withAcc);
                    if (acc2 != null) {
                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();
                        acc2.withdraw(amt);
                        BankFileHandler.saveAccounts(accounts);
                    } else {
                        System.out.println("Account Not Found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account No: ");
                    int searchAcc = sc.nextInt();
                    Account acc3 = search(accounts, searchAcc);
                    if (acc3 != null) {
                        acc3.display("Account Found:");
                    } else {
                        System.out.println("Account Not Found.");
                    }
                    break;

                case 5:
                    for (Account acc : accounts) {
                        acc.display();
                    }
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 6);

        sc.close();
    }

    public static Account search(ArrayList<Account> accounts, int accNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNo() == accNo) {
                return acc;
            }
        }
        return null;
    }
}