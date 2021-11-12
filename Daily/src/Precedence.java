import java.util.Scanner;

public class Precedence {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println(" Give me an integer");
		int num= input.nextInt();
		System.out.println("\nnum="+num+ "++num= "+(++num));
		System.out.println("num="+num+ "--num= "+(--num));
		System.out.println("\nnum="+num+ "num++= "+(num++));
		System.out.println("num="+num+ "--num= "+(num--));


	}
}
