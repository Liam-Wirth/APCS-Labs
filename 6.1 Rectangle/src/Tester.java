import java.util.Scanner;

/** Write a description of the program here agony, suffering, pain, dismay. hell.
 * Describe the purpose of this program to cause me endless suffering
 * The author of this program: me
 * The creation date: burning sun.
 * Version of the program:
 */
public class Tester {
	public static void main(String[] args) {
		//Rectangle square1 = new Rectangle(20, 20, 20,20);
		//square1.Draw();
		//System.out.println("Area = " +square1.GetArea());
		//System.out.println("Perimeter = " +square1.GetPerimeter());

		GameAssets gameboard = new GameAssets();


		Scanner input = new Scanner(System.in);

		gameboard.buildGame();
		System.out.print("1 2 3" + "\n" + "4 5 6 " + "\n" + "7 8 9" + "\n");
		String winner = gameboard.checkWinner();
		while (winner == null) {
			for (int i = 1; i < 10; i++) {
				 {
					if (i % 2 == 0) {
						System.out.println("Player 2, please choose your square");
						int move = input.nextInt();
						if(gameboard.getSquare(move).getState() == null) {
							gameboard.drawX(gameboard.getSquare(move));
							gameboard.getSquare(move).setState("X");
							winner = gameboard.checkWinner();
						}else{
							System.out.println("Hey! You can't do that! That spot's already taken!");
							i=i-1;
						}
					} else {
						System.out.println("Player 1, please choose your square");
						int move = input.nextInt();
						if(gameboard.getSquare(move).getState() == null) {
							gameboard.drawO(gameboard.getSquare(move));
							gameboard.checkWinner();
							gameboard.getSquare(move).setState("O");
						}else{
							System.out.println("Hey! You can't do that! That spot's already taken!");
							i=i-1;
						}
						winner = gameboard.checkWinner();
					}
					winner = gameboard.checkWinner();
				}
			}
			if (winner == null) {
				System.out.println("Game Over! Draw!");
			} else {
				System.out.println("Game over! " + winner + " Wins!");
			}




		}

	}
}
