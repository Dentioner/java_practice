import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

class BankAccount
{
    private int balance = 100;
    public int getBalance()
    {
        return balance;
    }
    public void withdraw(int amount)
    {
        balance -= amount;
    }
}

public class OkarinAndKurisu implements Runnable
{
    private BankAccount account = new BankAccount();
    public static void main(String[] args)
    {
        OkarinAndKurisu theJob = new OkarinAndKurisu();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Okarin");
        two.setName("Kurisu");
        one.start();
        two.start();
    }

    public void run()
    {
        for(int x= 0; x<10 ; x++)
        {
            makeWithdrawal(10);
            if(account.getBalance() < 0)
            {
                System.out.println("Overdrawn");
            }
        }
    }

    private synchronized void makeWithdrawal(int amount)
    {
        if(account.getBalance() >= amount)
        {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try
            {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdraw");
        }
        else
        {
            System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
        }
    }


}
