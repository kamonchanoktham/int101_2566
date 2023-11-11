package int101.homework02;

import work01.Utilitor;
import work02.Person;
import work03.Account;

public class Int101Homework02Updated {
     
    public static void main(String[] args) {
        work01Utilitor();
        work02Person();
        work03Account();
    }

    static void work01Utilitor() {
        
        System.out.println("work01 Utilitor : ");
        
        try {
            System.out.println(Utilitor.testString(null));
            System.out.println(Utilitor.testString(" "));
        } catch (Exception e) {
        }

        System.out.println(Utilitor.testString("Test testString : " + "Patcharisa"));

        
        try {
            System.out.println(Utilitor.testPositive(-1));
        } catch (Exception e) {
        }
        System.out.println("Test testPositive : " + Utilitor.testPositive(0));
        //computeIsbn10
        System.out.println("Test computeIsbn10 : " + Utilitor.computeIsbn10(999215810));
        /*
       1.1 Create a public utility class named "Utilitor" in package named "work01".
       1.2 Create a public method named "testString" in "Utilitor" class.
           This method receives a parameter of type "String"
           named "value" and it returns the "value" if nothing is wrong.
           However, if the "value" is null, it throws NullPointerException.
           If the "value" is a blank string, it throws IllegalArgumentException.
       1.3 Create a public method named "testPositive" in "Utilitor" class.
           This method receives a parameter of type "double" named "value"
           and it returns the "value" if this "value" is a positive value.
           Otherwise, it throws IllegalArgumentException.
       1.4 Create a public method named "computeIsbn10" in "Utilitor" class.
           This method recieves a parameter of type "long" named "isbn10", which
           consists of 9 digits from position 10 (leftmost) to position 2
           (rightmost). This method returns a value of type "long" that is
           the check-digit for "isbn10". All possible returned values are 0 to 10.
           See https://en.wikipedia.org/wiki/Check_digit for ISBN-10 calculation.
           ** You must use loop to calculate the ISBN-10 check-digit. **
       1.5 Show in this "work01Utilitor" method how to 
           use 1.2-1.4 and check their correctness. */
    }

    static void work02Person() {
        /*
       2.1 Create a public class named "Person" in package named "work02".
           This class contains the following fields and methods.
       2.2 a private static field of type "int" named "nextId" initialized to 1.
       2.3 a private final field of type "int" named "id".
       2.4 a private field of type "String" named "firstname".
       2.5 a private field of type "String" named "lastname".
       2.6 a public constructor that receives "firstname" and "lastname"
           parameters to set the values of "firstname" and "lastname" fields.
           Check the correctness of the values of "firstname" and "lastname"
           parameters with "Utilitor.testString" method first.
           If nothing is wrong, set the value of "id" field to be the value
           of "nextId" field and increment the value of "nextId" by 1.
       2.7 @Override a public "toString" method that returns
           "Person(id,firstname,lastname)" where id, firstname, and lastname
           are the values of the coresponding fields of this "Person" object.
           Use "StringBuilder" to build the output string.
       2.8 public getters for "id", "firstname", and "lastname" fields.
       2.9 public setters for "firstname" and "lastname" fields.
           Use the "Utilitor.testString" method to check
           the correctness of the parameters first.
       2.10 @Override a public "equals" method that returns true
            if this object is the same as the object in the parameter
            (i.e., the same reference). Otherwise, it returns false.
       2.11 Show in this "work02Person" method how to
            use 2.6-2.10 and check their correctness. */
        System.out.println("work02 Person : ");
        try {
            Person per1 = new Person(null, null);
            Person per2 = new Person(" ", "");
        } catch (Exception e) {
        }
        Person per3 = new Person("Yok", "Ka");
        Person per4 = new Person("Kai", "Ja");
        System.out.println("Tesr toString per3 : " + per3);
        System.out.println("Tesr toString per4 : " + per4);
        System.out.println("Test getId per3 : " + per3.getId());
        System.out.println("Test getFirstname per3 : " + per3.getFirstname());
        System.out.println("Test getLastname per3 : " + per3.getLastname());
        per3.setFirstname("Ploy");
        System.out.println("Test setFirstname" + per3);
        per3.setLastname("Yu");
        System.out.println("Test setLastname" + per3);
        System.out.println("Test equals per3 == per4 : " + per3.equals(per4));

    }

