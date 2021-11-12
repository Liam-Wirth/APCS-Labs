public class change {
	public static int[] Calc(double cost, double cash) {
		double temp;
		int wholeChange;                      //declaring some variables
		int change;                           //declaring some variables
		temp = cash - cost;
		wholeChange = (int) temp;
		temp = temp - (int) temp + 0.00001; /*   this code was included in the lab, I asked someone in a discord server what it does, and they said
											        This is called casting, it basically takes the value of temp as a double
													and converts it to an integer, and so now (int)temp is like a separate
													variable from just regular temp, and can be used as such.
											 */
		change = (int) (temp * 100);
		return new int[]{change, wholeChange}; /* now I set the return statement to an array so that I can retrieve
												two values from one method's return statement
												*/
	}
	public static int[] Coins(int change) {// ok this is the hard part, I think I can do this with the modulo operator
											//update, sorta, I don't really 100 percent know how all this works but i somehow managed to write all this code
											//so I guess that's that
		System.out.println(change);
		int quarters = Math.round((int) change / 25);
			change = change % 25;                     /* I don't know why i need this line, but I do, so it's here
														*/
		int dimes = Math.round((int) change / 10);
			change = change % 10;                     //determining the amount of dimes
		int nickels = Math.round((int) change / 5);
			change = change % 5;                      //determining the amount of pennies
		int pennies = Math.round((int) change / 1);


		return new int[]{quarters, dimes, nickels, pennies};
	}
}