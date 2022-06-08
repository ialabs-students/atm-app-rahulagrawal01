package ATM

import java.util.Scanner;
import java.lang.*;

//Remember this is ATM not user account
class AtmMachine {
    AtmMachine() {
        start();
    }

    int totalBalanceInATM = 0;
    int T2000 = 0;
    int T500 = 0;
    int T200 = 0;
    int T100 = 0;
    Scanner sc = new Scanner(System.in);

    void start() {
        System.out.println("1 for Deposit money: ");
        System.out.println("2 for Withdraw money: ");
        System.out.println("3 for Balance enquiry: ");
        System.out.print("4 for EXIT \n-> ");
        byte what = 0;
      
      
      
      
        try {
            what = sc.nextByte();
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (what) {
            case (1) -> deposit();
            case (2) -> withdraw();
            case (3) -> enquiry();
            case (4) -> System.exit(0);
            default -> {
                System.out.println("Please enter valid input");
                start();
            }
        }
    }
  
  
  

    void deposit() {
        int ToDeposit = 0;
        System.out.print("2000 X ");
        T2000 = sc.nextInt();
        ToDeposit += 2000 * T2000;

        System.out.print("500 X ");
        T500 = sc.nextInt();
        ToDeposit += 500 * T500;

        System.out.print("200 X ");
        T200 = sc.nextInt();
        ToDeposit += 200 * T200;

        System.out.print("100 X ");
        T100 = sc.nextInt();
        ToDeposit += 100 * T100;
        totalBalanceInATM += ToDeposit;
        canDeposit(ToDeposit);
        System.out.println("You have deposited " + ToDeposit);
        start();
    }
  
  
  
  

    void withdraw() {
        System.out.print("How much money you want to withdraw \nEnter in multiple of 100 -> ");
        int amountToWithdraw = sc.nextInt();
        canWithdraw(amountToWithdraw);
        totalBalanceInATM -= amountToWithdraw;
        if (amountToWithdraw % 100 != 0) {
            System.out.println("Enter amount multiple of 100");
            start();
        }
        byte C2000 = 0;
        byte C500 = 0;
        byte C200 = 0;
        byte C100 = 0;
      
      
      
        while (amountToWithdraw != 0) {
            if (amountToWithdraw >= 2000 && T2000 > 0 && Math.floor(amountToWithdraw / 2000) > 0) {
                amountToWithdraw -= 2000;
                C2000++;
                T2000--;
            } else if (amountToWithdraw >= 500 && T500 > 0 && Math.floor(amountToWithdraw / 500) > 0) {
                amountToWithdraw -= 500;
                C500++;
                T500--;
            } else if (amountToWithdraw >= 200 && T200 > 0 && Math.floor(amountToWithdraw / 200) > 0) {
                amountToWithdraw -= 200;
                C200++;
                T200--;
            } else if (amountToWithdraw >= 100 && T100 > 0 && Math.floor(amountToWithdraw / 100) > 0) {
                amountToWithdraw -= 100;
                C100++;
                T100--;
            } else {
                System.out.println("This note is not available");
                totalBalanceInATM += amountToWithdraw;
                amountToWithdraw = 0;
            }
        }
        System.out.println(C2000 + " of 2000's notes");
        System.out.println(C500 + " of 500's notes");
        System.out.println(C200 + " of 200's notes");
        System.out.println(C100 + " of 100's notes");
        start();
    }
  
  
  
  

    void enquiry() {
        System.out.println("Total available balance is " + totalBalanceInATM);
        start();
    }
  
  
  
  

    void canDeposit(int i) {
        if (i < 0) {
            System.out.println("Incorrect deposit amount");
            start();
        } else if (i == 0) {
            System.out.println("Deposit amount cannot be zero");
            System.out.println("Try again ! ");
            start();
        }
    }
  
  
  
  

    void canWithdraw(int j) {
        if (j <= 0) {
            System.out.println("Incorrect withdraw amount");
            start();
        } else if (j > totalBalanceInATM) {
            System.out.println("Insufficient funds");
            System.out.println("Try again ! ");
            start();
        }
    }
}




public class ATM {
    public static void main(String[] args) {
        new AtmMachine();
    }
}
