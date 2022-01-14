import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tester {
    public static int mystery (int n, int a, int d) {
        {
            if (n ==1)
                return a;
            else
                return d + mystery(n-1, a, d);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        File numbers = new File("numbers.txt");
        statCalc calculator = new statCalc(numbers);
        System.out.println("The average of the given dataset is                   " + calculator.average());
        System.out.println("Sum of the Squares of the Difference from the Average " + calculator.sumOfSquareOfDifference());
        System.out.println("The Square root of all that silly business            " + calculator.sqrtSquareAverage());
        System.out.println("The Mode of the given dataset is                      " + calculator.mode());
    }

}
