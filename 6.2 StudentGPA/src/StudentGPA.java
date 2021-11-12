import static java.lang.Math.*;

public class StudentGPA {
	private String myName;        // student's name
	private String myID;          // student's ID
	private int myTotalPoints;    // sum of all grades entered
	private int myNumGrades;      // number of grades entered
	private double myGPA;         // student's GPA
	public StudentGPA(String myName2, String myID2){
		//constructor method
		myName        = myName2;
		myID          = myID2;
		myGPA         = 0;
		myNumGrades   =0;



	}
	public void addGrade(int grade){
		myNumGrades++;            //adds 1 to the counter everytime this method is called.
		myTotalPoints += grade;   // I'm like 90 percent sure that this is going to just add it to mytotalpoints
		myGPA = (double) myTotalPoints/myNumGrades;
		myGPA = (double) (round((myGPA*100)))/100;
	}
	public double getMyGPA() {
		return myGPA;
	}

	public int getMyNumGrades() {
		return myNumGrades;
	}

}
