import java.util.Scanner;

import static java.lang.Math.sqrt;

/** Write a description of the program here
 * Just does the quadratic formula
 * Describe the purpose of this program: Solves for the quadratic formula given a b and c
 * The author of this program: Liam Wirth
 * The creation date: September 2019
 * Version of the program: 1.0
 */
public class Quadratic {
	public static double truncater(double input) { //oh yeah baby, encapsulation baby oh yeah baby, monday baby
		input = input * 10000;
		input = (double) Math.round(input) / 10000;
		return input;
	}
	public static double[] quadratic(double a, double b, double c){
		double bsquare= Math.pow(b, 2);
		double[] out = new double[2];
			double numerator = sqrt(bsquare + (-4) * (a * c));
		double root1 = truncater((-b + numerator)/(2*a));
		double root2 = truncater((-b - numerator)/(2*a));
		out[0]=root1;
		out[1]=root2;
		return out;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the RootFinder 3000!");
		System.out.println("Please give me the coefficient of A");
		double A = input.nextDouble();
		System.out.println("Please give me the coefficient of B");
		double B = input.nextDouble();
		System.out.println("Please give me the coefficient of C");
		double C = input.nextDouble();
		double roots[] = new double[2];
		roots = quadratic(A, B, C);
		System.out.println("The first root of the function is  " +roots[0]);
		System.out.println("The second root of the function is  " +roots[1]);

	}


}
