import java.util.*;
class ATM
{
    float balance;
    int pin=1234;

    public void checkpin()
    {
        System.out.println("Enter your pin: ");
        Scanner sc=new Scanner(System.in);

        int entPin=sc.nextInt();

        if(entPin==pin)
        {
            menu();
        }
        else
        {
            System.out.println("Enter a valid pin");
            checkpin();
        }
    }
    public void menu()
    {
        System.out.println("Enter your choice: ");
        System.out.println("1. Check A/C balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. deposit money");
        System.out.println("4. Exit");

        Scanner sc=new Scanner(System.in);
        int opt=sc.nextInt();

        if (opt==1)
        {
            checkBalance();
        }
        else if (opt==2)
        {
            withdrawBalance();
        }
        else if(opt==3)
        {
            depositMoney();
        }
        else if(opt==4)
        {
            return;
        }
        else
        {
            System.out.println("Entered a valid choice");
        }
    }

    public void checkBalance()
    {
        System.out.println("Balance: "+balance);
        menu();
    }
    public void withdrawBalance()
    {
        System.out.println("Enter amount to withdraw: ");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        if(amount>balance)
        {
            System.out.println("Insufficient balance");
        }
        else
        {
            balance=balance-amount;
            System.out.println("Money Withdrawn Successfully");

        }
        menu();
    }
    public void depositMoney()
    {
        System.out.println("Enter the amount");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        balance=balance+amount;
        System.out.println("Money deposited Successfully");
        menu();
    }

}
class machine
{
    public static void main(String[] args)
    {
        ATM obj=new ATM();
        obj.checkpin();
    }
}