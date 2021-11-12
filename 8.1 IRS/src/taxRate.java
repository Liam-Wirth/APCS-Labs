public class taxRate {
	public double percentage; //has to be a value between 0 and 1
	public double flatRate; //the flatrate (if applicable))
	public double remainder; //remainder duh, I don't remember exactly why I need it but I do so ratio
	taxRate(){

	}
//custom datatype for return statements.
	taxRate(double percentage1) {
		percentage = percentage1/100;
		remainder  = 1-percentage;
	}
	taxRate( double percentage1, double flatRate1){
		flatRate =(double)flatRate1;
		percentage =(double) percentage1/100;
		remainder =(double) 1-percentage;
	}

}
