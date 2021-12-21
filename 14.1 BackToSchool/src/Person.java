public class Person {
	protected String myName;   // name of the person
	protected int myAge;        // person's age
	protected String myGender;  // "M" for male, "F" for female <--- checkmate liberals, only 2 genders. OWNED

	// constructor
	public Person(String Myname, int Myage, String Mygender) { //take note, only constructing TWO genders!!!!!!!!
		this.myName = Myname;
		this.myAge = Myage;
		this.myGender = Mygender;
	}

	public int getMyAge() { //getter method
		return myAge;
	} //getter method

	public String getMyGender() { //setter method
		return myGender;
	} //setter method

	public String getMyName() { //getter method
		return myName;
	} //getter method

	public void setMyAge(int myAge) { //setter method
		this.myAge = myAge;
	} //setter method

	public void setMyGender(String myGender) { //getter method
		this.myGender = myGender;
	} //setter method that sets my gender
	

	public void setMyName(String myName) { //setter method
		this.myName = myName;
	}

	public String toString() {
		return myName + ", age: " + myAge + ", gender: " + myGender;
	} //another to string I have no clue why I hae this again doesn't this just refer to the master branch or some shit
}
