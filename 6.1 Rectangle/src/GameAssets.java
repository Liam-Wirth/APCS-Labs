import apcslib.DrawingTool;
import apcslib.SketchPad;

import java.awt.*;
import java.util.Objects;

public class GameAssets {
	Square Sq1 = new Square(); //-300, 300
	Square Sq2 = new Square(); //-100, 300
	Square Sq3 = new Square(); //100,  300
	Square Sq4 = new Square(); //-300, 100
	Square Sq5 = new Square(); //-100, 100
	Square Sq6 = new Square(); //100,  100
	Square Sq7 = new Square(); //-300,-100
	Square Sq8 = new Square(); //-100,-100
	Square Sq9 = new Square(); //100, -100
	private static SketchPad paper = new SketchPad(400, 400);
	private static DrawingTool pen = new DrawingTool(paper);
	public void drawGrid(){
		pen.setWidth(5);
		pen.up();
		pen.move(300,300);
		pen.down();
		pen.move(300,300);
		pen.move(300,-300);
		pen.move(-300,-300);
		pen.move(-300,300);
		pen.move(300,300);
		// drawing the horizontal lines
		pen.move(300,100);
		pen.move(-300,100);
		pen.move(-300, -100);
		pen.move(300, -100);
		//now drawing the vertical lines
		pen.up();
		pen.move(300, 300);
		pen.down();
		pen.move(100,300);
		pen.move(100, -300);
		pen.move(-100, -300);
		pen.move(-100, 300);
		pen.move(-300,300);
	}
	public void setSq1(){

		Sq1.setTopLeft(-300,300);
		Sq1.setTopRight(-100,300);
		Sq1.setBottomLeft(-300,100);
		Sq1.setBottomRight(-100,100);

	}
	public void setSq2(){

		Sq2.setTopLeft(-100,300);
		Sq2.setTopRight(100,300);
		Sq2.setBottomLeft(-100,100);
		Sq2.setBottomRight(100,100);

	}

	public void setSq3() {

		Sq3.setTopLeft(100,300);
		Sq3.setTopRight(300,300);
		Sq3.setBottomLeft(100,100);
		Sq3.setBottomRight(300,100);

	}
	public void setSq4() {

		Sq4.setTopLeft(-300,100);
		Sq4.setTopRight(-100,100);
		Sq4.setBottomLeft(-300,-100);
		Sq4.setBottomRight(-100,-100);

	}
	public void setSq5() {

		Sq5.setTopLeft(-100,100);
		Sq5.setTopRight(100,100);
		Sq5.setBottomLeft(-100,-100);
		Sq5.setBottomRight(100,-100);

	}
	public void setSq6() {

		Sq6.setTopLeft(100,100);
		Sq6.setTopRight(300,100);
		Sq6.setBottomLeft(100,-100);
		Sq6.setBottomRight(300,-100);

	}
	public void setSq7() {

		Sq7.setTopLeft(-300,-100);
		Sq7.setTopRight(-100,-100);
		Sq7.setBottomLeft(-300, -300);
		Sq7.setBottomRight(-100,-300);

	}
	public void setSq8() {

		Sq8.setTopLeft(-100,-100);
		Sq8.setTopRight(100,-100);
		Sq8.setBottomLeft(-100,-300);
		Sq8.setBottomRight(100,-300);

	}
	public void setSq9() {

		Sq9.setTopLeft(100,-100);
		Sq9.setTopRight(300,-100);
		Sq9.setBottomLeft(100,-300);
		Sq9.setBottomRight(300,-300);

	}
	public void buildGame(){
		drawGrid();
		setSq1();
		setSq2();
		setSq3();
		setSq4();
		setSq5();
		setSq6();
		setSq7();
		setSq8();
		setSq9();

	}
	public void drawX(Square input){

		//all the arrays that hold coordinates store the values in order of X,Y
		int[] topLeft     = input.getTopLeft();
		int[] topRight    = input.getTopRight();
		int[] bottomLeft  = input.getBottomLeft();
		int[] bottomRight = input.getBottomRight();
		pen.setColor(Color.red);
		pen.up();
		pen.move(topLeft[0], topLeft[1]);
		pen.down();
		pen.move(bottomRight[0], bottomRight[1]);
		pen.up();
		pen.move(topRight[0], topRight[1]);
		pen.down();
		pen.move(topRight[0], topRight[1]);
		pen.move(bottomLeft[0], bottomLeft[1]);
		pen.up();
		pen.setColor(Color.black);
		input.setState("X"); //storing the state of the square, so that I can check it for win conditions etc

	}

	public void drawO(Square input){
		int[] center =input.getCenter();
		pen.up();
		pen.move(center[0], center[1]);
		pen.down();
		pen.setColor(Color.blue);
		pen.drawCircle(100);
		pen.setColor(Color.black);
		pen.up();
		input.setState("O"); //storing the state of the square, so that I can check it for win conditions etc

	}
	public Square getSquare(int SqNumber){
		SqNumber--;
		Square[] squares = new Square[9];
		squares[0] = Sq1;
		squares[1] = Sq2;
		squares[2] = Sq3;
		squares[3] = Sq4;
		squares[4] = Sq5;
		squares[5] = Sq6;
		squares[6] = Sq7;
		squares[7] = Sq8;
		squares[8] = Sq9;


		return squares[SqNumber];
	}

	public void WipeBoard(){
		pen.up();
		pen.home();
		pen.setColor(Color.white);
		pen.setWidth(900);
		pen.down();
		pen.drawRect(400,400);
	}

	public String checkWinner() {
		String[] line = new String[3];
		String state = null;

		for (int count = 0;count<=8; count++){
			switch (count) {
				case 0://Horizontal
					line[0] = Sq1.getState();
					line[1] = Sq2.getState();
					line[2] = Sq3.getState();
					count++;
					break;
				case 1://Horizontal
					line[0] = Sq4.getState();
					line[1] = Sq5.getState();
					line[2] = Sq6.getState();
					break;
				case 2: //Horizontal
					line[0] = Sq7.getState();
					line[1] = Sq8.getState();
					line[2] = Sq9.getState();
					break;
				case 3: //Diag TopLeft to BottomRight
					line[0] = Sq1.getState();
					line[1] = Sq5.getState();
					line[2] = Sq7.getState();
					break;
				case 4: //Top Right to Bottom Left
					line[0] = Sq3.getState();
					line[1] = Sq5.getState();
					line[2] = Sq8.getState();
					break;
				case 5: //vertical line 1
					line[0] = Sq1.getState();
					line[1] = Sq4.getState();
					line[2] = Sq7.getState();
					break;
				case 6: //vertical line 2
					line[0] = Sq2.getState();
					line[1] = Sq5.getState();
					line[2] = Sq8.getState();
					break;
				case 7:
					line[0] = Sq3.getState();
					line[1] = Sq6.getState();
					line[2] = Sq9.getState();
					break;
			}
			if (Objects.equals(line.toString(), "XXX")) {
				return "X";
			} else if (Objects.equals(line.toString(), "OOO")){
				return "O";

			}
		}
		String fullboard = null;
		int j = 1;
		while (j <= 9) {

			fullboard += getSquare(j).getState();
			j++;
		}
		if (fullboard.length() == 9) {
			return "draw";

		} else {
			return null;
		}

		}

	}






