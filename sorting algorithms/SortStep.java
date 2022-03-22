import chn.util.*;
import apcslib.Format;
import static java.lang.System.out;
import java.util.*;


/**
 *  Driver program for the Sorts class.
 *
 * @author     G. Peck
 * @created    July 18, 2002
 */
public class SortStep
{
    private ConsoleIO console;
    private int[] myArray;
    private Sorts mySorts;

    /**
     *  Constructor for the SortStep object
     */
    public SortStep()
    {
        console = new ConsoleIO();
        mySorts = new Sorts();
    }

    /**
     *  Asks the user to select a sorting algorithm, fills the array
     *  with an amount of random integer data chosen by the user, calls
     *  the sorting algorithm, and gives an option of printing out the
     *  data after it has been sorted.
     */
    public void sortMenu() throws InterruptedException {
        String choice;
        String print;

        do
        {
            out.println();
            out.println("Sorting algorithm menu");
            out.println();
            out.println("(1) Bubble sort");
            out.println("(2) Selection sort");
            out.println("(3) Insertion sort");
            out.println("(4) Recursive mergesort");
            out.println("(5) Quicksort");
            out.println("(6) BogoSort");
            out.println("(Q) Quit");
            out.println();
            out.print("Choice ---> ");
            choice = console.readLine() + " ";
            if ('1' <= choice.charAt(0) && choice.charAt(0) <= '6')
            {
                out.println();
                out.print("How many numbers do you wish to generate? ");
                int numInts = console.readInt();
                out.print("Largest integer to generate? ");
                int largestInt = console.readInt();
                fillArray(numInts, largestInt);

                mySorts.setStepCount(0);

                switch (choice.charAt(0))
                {
                    case '1':
                        mySorts.bubbleSort(myArray);
                        break;
                    case '2':
                        mySorts.selectionSort(myArray);
                        break;
                    case '3':
                        mySorts.insertionSort(myArray);
                        break;
                    case '4':
                        mySorts.mergeSort(myArray, 0, myArray.length - 1);
                        break;
                    case '5':
                        mySorts.quickSort(myArray, 0, myArray.length - 1);
                        break;
                    case '6':
                        mySorts.bogoSort(myArray,0, myArray.length-1);
                }
                out.println();
                out.print("Print list to screen (y/n)? ");
                print = console.readLine();
                if (print.charAt(0) == 'y' || print.charAt(0) == 'Y')
                {
                    screenOutput();
                }
                out.println();
                out.println("# steps = " + mySorts.getStepCount());
                out.println();
                out.print("Hit return to continue");
                console.readLine();
            }
        } while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
    }

    /**
     *  Initializes myArray with random integers in the range
     *  1..largestInt
     *
     * @param  numInts     number of integers to generate (size of
     *      myArray)
     * @param  largestInt  largest possible random integer to create
     */
    private void fillArray(int numInts, int largestInt)
    {
        myArray = new int[numInts];
        Random randGen = new Random();

        for (int loop = 0; loop < myArray.length; loop++)
        {
            myArray[loop] = randGen.nextInt(largestInt) + 1;
        }
    }

    /**
     *  prints out the contents of the array in tabular form, 12 columns
     */
    private void screenOutput()
    {
        for (int loop = 0; loop < myArray.length; loop++)
        {
            if (loop % 12 == 0)
            {
                out.println();
            }
            out.print(Format.right(myArray[loop], 6));
        }
        out.println();
    }

    /**
     *  Provides a main method for access to the sorting menu
     *
     * @param  args  The command line arguments (not used)
     */
    public static void main(String[] args) throws InterruptedException {
        SortStep doSorts = new SortStep();
        doSorts.sortMenu();
    }
}
//TODO it'd be fun to make a variant of my visual sorting animatiion that would sort indeffinitely and just generat
// a new list when it finishes
//TODO figure out how to make java play sounds, and then assign different noises (funny meme sounds?) to each variable


