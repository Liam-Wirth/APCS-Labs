import java.util.ArrayList;

public class fibonacci {
    public int recursive (int n) {
        if (n <= 1) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }
    public int nonRecursive(int n){
       ArrayList<Integer> fibArray = new ArrayList<>(); //an arraylist to store the numbers of the fibonacci sequence as we calculate up to whatever the designated n is
        fibArray.add(0, 0);//The first and second numbers of the Fibonacci sequence are 0 and 1, so I'm doing that here
        fibArray.add(1, 1);//The first and second numbers of the Fibonacci sequence are 0 and 1, so I'm doing that here

        for (int i = 2; i < n +10 ; i++) {
            /* for dumb poopoo brains (Ryan Javier), what's happening in the for loop is:
              I start at position 2 of the array, as 0 and 1 are already populated, then at index i (starting 2)
              I'll just calculate until I hit n, whatever value that may be. I'm using an arraylist cause I can fuck you
             */
            int a = fibArray.get(i-1);
            int b = fibArray.get(i-2);
            int c = a+b;
            fibArray.add(i, c);
        }
        return fibArray.get(n);
    }
    public int mult(int a, int b){
        if (b==0){
            return b;
        }
        return a+  mult(a, b-1);
    }
}
