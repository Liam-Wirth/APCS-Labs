import java.util.Scanner;

public class tester {
	public static void main(String[] args){

		System.out.println("I am an awesome robot that can convert anything you say into pig latin!");
		System.out.println("Alrighty, please give me a phrase!");
		Scanner input = new Scanner(System.in);
		String usrIn = input.nextLine();
		Latinator Latinator = new Latinator(usrIn);
		Latinator

	}
}
