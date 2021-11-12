import apcslib.*;
import java.util.Scanner;
public class tree {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Give me the size");
		int size = input.nextInt();
		System.out.println(Format.right("*",size +1));
		for (int cnt = size; cnt > 1; cnt--) {
			System.out.println(Format.right("*")+Format.right("*"));

		}
	}

}
