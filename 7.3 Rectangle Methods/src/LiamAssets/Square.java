package LiamAssets;
public class Square {
	private int[] topLeft    = new int[2];
	private int[] topRight   = new int[2];
	private int[] bottomLeft = new int[2];
	private int[] bottomRight= new int[2];
	private String state;
	public void setTopLeft(int x, int y) {
		topLeft[0] = x;
		topLeft[1] = y;
	}

	public void setTopRight(int x, int y) {
		topRight[0] = x;
		topRight[1] = y;
	}

	public void setBottomLeft(int x, int y) {
		bottomLeft[0] = x;
		bottomLeft[1] = y;
	}

	public void setBottomRight(int x, int y) {
		bottomRight[0] = x;
		bottomRight[1] = y;
	}
	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return state;
	}
	public int[] getTopLeft() {
		return topLeft;
	}

	public int[] getTopRight() {
		return topRight;
	}

	public int[] getBottomLeft() {
		return bottomLeft;
	}

	public int[] getBottomRight() {
		return bottomRight;
	}
	public int[] getCenter(){
		int[] center = new int[2];
		 center[0] = (topLeft[0]+topRight[0])/2; //x value of the center
		 center[1] = ((topLeft[1]+topRight[1])/2)-100; //y value of the center
		return center;
	}

}
