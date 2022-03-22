
/**
 */
import chn.util.*;//Imports FileInput,FileOutput
import apcslib.*;
public class Store
{
    private Item[] myStore;//list with all values from file

    public Store(String fName)
    {
        loadFile(fName);
    }
    // loads the data file into 'myStore'
    public void loadFile(String fileName) {
        //A FileInput object, inFile
        FileInput inFile=new FileInput("src/File50.txt");
        int numItems = inFile.readInt();
        System.out.println("num of items" + numItems);//print
        myStore = new Item[numItems];
        String tempItem; int Id; int Inv;int itemRec=0;
        while(inFile.hasMoreLines()){//repeats while there are more lines in the file
            Id = inFile.readInt();//reads the id number
            Inv = inFile.readInt();//reads the inventory number
            myStore[itemRec] = new Item(Id,Inv);
            itemRec++;//increments itemRec
        }
    }
    public void displayStore() // displays the data
    {
        for (int index = 0; index < myStore.length; index++)
        {
            String wholeStore = myStore[index].getId() + ", " +myStore[index].getInv();
            System.out.println(Format.right(index + 1, 3)+  "  " +Format.left(wholeStore, 15));
        }
        System.out.println();
    }
    // public method that calls 'quickSort' of 'myStore'

    public void doSort()                    {//calls the sort
        quickSort(myStore, 0, myStore.length - 1);    // code as shown
    }
    private void quickSort(Item[] list, int first, int last){
        // private method - use the method compareTo() of the Item class to properly sort the elements.
        int g = first;
        int h = last;
        int midIndex;
        Item midValue;

        midIndex = (first + last) / 2;//mid index
        midValue = list[midIndex];//mid value
        do
        {
            while (list[g].compareTo(midValue) < 0)//loops while the value at position g is lesser than midvalue
            {
                g++;//increment
            }
            while (list[h].compareTo(midValue) > 0)//loops while the value at position h is greater than midvalue
            {
                h--;//decrement
            }
            if (g <= h)
            {
                // swap g and h
                Item temp = list[g];
                list[g] = list[h];
                list[h] = temp;
                g++;
                h--;
            }
        } while (g < h);//reapeats while g is greater than h
        if (h > first)
        {
            quickSort(list, first, h);//recursion if h > first
        }
        if (g < last)
        {
            quickSort(list, g, last);//recursion if g < last
        }
    }
    public void testSearch()
    {
        //method vars
        int idToFind;
        int invReturn;
        int index;
        ConsoleIO console = new ConsoleIO();//console for getting an input from user

        System.out.println("Testing search algorithm\n");
        System.out.print("Enter Id value to search for (-1 to quit) ---> ");
        idToFind = console.readInt();//reads input
        while (idToFind >= 0)//repeats while id to find is above 0
        {
            // calling iterative version of binary search
            index = bsearch(new Item(idToFind, 0));//calls bsearch[Iterative]
            System.out.print("Iterative binary search: Id # " + idToFind);
            if (index == -1)
                System.out.println("     No such part in stock");//item not found
            else
                System.out.println("     Inventory = " + myStore[index].getInv());//searched item found and displays inventory

            // calling recursive version of binary search
            index = bsearch (new Item(idToFind, 0), 0, myStore.length-1);//calls bsearch[Recursive]
            System.out.print("Recursive binary search: Id # " + idToFind);
            if (index == -1)
                System.out.println("     No such part in stock");//item not found
            else
                System.out.println("     Inventory = " + myStore[index].getInv());	//searched item found and displays inventory

            System.out.print("\nEnter Id value to search for (-1 to quit) ---> ");
            idToFind = console.readInt();//reads input
        }
    }

    /**
     *  Searches the myStore array of Item Objects for the specified
     *  item object using a iterative binary search algorithm
     *
     * @param  idToSearch  Item object containing Id value being search for
     * @return             index of Item if found, -1 if not found
     */
    public int bsearch(Item idToSearch)
    {
        int first = 0;
        int last = myStore.length-1;
        int mid=0;
        while (first <= last)    // pointers 'first' and 'last' are still in valid state
        {
            mid = (first + last)/2;     // calculates middle of current sublist;
            // truncates to an integer value
            if (myStore[mid].getId()==idToSearch.getId())
                return mid;
            else if (myStore[mid].getId()>idToSearch.getId())
                last = mid - 1;		// get ready to look in lower sublist
            else			// value is less than the one being searched for
                first = mid + 1;	// get ready to look in upper sublist
        }
        // if code gets down here, the value was not found
        return -1;	// return an invalid index which represents 'not found'
    }

    /**
     *  Searches the specified array of Item Objects for the specified
     *  item object using a recursive binary search algorithm
     *
     * @param  idToSearch  Item object containing Id value being search for
     * @param  first       Starting index of search range
     * @param  last        Ending index of search range
     * @return             index of Item if found, -1 if not found
     */
    public int bsearch (Item idToSearch, int first, int last)
    {
        if (last >= first) {
            int mid = first + (last - first) / 2;//mid value for binary search
            if (myStore[mid].getId() == idToSearch.getId())return mid;//if item id searched matches the mid
            if (myStore[mid].getId() > idToSearch.getId())return bsearch(idToSearch,first, mid - 1);//if item id searched is greater than the mid
            return bsearch(idToSearch,mid + 1,last);//if item id searched is smaller than the mid
        }
        return -1;//quits
    }
}