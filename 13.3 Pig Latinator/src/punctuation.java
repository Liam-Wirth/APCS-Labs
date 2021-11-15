// I forget, do I even use this class?
public class punctuation {
	private char symbol;
	private int index;



	public punctuation(char symbol, int index) { //constructor method
		this.symbol = symbol;
		this.index = index;
	}
	public punctuation(){

	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}
