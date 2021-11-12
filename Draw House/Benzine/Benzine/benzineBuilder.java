public class benzineBuilder {
    // I don't really know why but I like to make multiclass programs, even for easy stuff.
    public static void buildcircle(int scale){

       Benzine.pen.drawCircle(scale);
    }
    public static void buildHex(int scale){
        //moving the pen to where it needs to be so that it will put the hexagon in the right place
        Benzine.pen.up();
        Benzine.pen.home();
        Benzine.pen.backward(160);
        Benzine.pen.turnLeft(90);
        Benzine.pen.forward(90);
        Benzine.pen.down();
        //actually drawing the hexagon
        for (int count = 0; count < 7; count++) {
            Benzine.pen.down();
            Benzine.pen.turnRight(60);
            Benzine.pen.forward(scale);



        }
    }
}
