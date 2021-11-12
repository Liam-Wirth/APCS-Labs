import java.util.Scanner;

/** Write a description of the program here this code checks to see whether or not a given input is a palindrome.
 * Describe the purpose of this program l;dkfsahlhg
 * The author of this program:Liam Wirth
 * The creation date: Yesterday
 * Version of the program: 1.0
 */
public class Tester {
	public static void main(String[] args){
		String quit = null;
		String check = "q";
		boolean ContinueChecking = true;
		while(ContinueChecking){
			Scanner input = new Scanner(System.in);
			System.out.println("Beep Boop, I'm Bob the palendrome bot!! give me a word to check! beep boop");
			String usrIn = input.nextLine();
			String modusrIn = usrIn.replaceAll("\\s","");    //this line removes any excess whitespace on the inputted string
			modusrIn = usrIn.toLowerCase();// here I am making the string all lowercase, so it is not case sensitive.
			String poopShit = "";
			for (int counter = 0; counter <= modusrIn.length()-1; counter++) {       //deez method for deez
				char temp = modusrIn.charAt(counter);
				if(Character.isLetterOrDigit(temp)){
					poopShit += temp;
				}
			}
			PalindromeChecker checkIn = new PalindromeChecker(poopShit);      //initializing my palindrome checker
			checkIn.reverseBuild();                                           //using the two methods of my checker to initialize it's variables
			checkIn.palindromecheck();                                        //what I said above bozo, read.

			if (checkIn.isPalendrome() && poopShit.length() > 1){                                       //now it is doing the output
				System.out.println("zoo wee mama! ");
				System.out.println("Looks like " + usrIn + " Is a palindrome!");
			}
			else{
				System.out.println("Alright bozo, " + usrIn + " is not a palindrome");
			}
			System.out.println("Would you like to check another palindrome? if so, please hit enter, otherwise type the letter Q to quit");
			if (input.nextLine().toLowerCase().replaceAll("\\s","").equals(check)){
				ContinueChecking = false;
			}
		}

	}
}
