import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store miniMart = new Store("File50.txt");//imports file50
        System.out.println("Database before sorted: ");//print
        System.out.println();
        miniMart.displayStore();//displays the unsorted list
        miniMart.doSort();
        System.out.println();
        System.out.println("Database after sorted by id: ");//print
        System.out.println();
        miniMart.displayStore();//displays the sorted list
        // test of methods from LA28.1 - searching the database
    }

}
