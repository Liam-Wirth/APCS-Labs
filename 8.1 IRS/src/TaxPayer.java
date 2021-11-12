import java.util.Objects;

public class TaxPayer {
	private boolean maritalStatus;
	private double taxableIncome;
	private double federalTax;
	private double remainingMoney;

	TaxPayer() {

	} //null constructor

	TaxPayer(boolean maritalStatus, double taxableIncome) {
		maritalStatus = this.maritalStatus; //IDE says that this is always false, but it never really is false.
		taxableIncome = this.taxableIncome;
		calcTaxRate(); //using my helper method to calculate the taxrate, will use the values returned later
		//the values returned are held in my taxRate datatype.

	}

	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	public boolean getFilingStatus(){
		return maritalStatus;
	}

	public double getTaxableIncome() {
		return taxableIncome;
	}
	public double getFederalTax(){
		double temp = taxableIncome* Objects.requireNonNull(calcTaxRate()).percentage;

			temp = (double) temp - calcTaxRate().flatRate;
			return temp;

	}

	private taxRate calcTaxRate() { //helper method to consolidate all of those silly little if/else statements out of my tax calculation method.
		//this else statement should connect to the first one but i don't know why the ide is telling me that I am missing a return statement smh
		if (maritalStatus) { //if it's true
			if (taxableIncome < 45200) {
				return new taxRate(15);
			} else if (taxableIncome >= 45200 && taxableIncome < 109250) {
				return new taxRate(27.5, 6780);
			} else if (taxableIncome >= 10950 && taxableIncome < 166500) {
				return new taxRate(30.5, 24393.75);
			} else if (taxableIncome >= 166500 && taxableIncome < 297350) {
				return new taxRate(35.5, 41855);
			} else if (taxableIncome >= 297350) {
				return new taxRate(39.1, 88306);
				//tedious crap
			}
		} else {
			if (taxableIncome < 27050) {
				return new taxRate(15);
			} else if (taxableIncome >= 27050 && taxableIncome < 65550) {
				return new taxRate(27.5, 4057.5);
			} else if (taxableIncome >= 65550 && taxableIncome < 136750) {
				return new taxRate(30.5, 24393.75);
			} else if (taxableIncome >= 136750 && taxableIncome < 297350) {
				return new taxRate(35.5, 36361.00);
			} else{
				return new taxRate(39.1, 93374);
				//tedious crap
			}

		}

		return null;
	}
	public boolean isMaritalStatus() {
		return maritalStatus;
	}
	public String maritalStatus(){
		if (maritalStatus){
			return "Married";
		}
		else{
			return "Single";
		}
	}

	public double getRemainingMoney() {
		return remainingMoney;
	}

	public void setMaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
}