    static void work03Account() {
        /*
       3.1 Create a public class named "Account" in package named "work03".
           This class contains the following fields and methods.
       3.2 a private static field of type "long" named "nextNo"
           initialized to 100_000_000.
       3.3 a private final "no" field of type "long".
       3.4 a private "owner" field of type "Person".
       3.5 a private "balance" field of type "double".
       3.6 a public constructor that receives an "owner" parameter of
           type "Person" to set the "owner" field. This method throws
           NullPointerException if the "owner" parameter is null.
           This method sets the value of "balance" to 0.0 and sets 
           the value of "no" field as follows. 
           1) Let result = Utilitor.computeIsbn10(nextNo).
           2) If result is 10, increment the value of "nextNo" by 1 
              and try Step 1) again until the result is not 10. 
           3) Set the value of "no" filed to be 10 * nextNo + the result.
           4) Increment the value of "nextNo" by 1.
       3.7 public getters for "no", "owner", and "balance".
       3.8 a public method named "deposit" that receives a "double" parameter
           named "amount". This method throws IllegalArgumentException
           if "amount" cannot pass "Utilitor.testPositive" method.
           Otherwise, the method adds the "amount" to "balance"
           and then returns the new "balance".
       3.9 a public method named "withdraw" that receives a "double" parameter
           named "amount". This method throws IllegalArgumentException
           if "amount" does not pass "Utilitor.testPositive" method.
           Otherwise, the method subtracts the "amount" from "balance"
           and then returns the new "balance".  However, this method will not
           do so if the new "balance" cannot pass "Utilitor.testPositive" method.
       3.10 a public method named "transfer" that recieves a "double" parameter
            named "amount" and an "Account" parameter named "account".
            This method throws IllegalArgumentException if "account" is null
            or it cannot "withdraw" the "amount" from this object. Otherwise,
            this method "withdraw" the "amount" from this object and "deposit"
            the "amount" to the "account" object.  This method returns nothing.
       3.11 @Override a public "toString" method that returns
            "Account(no,balance)" where "no" and "balance" are
            the "no" and "balance" fields of this object.
       3.12 @Override a public "equals" method that returns true
            if this object is the same as the object in the parameter
            (i.e., the same reference). Otherwise, it returns false.
       3.13 Show in this "work03Account" method how to
            use 3.6-3.12 and check their correctness. */
        System.out.println("work03 Account : ");
        try {
            Person per1 = new Person("Ploy", "Yu");
            Account acc1 = new Account(per1);
            System.out.println("Test deposit :" + acc1.deposit(-4));
            Account acc2 = new Account(null);
        } catch (Exception e) {
        }
        Person per2 = new Person("Yok", "Ka");
        Person per3 = new Person("Kai", "Ja");
        Account acc2 = new Account(per2);
        Account acc3 = new Account(per3);
        System.out.println("Test getNo acc2 :" + acc2.getNo());
        System.out.println("Test getNo acc3 :" + acc3.getNo());
        System.out.println("Test getOwner acc2 : " + acc2.getOwner());
        System.out.println("Test getBalance acc2 : " + acc2.getBalance());
        System.out.println("Test deposit 5000, balance :  " + acc2.deposit(6000));
        System.out.println("Test withdraw 1000, balance :  " + acc2.withdraw(100));
        //Test transfer 1000 to acc2
        acc2.transfer(1000, acc3);
        System.out.println("Test transfer 1000 to acc2, balance acc2 : " + acc2.getBalance() + ", " + "balance acc3 : " + acc3.getBalance());
        System.out.println("Test toString acc2 : " + acc2);
        System.out.println("Test equals acc1 == acc2 : " + acc2.equals(per3));

    }
}