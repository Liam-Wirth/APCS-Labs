import apcslib.DrawingTool;
import apcslib.SketchPad;

import java.awt.geom.Point2D;

public class Rectangle{
	private double myX;
	private double myY;
	private double myWidth;
	private double myHeight;
	private static DrawingTool pen = new DrawingTool(new SketchPad(400, 400));
	Rectangle(double myX, double myY, double myWidth, double myHeight) {
		this.myX      = myX;
		this.myY      = myY;
		this.myWidth  = myWidth;
		this.myHeight = myHeight;
		//ok there is the constructor stuff
	} //normal constructor
	 Rectangle(Rectangle clone){
		 this.myWidth      = clone.myWidth;
		 this.myHeight     = clone.myHeight;
		 this.myX          = clone.myX;
		 this.myY          = clone.myY;

		      	       
	 }
  //copy constructor
	Rectangle(){
		//Null constructor, sets all values to 0
	}                                                            //null constructor

	public void Draw() { //method to draw the rectangle!!!!!!
		pen.setWidth(5);
		pen.turn(90);
		pen.backward(myWidth);
		pen.turn(90);
		pen.backward(myHeight);
		pen.turn(90);
		pen.backward(myWidth);
		pen.turn(90);
		pen.backward(myHeight);
	}
	public void Draw(double locX, double locY) { //method to draw the rectangle!!!!!!
		pen.up();                                       //  //moving the pen up
		pen.move(locX-50, locY-50);                     //moving the pen over to the inputted location (initialized by my constructor)
		pen.setDirection(90);                           //changing the direction of the pen so that my rectangle is oriented in the correct direction
		pen.down();                                     //putting the pen down so that I can actually start drawing
		pen.setWidth(5);                                //setting the width of the pen cause I want
		pen.turn(90);                           //turning the pen 90 degrees again don't ask me why
		pen.backward(myWidth);                          //moving the pen in the coret direction for what would be the width of the rectangle
		pen.turn(90);                           //turning 90
		pen.backward(myHeight);                         //moving along the height of the rectangle
		pen.turn(90);                           //turning 90 again
		pen.backward(myWidth);                          //
		pen.turn(90);                           //
		pen.backward(myHeight);                         //
	}                                                   //
	public void setDirection(double direction){ //another setter method
		pen.setDirection(direction);
	} //setter
	public double getDirection(){
		return pen.getDirection();
	}//getter
	public double getX1(){
		return myX;
	}//getter
	public double getY1(){
		return myY;
	}//getter
	public double getX2(){
		return this.myX+ this.myWidth;
	}//getter
	public double getY2(){
		return this.myY+this.myHeight;
	}//getter
	public double getHeight() {
		return myHeight;
	}//getter
	public double getWidth() {
		return myWidth;
	}//getter
	public void setX(double X) {
		this.myX = X;
	}//setter
	public void setY(double Y) {
		this.myY = Y;
	}//setter
	public void setHeight(double Height) {
		this.myHeight = Height;
	}//setter
	public void setWidth(double Width) {
		this.myWidth = Width;
	}//setter
	public void drawString(String input, int X, int Y){ //drawstring method I should draw some bitches
		pen.up();
		Point2D.Double position = pen.getPosition();
		pen.move(X,Y);
		pen.down();
		pen.drawString(input);
		pen.up();
		pen.move(position.x, position.y); //returning the drawing tool to it's initial position, I think this would be best
		pen.down();
	}
	public int GetArea() {
		return (int) (myHeight * myWidth);
	} //getter
	public int GetPerimeter() {
		return (int) ((int) (myHeight * 2) + (myWidth * 2));
	} //getter
	public void setPenWidth(int width){
		pen.setWidth(width);
	}
	public void penDown(){
		pen.down();
	}
}
