public class CollegeStudent extends Student{
    protected int grade;
    protected String major;
    public CollegeStudent(String name, int age, String gender, String idNum, double gpa, int grade, String major) {
        super(name, age, gender, idNum, gpa);
        this.grade = grade;
        this.major = major;
    }
    public String toString(){
        return super.toString()+ ", Grade: " +grade + ", Major: " +major;
    }
}