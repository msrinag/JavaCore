class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("only postive deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}


class Customer1 {
    private String name;
    private BankAccount account;

    public Customer1(String name, String accountNumber) {
        this.name = name;
        this.account = new BankAccount(accountNumber);
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println(name + "'s Account Balance: " + account.getBalance());
    }

    public BankAccount getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }
}


class Transaction {
    private String type;
    private double amount;
    private Customer1 customer;

    public Transaction(Customer1 customer, String type, double amount) {
        this.customer = customer;
        this.type = type;
        this.amount = amount;
    }

    public void process() {
        if (type.equalsIgnoreCase("deposit")) {
            customer.deposit(amount);
        } else if (type.equalsIgnoreCase("withdraw")) {
            customer.withdraw(amount);
        } else {
            System.out.println("Invalid transaction type.");
        }
    }
}


public class Main3 {
    public static void main(String[] args) {
        Customer1 customer1 = new Customer1("srinag", "123");

        // Performing transactions
        customer1.deposit(1000);
        customer1.checkBalance();

        Transaction transaction1 = new Transaction(customer1, "withdraw", 500);
        transaction1.process();
        
        customer1.checkBalance();
    }
}
