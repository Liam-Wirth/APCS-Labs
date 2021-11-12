import LiamAssets.*;
import org.w3c.dom.css.Rect;

/*
this is a package I made myself (awesome) and it has a square class, I intend to use this class a bunch because
I used it for the tic tac toe game and it stores a bunch of different datatypes in reference to squares and building
them, I probably won't use this class but I thought I might as well have it ready as an example, because the class
also stores a bunch of other kind of unneccessary stuff like state and if it's marked with x or o, so I probably
shouldn't use the class now that I think of it... whatever I guess it is what it is. What I do know is that I plan
to continue to add to this package so that I can keep some methods and classes that are useful at hand
*/
public class Tester{
	public static void main(String[] args){
		Rectangle rectA = new Rectangle(0, 0, 200, 50);
		Rectangle rectB = new Rectangle(rectA);

		double widthInc = 10;
		double turnInc = 30;
		rectA.Draw();
		while(rectA.getWidth()>=100) {
			rectA.setDirection(rectA.getDirection() - turnInc);
			rectA.setWidth(rectA.getWidth() - widthInc);
			rectA.Draw();
		}
		rectB.setX(-400);
		rectB.setY(400);
		rectB.setX(-400);
		rectB.setY(-400);
		rectB.Draw(-400,400);
		rectB.drawString(String.valueOf( "Area : "+rectB.GetArea()) ,-400,375);
		rectB.drawString(String.valueOf("Perimeter:  " +rectB.GetPerimeter()),-400,360);

	}
}




