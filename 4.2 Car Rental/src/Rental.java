import apcslib.*;
/*
Author Liam Wirth
LAB: LA 4.2 Car Rental
Version 1.0 Created September 5th
Description: Given an input of the cost of an item, and the amount of cash a customer paid, the code is able to output
the amount of coins due in change, as well as dollars.
 */
//ABC 123
import chn.util.ConsoleIO; //this is basically scanner but baby mode

public class Rental {
	public static void main(String[] args) {
		System.out.println("Welcome to Hurtz rental cars database, please enter the licence plate");
		ConsoleIO input = new ConsoleIO();
		String carLetters = input.readToken();
		int carNumbers = input.readInt();
		System.out.println("Thanks, now Please tell me the make of the car");
		String make = input.readLine();                         //storing the given make of the car
		System.out.println("Ok, and the model?");
		String model = input.readLine();                        //storing the given model of the car
		char[] letter = new char[carLetters.length()];          //constructing a char array
		int asciiSum = 0;                                       /* creating my asciiSum integer that will be used
		                                                           in my for loop */


		for (int i = 0; i < carLetters.length(); i++) {         //for loop to index carLetters string
			letter[i] = carLetters.charAt(i);                   //adds the given character to my predefined array
			asciiSum = asciiSum + (int) letter[i];              //casts this character to an integer (converts to
																// ascii)
																// then adds this to my asciiSum integer
		}
		int stepD = asciiSum + carNumbers;                      //step D in the instructions
		int stepE = stepD % 26;                                 //step E in the instructions
		char stepF = (char) (stepE + 'A');                      //step F in the instructions, same idea as what I
		// did for line 21
		String usrInput = (carLetters + " " + carNumbers);      // just to make my print statements easier
		System.out.println("Make  = " + make);
		System.out.println("Model = " + model);
		System.out.println(usrInput + " = " + stepF + stepD);
		System.out.println("Have a wonderful day!");
	}

}
