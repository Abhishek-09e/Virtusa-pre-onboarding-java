import java.util.*;
class InsufficientFundsException extends Exception
{
    public InsufficientFundsException(String message)
    {
        super(message);
    }
}
class Account
{
    private String accountHolder;
    private double balance;
    private ArrayList<Double> transactions;
    public Account(String name, double initialBalance)
    {
        this.accountHolder = name;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Amount must be positive!");
        }
        balance += amount;
        addTransaction(amount);
        System.out.println("Deposited");
    }
    public void processTransaction(double amount) throws InsufficientFundsException
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Amount must be positive!");
        }

        if (amount > balance)
        {
            throw new InsufficientFundsException("Insufficient balance!");
        }

        balance -= amount;
        addTransaction(-amount);
        System.out.println("Withdrawal successful!");
    }

    private void addTransaction(double amount)
    {
        if (transactions.size() == 5)
        {
            transactions.remove(0);
        }
        transactions.add(amount);
    }
    public void printMiniStatement()
    {
        System.out.println("\n     Last 5 Transactions    ");
        for (double t : transactions)
        {
            if (t > 0)
            {
                System.out.println("Deposited: " + t);
            }
            else
            {
                System.out.println("Withdrawn: " + Math.abs(t));
            }
        }
    }
    public void showBalance()
    {
        System.out.println("Current Balance: " + balance);
    }
}
class FinSafeApp
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        Account acc = new Account(name, 0);
        int choice;
        do
        {
            System.out.println("\n    FinSafe Menu    ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            try
            {
                switch (choice)
                {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        acc.deposit(dep);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double wit = sc.nextDouble();
                        acc.processTransaction(wit);
                        break;

                    case 3:
                        acc.showBalance();
                        break;

                    case 4:
                        acc.printMiniStatement();
                        break;

                    case 5:
                        System.out.println("Thank you for using FinSafe!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
            catch (InsufficientFundsException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
        while (choice != 5);
    }
}