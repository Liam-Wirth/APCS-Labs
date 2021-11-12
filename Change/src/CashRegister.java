import java.util.Scanner;
/*
Author Liam Wirth
LAB: LA 4.1 Change
Created September 2nd
 Description: Given an input of the cost of an item, and the amount of cash a customer paid, the code is able to output
 the amount of coins due in change, as well as dollars.

 */
public class CashRegister {
	public static void main(String[] args){
		System.out.println("Hello! Welcome to WallBart (not to be affiliated with Wallmart)");
		System.out.println("Please input the cost of the item purchased");
			Scanner input = new Scanner(System.in); //declaring my scanner
				char ryan = 3486;
				double cost = Double.parseDouble(input.nextLine()); //this takes the input from the scanner and makes a double from it
		System.out.println("Thanks! Now all I need is the amount of cash the customer gave you for this item");
				double cash = Double.parseDouble(input.nextLine()); //this takes the input from the scanner and makes a double from it
		System.out.println("Thanks Human! I'm off to do my robot magic! I'll be back with your change amounts in a jiffy!");
				int[] changeDue = change.Calc(cost, cash); //assigning the output of my change calculator
		                                                   //to an array called changeDue.
					int dollarsOwed = changeDue[1];
					int changeOwed  = changeDue[0]; //I technically don't need to declare this variable, but it makes it easier
													//but declaring it basically just labels what that value in the array is
				int[] coins=change.Coins(changeOwed);
					int quarters=coins[0];  //pulling the data from my array and assigning it to an individual variable
					int dimes   =coins[1];  // I understand this isn't neccessary, but it makes my code more concise and
					int nickels =coins[2];  //easier to understand in the print statements later, that way another person
					int pennies =coins[3];  //could understand what I'm printing

		System.out.println("Amount of Purchase: " +cost);
		System.out.println("Cash Tendered: " +cash);
		System.out.println("Well, you owe a total of"); //this is the output,

		if(dollarsOwed>0){
			System.out.println("    " + dollarsOwed+ " Dollars and " + changeOwed + " cents, in coins that is "); //this for loop sets up a way for the code to only print out
														// what it needs to print out and nothing else. IE if there are
											           //no dollars owed, it won't say "you owe 0 dollars" it will just
													  // skip that line instead
			System.out.println("");

		} else{
			System.out.println("    " + changeOwed+ "cents" );
		}
		if(quarters>0){
			System.out.println("        " + quarters + " Quarters");//doing the same thing for quarters
		}
		if(dimes>0){
			System.out.println("        " + dimes+ " dimes"); //same for dimes
		}
		if(pennies>0){
			System.out.println("        " + pennies+ " pennies"); //same for pennies



		}
	}
}
