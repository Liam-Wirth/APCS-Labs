public class Student extends Person {
	protected String myIdNum;    // Student Id Number
	protected double myGPA;      // grade point average

	// constructor
	public Student(String name, int age, String gender,
	               String idNum, double gpa) {

		// use the super class' constructor
		super(name, age, gender);

		// initialize what's new to Student
		myIdNum = idNum;
		myGPA = gpa;

	}
	public String toString(){
		return super.toString() + ", Id Number: " + myIdNum + ", GPA: " +myGPA;
	}
	public String getMyIdNum() {
		return myIdNum;
	} //getter method

	public void setMyIdNum(String myIdNum) {
		this.myIdNum = myIdNum;
	} //setter method

	public double getMyGPA() {
		return myGPA;
	} //getter method

	public void setMyGPA(double myGPA) {
		this.myGPA = myGPA;
	} //setter method
}
