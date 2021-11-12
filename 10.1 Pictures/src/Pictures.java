import java.util.Scanner;

/** Write a description of the program here kill I draw cool yep awesome
 * Describe the purpose of this program sawomeofendskjfas
 * The author of this program: me
 * The creation date: way too late at night
 * Version of the program: you can bet your ass this will be the last version I write
 */
public class Pictures {
	public static void printTable(int rows, int columns) {
		System.out.print(" ");
		for (int top = 1; top <= columns; top++) {
			if (top < 10) {
				System.out.print("    " + top);
			} else {
				System.out.print("   " + top);                //let me go to sleep
			}                                             //asfhajfkdhlaksfhuiahvlkjnsda
			                     //kill I am tired kill

		}
		System.out.println();
		for (int row = 0; row + 1 <= rows; row++) {       //don't ask me why i'm doing it this way I don't care enough to answer thanks
			if (row < 10 || row > 100) {                      //don't ask me why i'm doing it this way I don't care enough to answer thanks
				System.out.print(row + " ");
			} else {
				System.out.print(row);
			}
			for (int col = 1; col <= columns; col++) {           //reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
			                                                   //reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
				int product = row * col;                        //reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
				//reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
				if (product < 10) {                              //reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
					System.out.print("   " + product + " ");    //reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
				}                                               //reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
				else if (product >= 100) {                        //reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
					System.out.print(" " + product + " ");      //reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
				}                                               //reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
				else {                                           //reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
					System.out.print("  " + product + " ");     //reminder to write comments for all of these lines!!! I can do it in class tommorrow!!! ☺
				}
			}

		                 //more comments I am so awesome wowowowowowowowowoowowowow
		              //uses print method to pass argument "______"


			System.out.println();
			//Ok now that I am done with all of that STuPID!!!!! stuff I am now going to do the box
			// / outline part of this where I make it all pretty or whatever and give it an outline it is now 1:41 AM and I am going to commit homicide
		}


		for (int cnt = 0; cnt < columns; cnt++) {
			System.out.print("______");
		}                                         //woops ok now I do the other STUPID method kill

	}

	public static void pyramidthing(int size) {
		System.out.println("");
		int currentLine, starCount, pcnt;
		for (currentLine = 1; currentLine <= size; currentLine++) {
			for (starCount = currentLine; starCount < size; starCount++) {
				System.out.print(" ");
			}

			for (pcnt = 1; pcnt < (currentLine * 2); pcnt++) {
				System.out.print("*");
			}

			System.out.println();
		}


	}

	public static void main(String[] args) {    /*
		                                       I'm gonna be honest, I can't be bothered to make two classes for this
		                                       rather silly little lab, it's litterally 1:52 in the morning and I am
		                                       literally bullshitting my way through this lab as I listen to Carti,
		                                       this some real vamp shit I swear
		                                       */
		Scanner input = new Scanner(System.in);
		printTable(4, 6);
		String get;
		get = input.nextLine(); // freezes the output screen to see the picture
		printTable(11, 12);
		get = input.nextLine();
		pyramidthing(10);
		get = input.nextLine();
		pyramidthing(25);
		get = input.nextLine();
	}
}                           