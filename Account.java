public class Account {
    private int accountNo;
    private String name;
    private double balance;
    private static final double MIN_BALANCE = 1000.0;

    public Account() {
    }

    public Account(int accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited Successfully.");
        } else {
            System.out.println("Invalid Amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawal Successful.");
        } else {
            System.out.println("Insufficient Balance or Minimum Balance Condition Violated.");
        }
    }

    public void display() {
        System.out.println("Account No : " + accountNo);
        System.out.println("Name       : " + name);
        System.out.println("Balance    : " + balance);
        System.out.println("----------------------------");
    }

    public void display(String message) {
        System.out.println(message);
        display();
    }

    public int getAccountNo() {
        return accountNo;
    }

    public String toFileString() {
        return accountNo + "," + name + "," + balance;
    }

    public static Account fromFileString(String data) {
        String[] parts = data.split(",");
        int accNo = Integer.parseInt(parts[0]);
        String name = parts[1];
        double bal = Double.parseDouble(parts[2]);
        return new Account(accNo, name, bal);
    }
}