public class teacher extends Person { // ok now I have the sub class what am I supposed to do, I know for
protected double Salary;
protected String Subject;
	public teacher(String Myname, int Myage, String Mygender, String Subject, double Salary) {
		super(Myname, Myage, Mygender); //constructing my super, why don't I construct some bitches damn
		this.Salary = Salary;
		this.Subject = Subject;
	}
	public String toString(){ //what if I whent TO some bitches dayum!
		return super.toString()+ ", Salary:" + Salary + ", Subject: " + Subject;
	}


}

