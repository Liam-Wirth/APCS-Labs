public class taxReturn {
	private double fedTax;
	private double FICA;
	private double stateTax;
	private double netPay;
	public taxReturn(double fedTax2, double FICA2, double stateTax2, double netPay2){
		fedTax   = fedTax2;
		FICA     = FICA2;
		stateTax = stateTax2;
		netPay   = netPay2;
	}
    //getter
	public double getFedTax() {
		return fedTax;
	}
	//getter
	public double getNetPay() {
		return netPay;
	}
	//getter
	public double getFICA() {
		return FICA;
	}
	//getter
	public double getStateTax() {
		return stateTax;
	}

}
