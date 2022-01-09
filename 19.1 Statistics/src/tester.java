import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tester {

    public static void main(String[] args) throws FileNotFoundException {
        File numbers = new File("numbers.txt");
        statCalc calculator = new statCalc(numbers);
        System.out.println(calculator.average());
        System.out.println(calculator.sumOfSquareOfDifference());
        System.out.println(calculator.sqrtSquareAverage());
    }

}
