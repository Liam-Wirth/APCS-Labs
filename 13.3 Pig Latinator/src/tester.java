import java.util.Locale;
import java.util.Scanner;

public class tester {
	public static void main(String[] args) throws Exception {
		boolean Continue = true;
		while(Continue) {
			System.out.println("I am an awesome robot that can convert anything you say into pig latin!");
			System.out.println("Alrighty, please give me a phrase!");
			Scanner input = new Scanner(System.in);
			String usrIn = input.nextLine();
			Latinator2 Latinator = new Latinator2(usrIn);
			Latinator.Translate();
			System.out.println(Latinator.genOutput());
			System.out.println("Would you like to continue? (Y/N)");
		 if(input.nextLine().toLowerCase()=="n"){
				 Continue = false;

			}else if(input.nextLine().toLowerCase() != "y" && input.nextLine().toLowerCase() != "n"){
				throw new Exception("That is not a valid answer");

			}
		}

	}
}
