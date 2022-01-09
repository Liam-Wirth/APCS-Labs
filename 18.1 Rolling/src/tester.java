import java.util.Random;

public class tester{
    public static void main(String[] args){
        Random roll = new Random();//This is to give my dice a "roll" function

            int d1;
            int d2;
            int d3;
            int count = 0;
            do {
                 d1 = roll.nextInt(6);
                 System.out.print(d1+" ");
                 d2 = roll.nextInt(6);
                System.out.print(d2+" ");
                 d3 = roll.nextInt(6);
                System.out.print(d3+" ");
                System.out.println();
                count++;
            }while(!(d1!=d2&&d2!=d3));
            System.out.println("Count: "+count);


    }
}
