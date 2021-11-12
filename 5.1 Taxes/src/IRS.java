/* Write a description of the program here
  Describe the purpose of this program; Calculates tax rates
  The author of this program: Liam Wirth
  The creation date: September 19th
  Version of the program: 1.0
 */
//test for 25 hours
//test for 6.75 an hour
import apcslib.*;
import chn.util.*;

import java.util.Scanner;
public class IRS {
	static final double   fedTax = 0.15; //declaring my variable
	static final double     FICA = 0.0765; //re declaring my variable
	static final double stateTax = 0.04;    // declaring another variabl
	//the below method just takes an input given, rounds it off to 2 decimal places, and then returns that rounded input.
	public static double truncater(double input){ //oh yeah baby, encapsulation baby oh yeah baby, monday baby
		input = input*100;                           //multiplying input by 100
		input = (double) Math.round(input)/100;     //rounding that input by 100, then I am dividing it by 100
		return input;                               //method then returns the input, truncated
	}
	public static taxReturn taxCalc(double grossPay){
	double fedReturn   = truncater(grossPay*fedTax);   //using the method to round my numbers now
	double FICAReturn  = truncater(grossPay*FICA);     //using the method to round my numbers now
	double stateReturn = truncater(grossPay*stateTax); //using the method to round my numbers now
	double netTax = fedReturn + FICAReturn +stateReturn;     //now I am doing some math for my outputs
	double netPay = truncater(grossPay-netTax);         // now I'm using that above method to truncate my variable
	return new taxReturn(fedReturn, FICAReturn, stateReturn, netPay);
	}
	public static String indenter(String input){  //java formating is weird and hard to understand so here's my own little loophole thingy to fix it
		String indent = "                              "; //30 spaces
		input += indent.substring(0, indent.length() - input.length());
		return input;

	}
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.println("Please tell me the amount of hours worked");
		int hrsWorked = input.nextInt();
		System.out.println(hrsWorked + " Hours? Ok, now tell me the Hourly Pay Rate");
		double payRate = input.nextDouble();
		final double grossPay =truncater(payRate*hrsWorked);
		taxReturn taxes = taxCalc(grossPay); //using my method written here to send my returns to that class I made that
											 //holds my data types.
		System.out.println(indenter("Hours Worked") +hrsWorked); //my output
		System.out.println(indenter("Hourly Rate")  +payRate);  //yep an output
		System.out.println();   //printing an empty line for formatting
		System.out.println(indenter("Gross Pay") +grossPay); //next output, the grosspay
		System.out.println();// empty line for formatting
		System.out.println(indenter("Federal Tax" + "( " + fedTax*100 +"%" + ")") +taxes.getFedTax()); //another output
		System.out.println(indenter("FICA"  + "( " + truncater(FICA*100) +"%" + ")") +taxes.getFICA()); //encapsulation baby
		System.out.println(indenter("State Tax"+ "( " + stateTax*100 +"%" + ")") +taxes.getStateTax());
		System.out.println();// empty line for formatting
		System.out.println(indenter("Net Pay") + taxes.getNetPay()); //next output, the net pay after all taxes have been deducted.






	}
}

