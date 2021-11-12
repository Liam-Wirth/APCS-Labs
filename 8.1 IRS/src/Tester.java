import java.util.Scanner;

/** Write a description of the program here calculates taxes
 * Describe the purpose of this program calculates taxes
 * The author of this program: me
 * The creation date: i don't care
 * Version of the program: no
 */
public class Tester {
	private static boolean maritalStatus = true;

	public static String maritalStatus() {
		if (maritalStatus) {
			return "Married";
		} else {
			return "Single";
		}
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean b1 = true;
		while (b1) {
			System.out.println("Are you Married? (True/False) ");
			maritalStatus = input.nextBoolean(); //if bool == true then married, else is single
			System.out.println("Now give me your taxable income");
			double income = input.nextDouble();
			TaxPayer taxes = new TaxPayer(maritalStatus, income);
			taxes.setTaxableIncome(income);
			taxes.setMaritalStatus(maritalStatus);
			System.out.println(maritalStatus() + ",  $" + taxes.getFederalTax());
			System.out.println("(True/False) would you like to calculate taxes again for another person?");
			b1 = input.nextBoolean();
		}


	}
}

