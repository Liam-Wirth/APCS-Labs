import apcslib.DrawingTool;

import java.awt.*;
import java.awt.geom.Point2D;

public class House {
    public static int i = 0;

    public static void drawSky(){
        Main.pencil.down();
        Main.pencil.setColor(Color.cyan);
        Main.pencil.fillRect(2000, 2000);
        Main.pencil.home();
        Main.pencil.up();
    }

    public static void drawGround(){
        Main.pencil.move(0, -400);
        Main.pencil.down();
        Main.pencil.setColor(DARK_GREEN);
        Main.pencil.fillRect(2000,800);
        Main.pencil.home();
    }

    public static void drawSquare(int scale) {//draws the square/the body of the house
        Main.pencil.move(-125, 125);
        Main.pencil.setColor(Tan);
        Main.pencil.fillRect(250,250);
        Main.pencil.up();
        Main.pencil.home();
        Main.pencil.setColor(Color.black);
        Main.pencil.down();

        for (int loop = 0; loop <= 4; loop++) {
            Main.pencil.forward(scale);
            System.out.println(Main.pencil.getPosition());
            Main.pencil.turnLeft(90);

        }
    }

    public static void drawRoof(int scale) { //function to make a roof
        for (int loop = 0; loop < 4; loop++) { //simple for loop to make my code a little more optimized
            Main.pencil.setColor(Color.black);
            Main.pencil.turnLeft(120);
            Main.pencil.backward(scale);

        }
    }

    public static void drawDoor() {
        /* this function should be relatively self explanitory, it basically just draws the door, the only interesting things
         * about it (in my opinion) is that I figured out how to pick up and put down the pencil after researching and finding
         * some documentation on the apcslib. using that documentation I was able to use functions like pencil.move, and pencil.up/pencil.down
         * yt*/
        Main.pencil.setColor(BROWN);
        Main.pencil.up(); //picks up the pencil
        Main.pencil.move(-125, 50); //relocates the pencil to center the door on the house
        Main.pencil.down(); //puts the pencil back down
        Main.pencil.fillRect(50, 100); //neat little function I found that will automatically draw a rectangle for me
        Main.pencil.setColor(Color.black);
        Main.pencil.drawRect(50,100);
    }

    //ok here is where I'm gonna try and do some of the extra stuff that you wanted from me
    public static void drawSun() {
        Main.pencil.setColor(Color.yellow); //changes the color of the pencil to yellow
        Main.pencil.up(); //picks the pencil up
        Main.pencil.move(900, 450);//400,250
        Main.pencil.down();
        Main.pencil.fillOval(300, 300);
        Main.pencil.up(); //here I decided to start picking the pencil up at the end of every function,
        //making it easier to relocate the drawing tool before I draw my next thing.
    }

    public static final Color Tan = new Color(208, 108, 79);
    public static final Color BROWN = new Color(104, 69, 55);// had to teach myself how to make colors
    public static final Color DARK_GREEN = new Color(5, 100, 30);// had to teach myself how to make colors
    private static int getRandomNumberInRange(int min, int max) {//random number function (totally not ripped from stackoverflow)

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
//in retrospect maybe I should have put this in it's own class
    // ok this one is gonna be the only extra thing I do, because it's gonna be a real big boy function that should hopefully do a lot of stuff, I don't know how long this will take.
    private static void buildTrees(int depth, int branches) {
        //for some of this, I'm copying some of the way they made the trees for that accelerated intro to cs course on code.org
        if (depth >= 0) {

            Main.pencil.down();
            Main.pencil.setWidth(8);
            Main.pencil.forward(7 * depth);
            Main.pencil.setWidth(5);
            Main.pencil.turnLeft(130);
            Main.pencil.setColor(Color.GREEN);

            for (int i = 0; i < branches; i++) {
                //I hate this loop with a passion, the amount of time i spent shaking my fist in frustration trying to figure out what was wrong is almost saddening.
                int randB= getRandomNumberInRange(0, 50);//this is a random number generator for the blue variable of rgb
                int randR= getRandomNumberInRange(0, 50); //this is a random number generator for the red variable of RGB
                int randG= getRandomNumberInRange(100, 255); //this is a random number generator for the green variable of RHB
                final Color random_green = new Color(randR,randG,randB); //using the random numbers I can make the tree leaves have varying colors
                Main.pencil.setColor(random_green); //setting the color of the pencil to that randm color I just made
                Main.pencil.turnRight(180 / branches); //now it is going to start doing the branches I hate this code so much it took me so long
                buildTrees(depth - 2, branches); //this was the problem child I couldn't get this to stop, the problem was cause my i loop variable

            }
            Main.pencil.turnLeft(50); //resetting the pencil for the next tree
            Main.pencil.up(); //picking up the pencil
            Main.pencil.backward(7 * depth); //further resetting
        }

    }

    public static void placeTrees( int quantity, int depth, int branches){ /* I can't neccessarily remember the reason why I chose to
     use two separate methdos for the trees, as this was like 3 am code, but my best guess is it had something to do with
     the fact that they are randomly scattered about*/

        for (int j = 0; j < quantity; j++) {
            int xPositive = getRandomNumberInRange(300, 800); // I had to create two x ranges because I didn't want the trees to cover up the house
            int xNegative = getRandomNumberInRange(-800,-300);
            int yRand = getRandomNumberInRange(-400, 0);// this is for the y range
            int xRand;
            if (Math.random() > 0.5){ //this basically is a coin flip that chooses whether or not to place a tree to the left, or to the right of the house.
                xRand = xPositive;
            }
            else{
                xRand = xNegative;
            }

            Main.pencil.move(xRand, yRand); //relocates the pencil
            Main.pencil.setColor(BROWN);
            Main.pencil.setDirection(90);
            Main.pencil.down();
            buildTrees(depth, branches);

        }
        int i = 0;
        buildTrees(depth, branches);
    }
}



