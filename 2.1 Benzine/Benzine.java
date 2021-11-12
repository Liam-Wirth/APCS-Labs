import apcslib.*;
/*
Author Liam WIrth
LAB: LA 2.1 Benzine
 Description: Creates a piece of paper and a pencil, and draws a benzene symbol
 */
public class Benzine{
    public static SketchPad paper = new SketchPad(300,300);
    public static DrawingTool pen = new DrawingTool(paper);

    public static void main(String[] args){

            benzineBuilder.buildcircle(150);
            benzineBuilder.buildHex(180);
            

        }
    }

