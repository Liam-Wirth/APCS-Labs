
/**
 * Description- Sorts many items of a store's inventory by item Id.
 * Purpose-To learn the application of quicksort
 *
 * @author Dhruv T
 * @version L.A.27.1 - Store
 */
import chn.util.*;
import java.lang.*;
public class Item implements Comparable<Item>
{
    //class attributes
    private int myId;
    private int myInv;

    public Item(int id, int inv)
    {

        myId = id;
        myInv = inv;
    }
    // get method for Id
    public int getId(){
        return myId;
    }
    //Get method for Inv
    public int getInv(){
        return myInv;
    }
    //custom compareTo method
    public int compareTo(Item otherObject){
        return myId - otherObject.myId;
    }
    //custom equals method which utilizes the compareTo method
    public boolean equals(Object otherObject){
        return compareTo((Item) otherObject)==0;
    }
    //returns the class variables
    public String toString(){
        return myId+"    "+myInv;
    }

}

