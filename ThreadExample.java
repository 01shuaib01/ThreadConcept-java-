
        /** Thread Example program
        * This program to understand how Thread are works.
        */


//This program is SYNCHRONIZED MANNER(Means priority basses).

import java.util.Scanner;       //Package of Scanner class (given user input).
       

class Account {
    private int bal;

    public Account(int bal) {
        this.bal = bal;
    }

    public boolean isSufficientBalance(int w) {
        if (bal > w)
            return true;
        else
            return false;
    }

    public void withdraw(int amt) {
        bal = bal - amt;
        System.out.println("Withdraw money is " + amt);
        System.out.println("your current balance is " + bal);

    }
}

class Customer implements Runnable {
    private String name;
    private Account account;

    public Customer(Account account, String n) {
        this.account = account;
        name = n;
    }

    public void run() {
        Scanner kb = new Scanner(System.in);

        synchronized (account) {                //means code run parallal

            System.out.println(name + ", Enter Amount to withdraw");
            int amt = kb.nextInt();
            if (account.isSufficientBalance(amt)) {
                System.out.println(name);
                account.withdraw(amt);
            } else
                System.out.println("Insufficient Balance");
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Account a1 = new Account(1000);
        Customer c1 = new Customer(a1, "shuaib");
        Customer c2 = new Customer(a1, "Iram");

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();

    }

}


/** IF YOU WANT KNOW HOW PROCESER LINE BY LINE CONNECT TO PROCESS 
 *  TO CHECK THIS CODE AND EXICUTE THIS PROGAM.
 */


// class A extends Thread{
//     public void run(){
//         int i;
//         for(i=1;i<=10;i++)
//             System.out.println("i = "+i+"Thread A");
//     }
// }

// class B extends Thread{
//     public void run(){
//         int i;
//         for(i=1;i<=10;i++)
//             System.out.println("i = "+i+"Thread B");
//     }
// }

// public class thread2 {
//     public static void main(String[] args){
//         A obj1=new A();
//         B obj2=new B();
//         obj1.start();
//         obj2.start();
//     }
// }
