package intro.javase.tutorials;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class ReadData_Demo {

    public static void main(String args[]) {
        FileReader fr = null;
        try {
            File file = new File("file.txt");
            fr = new FileReader(file);
            char[] a = new char[50];
            fr.read(a); // reads the content to the array
            for (char c : a)
                System.out.print(c); // prints the characters one by one
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

/**
 * Desc:
 * 
 * <pre>
try-with-resources, also referred as automatic resource management, is a new exception handling mechanism
 that was introduced in Java 7, which automatically closes the resources used within the try catch block.

To use this statement, you simply need to declare the required resources within the parenthesis, and the 
created resource will be closed automatically at the end of the block. Following is the syntax of try-with-resources statement.
 * 
 * </pre>
 * 
 */
class TryWithResources {

    /**
     * <pre>
      * 
      * 
      * To use a class with try-with-resources statement it should implement
      * AutoCloseable interface and the close() method of it gets invoked
      * automatically at runtime.
      * 
      * 
      * You can declare more than one class in try-with-resources statement.
      * 
      * 
      * While you declare multiple classes in the try block of try-with-resources
      * statement these classes are closed in reverse order.
      * 
      * 
      * Except the declaration of resources within the parenthesis everything is
      * the same as normal try/catch block of a try block.
      * 
      * 
      * The resource declared in try gets instantiated just before the start of
      * the try-block.
      * 
      * 
      * The resource declared at the try block is implicitly declared as final.
     * </pre>
     * 
     */
    public static void main(String args[]) {
        try (FileReader fr = new FileReader("E://file.txt")) {
            char[] a = new char[50];
            fr.read(a); // reads the contentto the array
            for (char c : a)
                System.out.print(c); // prints the characters one by one
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

class CheckingAccount {
    private double balance;
    private int number;

    public CheckingAccount(int number) {
        this.number = number;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            double needs = amount - balance;
            throw new InsufficientFundsException(needs);
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }
}

class BankDemo {

    public static void main(String[] args) {
        CheckingAccount c = new CheckingAccount(101);
        System.out.println("Depositing $500...");
        c.deposit(500.00);

        try {
            System.out.println("\nWithdrawing $100...");
            c.withdraw(100.00);
            System.out.println("\nWithdrawing $600...");
            c.withdraw(600.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Sorry, but you are short $" + e.getAmount());
            e.printStackTrace();
        }
    }
}