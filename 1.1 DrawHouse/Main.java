import apcslib.*;
import java.awt.Color;
/*
AP Compsci Lab 1.1 drawHouse, code by Liam Wirth version 1.0, created Aug.25 2021
*/


public class Main {
    public static SketchPad paper = new SketchPad(400, 400); //heheheh I am ahead of the curve oh yeah
    public static DrawingTool pencil = new DrawingTool(paper); //hohohohoh I wrote my code like a smarty pants oh yeah
    public static void main(String[] args) {
        pencil.setWidth(4);
           House.drawSky();
           House.drawGround();
           House.drawSquare(250);
           House.drawRoof(250);
           House.drawDoor();
           House.drawSun();
           House.placeTrees(14,9, 3);
           pencil.drawString("What's bofa?");
    }
}