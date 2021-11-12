package src;

import java.util.Scanner;
/*
Author Liam Wirth
LAB: LA 3.2 Easter
 Description: Figures out the date that easter falls on given any specified year
Purpose: to find the date that easter falls on given a specific year
Creation Date: August 28th.
 */
public class EasterFinder {
    final static String[] DAYS_OF_WEEK = {
            "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday"
    };
    // An array for the days of the week that I wrote for my
    //zellers congruence algorithm that is kind of pointless
    //considering the fact that Easter always falls on sunday.

    final static String[] MONTHS_OF_YEAR = {
            "January", "Februrary", "March", "April", "May", "June", "July", "August",
            "September", "November", "December"
    };
    // this array is the months of the year, that way I can
    // have the numerical value for the month of the year
    // be converted to the actual name of the month, just to
    // make my output prettier


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What year would you like to calculate the date of Easter for?");
        String inputYear = input.nextLine();          //accepting the user input that I was given through the terminal
        int year = Integer.parseInt(inputYear);
        eCalculator calculator = new eCalculator();
        DayOfMonth date = calculator.date(year); // this is really big for me, mostly because it took me around 2
        // hours to do successfully. Here, I am creating an instance of the DayOfMonth object, and setting that
        // instance equal to the return value of the calculator.date method (this return value being an updated
        // version of the day and month variables I set in the DayOfMonth class
        zeller zeller = new zeller();
        //wrote code for zeller's congruence to figure out the day of the week easter is on
        //stupidly forgetting that easter is always on sunday

        String monthPretty = MONTHS_OF_YEAR[(date.month - 1)];
        String grammar;
        //sorry for using switch statements mr.dunlea, they just work for what I need
        switch (date.day) {               //this switch statement changes around the grammar string depending on
            // the number we are
                                    //dealing with, just so that it can say 3rd if it's three, or 4th if it's 4 etc.
            case 1:
            case 21:
            case 31:
                grammar = "st";
                break;
            case 2:
            case 22:
                grammar = "nd";
                break;
            case 3:
            case 23:
                grammar = "rd";
                break;
            default:
                grammar = "th";

        }
        System.out.println("Easter in the year " +year +" falls on Sunday " +monthPretty + " " + date.day + grammar);
        /*
        a print statement that in a nice and pretty way tells you the date that easter falls on.
         */



    }
}
