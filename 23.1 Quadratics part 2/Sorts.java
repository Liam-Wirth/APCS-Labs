import java.util.*;


/**
 *  Description of the Class
 *
 * @author     Your Name Here
 * @created    Month Day, Year
 */
public class Sorts
{
  private long steps;

  /**
   *  Description of Constructor
   *
   * param list  Description of Parameter
   **/
  Sorts()
  {
    steps = 0;
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void bubbleSort (int[] list) {
      steps++;     // initialization of outer
      for (int outer = 0; outer < list.length - 1; outer++)
      {
          steps += 3;
          //  1 - boundary check of outer loop;
          //  2 - increment, outer++
          //  3 - initialization of inner loop
          for (int inner = 0; inner < list.length - outer - 1; inner++)
          {
              steps += 3;
              //  1 - boundary check of inner loop
              //  2 - increment, inner++
              //  3 - if comparison
              if (list[inner] > list[inner+1])
              {
                  int temp = list[inner];
                  list[inner] = list[inner + 1  ];
                  list[inner + 1] = temp;
                  steps += 3;    // swap of list[inner] & list[inner + 1]
              }
          }
      }
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void selectionSort(int[] list) {
      steps++; //following the example set by the bubble sort with step counter, and initializing the outer here.
      for (int outer = 1; outer < list.length; outer++) {
          steps+=3;
          //init outer
          //then boundary check
          //incrementation of outer
          int position = outer;
          int key = list[position];
          steps+=2;
          // Shift larger values to the right
          steps++;
          //inner loop
          while (position > 0 && list[position - 1] > key) {
              steps++;
              //screw you it's one step
              list[position] = list[position - 1];
              position--;
              steps+=2;
              //adding two steps.
          }
          list[position] = key;
          steps++;
      }
  }


  /**
   *  Description of the Method
   * balls gay balls and cum 😈
   * @param  list  reference to an array of integers to be sorted
   */
  public void insertionSort(int[] list) {
      steps++; //Initialization of the steps counter (I think)
      for (int outer = 1; outer < list.length; outer++) {
          int position = outer;
          int key = list[position];
          // Shift larger values to the right
          steps += 4;
          //the first step is the initialization of the loop, which i did outside of the loop.
          //the second step is for the boundary check of our outer loop;
          //the third step is the incrementation of outer
          //the fourth step is with the position of the integer and checking it as an outer
          //the fifth step is checking key;
          steps++;
          while (position > 0 && list[position - 1] > key) {
              steps+= 3;
              //I consider this one step cause both things have to be true for the editor to actually continue
              list[position] = list[position - 1];
              position--;
              steps+=2;
              //checking the list for step 1
              //intervalling position is step 2
          }
          //
          list[position] = key;
          steps++;
          //one more step for checking the position
      }
  }

 /**
   *  Takes in entire vector, but will merge the following sections
   *  together:  Left sublist from a[first]..a[mid], right sublist from
   *  a[mid+1]..a[last].  Precondition:  each sublist is already in
   *  ascending order
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  mid    midpoint index of range of values to be sorted
   * @param  last   last index of range of values to be sorted
   */
 void merge(int a[], int first, int mid, int last)
 {
     System.out.println("First: " + first + " Mid " + mid + " Last " +last);
     boolean cheatyWay = true;
     int index1, index2, numsAdded;
     int n1 = mid - first + 1;
     int n2 = last - mid;
     steps+=6;
     steps+=2;
     int[] LeftArray = new int[n1];
     int[] RightArray = new int[n2];
     steps+=6;
     for (index1 = 0; index1 < n1; index1++) {
         LeftArray[index1] = a[first + index1];
         steps++;
     }
     for (index2 = 0; index2 < n2; index2++) {
         RightArray[index2] = a[mid + 1 + index2];
         steps++;
     }

     index1 = 0; /* initial index of first sub-array */
     index2 = 0; /* initial index of second sub-array */
     numsAdded = first;  /* initial index of merged sub-array */
     steps+=3;
     steps+=4;

     while (index1 < n1 && index2 < n2)
     {
         steps++;
         if(LeftArray[index1] <= RightArray[index2])
         {
             steps+=2;
             a[numsAdded] = LeftArray[index1];
             index1++;
         }
         else
         {   steps+=2;
             a[numsAdded] = RightArray[index2];
             index2++;
         }
         numsAdded++;
         steps++;
     }
     if(cheatyWay) {
         while (index1 < n1) {
             a[numsAdded] = LeftArray[index1];
             index1++;
             numsAdded++;
         }

         while (index2 < n2) {
             a[numsAdded] = RightArray[index2];
             index2++;
             numsAdded++;
         }
     }else{

     }
 }

    /**
   *  Recursive mergesort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void mergeSort(int[] a, int first, int last)
  {
      viSort(a);
      if (first < last) {
          int m = (first+last)/2;
          mergeSort(a, first, m);
          mergeSort(a , m+1, last);
          merge(a, first, m, last);
      }
  }

public int pivot(int[] a, int first, int last){
    int fulcrum = a[last];
    int i = first -1;
    for (int j = first; j <=last-1 ; j++) {
        if (a[j]<fulcrum){
            i++;
            int t = a[i];
            a[i]=a[j];
            a[j]=t;
        }
    }
    int t  = a[i+1];
    a[i+1] = a[last];
    a[last]= t;
    viSort(a);
    return(i+1);
}
  /**
   *  Recursive quicksort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void quickSort(int[] a, int first, int last) {
      if (first <last){
          int p = pivot(a,first, last);
          quickSort(a,first,p-1);
          quickSort(a,p+1,last);
      }

  }
  public void bogoSort(int [] list, int first, int last) throws InterruptedException {
      Random arrayShuffle = new Random();
      int out[] = new int[list.length];
      while (!isSorted(list)) {
          //below loop will randomize the array and then see if it's sorted
          for (int i = 0; i < list.length; i++) {
              steps += 3;
              //no
              int newLoc = arrayShuffle.nextInt(list.length - 1);
              int currentNum = list[i];
              steps += 2;
              list[i] = list[newLoc];
              list[newLoc] = currentNum;
              steps += 2;
              //funny loop to print out put of the sort to the console
              for (int j = 0; j < list.length - 1; j++) {
                  for (int k = 0; k < list[j]; k++) {
                      System.out.print("▇");
                  }
                  System.out.print("\r\n");
              }
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }

              for (int l = 0; l < 999; l++) {
                  System.out.println();
              }
              System.out.println();

          }


      }
      steps++;
  }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



    private boolean isSorted(int[] list)
    {
        for (int i = 1; i < list.length; i++)
            if (list[i] < list[i - 1])
                return false;
        return true;
    }
  /**
   *  Accessor method to return the current value of steps
   *
   */
  public long getStepCount()
  {
    return steps;
  }

  /**
   *  Modifier method to set or reset the step count. Usually called
   *  prior to invocation of a sort method.
   *
   * @param  stepCount   value assigned to steps
   */
  public void setStepCount(int stepCount)
  {
    steps = stepCount;
  }
  public static void viSort(int[] list){
    //funny loop to print out put of the sort to the console
    for (int j = 0; j < list.length-1; j++) {
        for (int k = 0; k < list[j]; k++) {
            System.out.print("▇");
        }
        System.out.print("\r\n");
    }
    System.out.println("____________________________________");
    try {
        Thread.sleep(200);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    //for (int l = 0; l < 500; l++) {
    //    System.out.println();
    //}
    System.out.println();
    System.out.flush();

}
//public static void viSortHarder(int[] list){
//    int i = 1;
//    boolean everyOther;
//    while(i<list.length) {
//       if(list[i]>10 && list[i]<=20){
//          for(i=1; i<list.length; i++){
//              i /= 2;
//             if(everyOther){
//
//             }
//          }
//           i = 1;
//           break;
//        }else if(i>20){
//           throw new ArithmeticException("bruh deez numbas be too big fo dis visualization i'm out");
//       }else{
//           i=1;
//           for ( i = 1; i < ; i++) {
//
//           }
//       }
//
//    }
//    i++;
//}


}
/* TODO: Just typing this tokeep track of what I have done alreadu:
*  */
//TODO make a visual sort method that is part of this class and is publicly accessible, and then implement
// it for all of the sorting algorithms, I'm pretty sure I'd have to implement it here in this class because
// it updates with the algorithm at runtime
//TODO learn either javax.swing (JFrames) or figure out Ncurses on linux install to be able to make sense of Jcurses
//TODO Implement vSort as a TUI type application? (using JCurses or smthn)
//TODO Merge method + Merge Sort
//TODO smartBogo sort




