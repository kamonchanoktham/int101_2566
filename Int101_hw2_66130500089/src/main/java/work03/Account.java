
package work03;

import work01.Utilitor;
import work02.Person;


public class Account {
    private static long nextNo = 100_000_000; 
    private final long no; 
    private Person owner; 
    private double balance; 

    public Account(Person owner) { 
        if (owner == null) {
            throw new NullPointerException();
        }
        this.owner = owner;
        this.balance = 0.0;
        int result = Utilitor.computeIsbn10(nextNo);
        while (result == 10) {
            nextNo++;
            result = Utilitor.computeIsbn10(nextNo);
        }
        this.no = 10 * nextNo + result;
        nextNo++;
    }

    public long getNo() { 
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }
    
    public double deposit(double amount){ 
        Utilitor.testPositive(amount);
        balance+=amount;
        return balance;
    }
    
    public double withdraw(double amount){ 
         Utilitor.testPositive(amount);
        balance-=amount;
        return balance;
    }
    public void transfer(double amount, Account account){ 
        if(account == null || amount > balance){
            throw new IllegalArgumentException();
        }
        this.balance-=amount; 
        account.balance+=amount;
    }

    @Override
    public String toString() { 
        return "Account(" +no+","+balance+")";
    }

    @Override
    public boolean equals(Object obj) { 
        return this == obj;
    }
}
