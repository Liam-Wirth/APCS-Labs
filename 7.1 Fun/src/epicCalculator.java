public class epicCalculator {
	/** Write a description of the program here vbasically it does a bunch of math stuff yep that's what it do
	 * Describe the purpose of this program yep to do a byunch of math stuff
	 * The author of this program: liam wirth
	 * The creation date: idunno today
	 * Version of the program: 1 lol
	 */
	public static double fToC(double fahrenheit){ //converts fahrenheit to celsius
		double output = (double)((fahrenheit-32)*(5/9));
		double bigOut = output*100;
		output = (double) (Math.round(bigOut)/100);
		return output;
	}

	public static double cTof(double celsius){  //does the other convert i dunno
		double output = (double)((celsius)*(9/5))+32;
		double bigOut = output*100;
		output = (double) (Math.round(bigOut)/100);
		return output;
	}
	public static double radToVolume(double radius){ //converts radius to volume
		double radcube= (double)((Math.pow(radius,3)));
		double part  =  (double)(4/3)*(Math.PI);
		double messyVol = part*radcube;
		return (double)((Math.round(messyVol*100))/100);
	}
	public static double pythag(double a, double b){ //does the pythagorean theorem
		double cMessy = (double) Math.sqrt((Math.pow(a,2)+(Math.pow(b,2))));
		return (double) (Math.round(cMessy*100)/100);
	}

}
