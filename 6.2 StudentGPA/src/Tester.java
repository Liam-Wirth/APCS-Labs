/** Write a description of the program here
 * Describe the purpose of this program tell the student gpa
 * The author of this program: me lol
 * The creation date: i dunno, create some hoes
 * Version of the program: 1.0
 */

import java.util.Scanner;

public class Tester {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Student's ID number:");
		String ID = input.next();
		System.out.print("\n" + "Student Name:");
		String name = input.next();
		StudentGPA student = new StudentGPA(name, ID);
		System.out.print("\n" + "\n" + "Initial GPA = " +student.getMyGPA());
		while (student.getMyNumGrades()<20){
			System.out.print("Enter A Grade:");
			int grade = input.nextInt();
			student.addGrade(grade);
			System.out.println("GPA = " +student.getMyGPA());

		}




	}
}
