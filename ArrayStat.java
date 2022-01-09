
/**
 * Write a description of class ArrayStat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import chn.util.*;
import apcslib.*;
import java.util.Arrays;
public class ArrayStat
{
    int[] A = new int[1000];
    int [] mode= new int[101];
    int cell = 1;
    int totalSum = 0;
    double temp;
    double stD;
    double avg;
    int length = A.length - 1;
    /**
     * Constructor for objects of class ArrayStat
     */
    public ArrayStat()
    {
        temp = 0;
        stD = 0;
    }

    public void toArray()
    {
        FileInput inFile = new FileInput("numbers.txt");
        while (inFile.hasMoreLines())
        {
            A[cell] = inFile.readInt();
            cell ++;
        }
        System.out.println(Arrays.toString(A));
    }

    public void arrayAvg()
    {
        for (int i = 1; i < A.length; i ++)
        {
            totalSum = totalSum + A[i];
        }
        avg = (totalSum/A.length);
        System.out.println(avg);
    }

    public void arraySD()
    {
        for (int j = 0; j <A.length; j ++)
        {
            temp = temp + Math.pow((avg - A[j]), 2);
        }
        stD = Math.sqrt(temp/(A.length - 1));
        System.out.println(stD);
    }

    public void arrayMode()
    {
        for(int m = 1; m < A.length; m++)
        {
            mode[A[m]]++;
        }
        
    }
}