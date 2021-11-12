package src;

public class eCalculator   {
    public DayOfMonth date(int year){

        int aQuotient = (year/19);                 //getting the quotient, so I can find the remainder that is a

        int a = (year-(19* aQuotient));            /* Although I did just figure out a more efficient method to do this
                                                      Apparently I can just replace that / for dividing with a % symbol
                                                      and java will give me the remainder, so this is the last time you'll
                                                      see me calculating for the remainder like this again.
                                                   */
        System.out.println("    a = " + a);            // I was instructed to print the value of each variable, so I'm saying it's name then showing it's value.
        int b = (year/100);                              //b is equal to the year divided by 100
        System.out.println("    b= "+b);               //printing value of f
        int c = (year -(100*b));                        //the argument here is that the integer c is equivalent to the value
                                                        // of the year that I inputted into the method, and then it is subtracted by
                                                         // the value of 100*b
        System.out.println("    c= "+ c);              //printing the value of  c
        int d = (b/4);                                  // to find the value of d, I divide the value of the integer b by 4
        System.out.println("    d= "+ d);              //printing the value of d
        int e = (b%4);                                  //using that fancy math function I found to get the remainder (modulo)
        System.out.println("    e= "+ e);              // printing the value of e
        int f = ((b+8)/24);                              // the main arguments being used are the addition argument, adding 8 to b, and then
                                                         //and then it is being divided into 24
        System.out.println("    f= "+ f);              //printing value of f
        int g = ((b-f+1)/3);                             /* to get the integer g, I subtract b from f, and then add 1 to
                                                         that value, next I take the total value from that operation and
                                                        then divide it all by 3 using the / argument*/
        System.out.println("    g= "+ g);              //printing the value of g
        int h = ((19 *a+b-d-g+15)%30);                   /* this one is alot, in the first group of parenthesis, I take 19,
                                                          multiply it by a+b-d-g and then add 15 from there, I take the
                                                          full value of that operation, and use the modulo operator (%)
                                                          to get the value of whatever the parenthesis is mod 30*/
        System.out.println("    h= "+ h);              //printing out the value of h
        int i = (c/4);                                  // the integer i is equal to c divided by 4
        System.out.println("    i= "+ i);              //printing out the value of i
        int k = (c%4);                                  //k is equal to c mod 4
        System.out.println("    k= "+ k);              //printing out value of k to console
        int r = ((32+2*e+2*i-h-k)%7);                   // r is the value of 32_2*e+2*i-h-k to the mod of 7
        System.out.println("    r= "+r);               //printing out the value of r
        int m = ((a+11*h+22*r)/451);                    // m is equal to a +11*h+22*r divided by 451
        System.out.println("    m= "+m);               //printing the value of m
        int n = ((h+r-7*m+114)/31);                     // n is equal to h+r -t*m +114 divided by 31
        System.out.println("    n= "+n);               //printing the value of n
        int p =((h+r-7*m+114)%31);                      //h+r-7*m+114 to the mod of 31
        System.out.println("    p= "+p);                //now that I am finally done with all of this silly little math, I'm
                                                        //gonna push the two numbers that I need to an array so that this
                                                        //can return the function that I want it too.
                                                         // ok I am not gonna do this because it is bad coding practice
        System.out.println(" ");
        int day = p + 1;


        return new DayOfMonth(day, n);


    }

}
