package liamassets;
public class Formatting {
	public static double truncater(double input){ //oh yeah baby, encapsulation baby oh yeah baby, monday baby
		input = input*100;                           //multiplying input by 100
		input = (double) Math.round(input)/100;     //rounding that input by 100, then I am dividing it by 100
		return input;                               //method then returns the input, truncated
	}
	public static String indenter(String input){  //java formating is weird and hard to understand so here's my own little loophole thingy to fix it
		String indent = "                              "; //30 spaces
		input += indent.substring(0, indent.length() - input.length());
		return input;

	}

}
