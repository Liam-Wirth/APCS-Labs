import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class statCalc {
    private final long length;
ArrayList<Short> nums = new ArrayList<Short>();
private long sum;
private byte average; //trying to start a habit of using different integer datatypes to optimize my code
private long sumOfSquareOfDifference;

    public statCalc(File numbers) throws FileNotFoundException {
        this.length = numbers.length(); //I'm pretty sure this will be useful later for the average
        Scanner reader = new Scanner(numbers);
        int ween = (int) (length-1);
        int i=0;
        while(reader.hasNextShort()){
            i++;
            short temp = reader.nextShort();
            nums.add(temp);

        }
        }
    public byte average() throws FileNotFoundException {
        for (int i = 0; i < nums.size(); i++) { //this will run until the scanner hits the EOF marker :)
           this.sum+=nums.get(i);
           //System.out.println("Reading number: "+temp); code I wrote to make sure the stuff worked
        }
        average = (byte) (sum/nums.size());
        return average;

    }
    public long sumOfSquareOfDifference() throws FileNotFoundException {
        for (int i = 0; i < nums.size(); i++) {
            short temp = nums.get(i);
            short tempDiff = (short) Math.pow((temp-average),2);
            sumOfSquareOfDifference += tempDiff;
        }
        return sumOfSquareOfDifference;
    }
    public double squareAverage() {
        return (double)(sumOfSquareOfDifference/(nums.size()));
        }
    public short mode(){

        short frequency = 0;
        short mode = 0;
        byte currentNum = 0; //this is the current number that I am counting for
       while(currentNum<100){
            byte count = 0; //this counter is to count the frequency of any number in the list
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(j) == nums.get(currentNum)){
                    count++;
                }
                if (count>frequency){
                    frequency = count;
                    mode = nums.get(j);

                }

            }
            currentNum++;
        }
        return mode;
    }

    public double sqrtSquareAverage(){
        return Math.sqrt(squareAverage());
    }
}
