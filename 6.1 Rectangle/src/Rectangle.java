import apcslib.DrawingTool;
import apcslib.SketchPad;

public class Rectangle {
	private double myX;
	private double myY;
	private double myWidth;
	private double myHeight;
	private static DrawingTool pen = new DrawingTool(new SketchPad(400, 400));

	Rectangle(double X, double Y, double width, double height) {
		myX = X;
		myY = Y;
		myWidth = width;
		myHeight = height;
		//ok there is the constructor stuff


	}

	public void Draw() {
		pen.up();
		pen.move(myX, myY);
		pen.down();
		pen.move(myX, myY);
		pen.move(myX + myWidth, myY);
		pen.move(myX + myWidth, myY - myHeight);
		pen.move(myX, myY - myHeight);
		pen.move(myX, myY);
	}

	public int GetArea() {
		int area = (int) (myHeight * myWidth);
		return area;
	}

	public int GetPerimeter() {
		int perimeter = (int) ((int) (myHeight * 2) + (myWidth * 2));
		return perimeter;
	}
}

