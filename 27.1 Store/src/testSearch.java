import chn.util.ConsoleIO;

public class testSearch {
    public void testSearch() {
        int idToFind;
        int invReturn;
        int index;
        ConsoleIO console = new ConsoleIO();

        System.out.println();
        System.out.print("Enter Id value to search for (-1 to quit) ---> ");
        idToFind = console.readInt();
        while (idToFind >= 0) {
            // calling iterative version of binary search
            index = bsearch(new Item(idToFind, 0));
            System.out.print("Iterative binary search: Id # " + idToFind);
            Item[] Store = new Item[0];
            if (index == -1)
                System.out.println("     No such part in stock");
            else
                System.out.println("     Inventory = " + Store[index].getInv());

            // calling recursive version of binary search
            index = bsearch(new Item(idToFind, 0), 0, Store.length - 1);
            System.out.print("Recursive binary search: Id # " + idToFind);
            if (index == -1)
                System.out.println("     No such part in stock");
            else
                System.out.println("     Inventory = " + Store[index].getInv());

            System.out.print("\nEnter Id value to search for (-1 to quit) ---> ");
            idToFind = console.readInt();
        }
    }

    /**
     * Searches the myStore array of Item Objects for the specified
     * item object using a iterative binary search algorithm
     *
     * @param idToSearch Item object containing Id value being search for
     * @return index of Item if found, -1 if not found
     */
    int bsearch(Item idToSearch) {
        return -1;
    }

    /**
     * Searches the specified array of Item Objects for the specified
     * item object using a recursive binary search algorithm
     *
     * @param idToSearch Item object containing Id value being search for
     * @param first      Starting index of search range
     * @param last       Ending index of search range
     * @return index of Item if found, -1 if not found
     */
    int bsearch(Item idToSearch, int first, int last) {
        return -1;
    }
}