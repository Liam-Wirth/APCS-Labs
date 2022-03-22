import apcslib.*;
import chn.util.*;
import java.awt.Color;
public class Main{
    CheckingAccount errorFree = new CheckingAccount();
    public ConsoleIO c = new ConsoleIO();
    double getAmt=0;
        do{
        System.out.print("Please enter the starting balance --> ");
        getAmt=c.readDouble();
        try{ //first try


            if (getAmt < 0){
                throw new ArithmeticException();
            }
            errorFree =new CheckingAccount(getAmt); //creates the instance error free
            System.out.println("Account opened with balance of " + getAmt);
        }

        catch(ArithmeticException e){//first catch for an ArithmeticException
            System.out.println("Error CheckingAccount: negative initial balance");
        }



    }while (getAmt<0);

    double getDepositAmt=0;
        do{
        System.out.print("Please enter the amount to deposit --> ");
        getDepositAmt=c.readDouble();//reads getDepositAmt
        try{ //second try


            if (getDepositAmt  < 0){
                throw new ArithmeticException();
            }
            errorFree.deposit(getDepositAmt);
            System.out.println("Deposit made. Current account balance = " + errorFree.getBalance());
        }

        catch(ArithmeticException e){//second catch for an ArithmeticException
            System.out.println("Error deposit: negative amount");
        }



    }while (getDepositAmt<0);//repeats while the deposit amt is negative
    double getWithdrawalAmt=0;
        do{
        System.out.print("Please enter the amount to withdraw --> ");
        getWithdrawalAmt=c.readDouble();//reads getWithdrawalAmt
        try{//thrid try


            if ((getWithdrawalAmt < 0 )||(getWithdrawalAmt > errorFree.getBalance())){//checks if getWithdrawalAmt is negative and if balance is greater getWithdrawalAmt
                throw new ArithmeticException();//this throws a error
            }
            errorFree.withdraw(getWithdrawalAmt);//uses the method withdraw from error free
            System.out.println("Withdrawal made. Current account balance = " + errorFree.getBalance());
        }

        catch(ArithmeticException e){//thrid catch for an ArithmeticException
            System.out.println("Error withdraw: illegal amount");
        }



    }while ((getWithdrawalAmt < 0 )||(getWithdrawalAmt > errorFree.getBalance()));//repeats if getWithdrawalAmt is negative or if getWithdrawalAmt is greater than the balance avilable
        System.out.println("Thank you for using ErrorFreeChecking...goodbye!");//final print output


}
}