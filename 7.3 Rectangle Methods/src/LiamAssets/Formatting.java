package LiamAssets;
import java.lang.StringBuffer;
public class Formatting {
	public static double truncater(double input){ //oh yeah baby, encapsulation baby oh yeah baby, monday baby
		input = input*100;                           //multiplying input by 100
		input = (double) Math.round(input)/100;     //rounding that input by 100, then I am dividing it by 100
		return input;                               //method then returns the input, truncated
	}
	public static String indenter(String input, int indentLength){
		StringBuilder indent = null;
		for (int i = 0; i <indentLength ; i++) {
			indent.insert(i," ");
		}
		assert indent != null;
		input += indent.substring(0, indent.length() - input.length());
		return input;

	}

}