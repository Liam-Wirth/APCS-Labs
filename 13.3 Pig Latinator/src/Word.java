public class Word { //word datatype, only really used once when I am translating the code.
	private String start;
	private String end;
	private String currentWord;
	private boolean hasVowel;
	private boolean startsWithVowel;
	private char firstVowel;
	private boolean isFirstvowell;
	private boolean isFirstWord;

	public Word(String inputWord){
		inputWord = this.currentWord;
	}

	public Word(String start, String end, boolean hasVowel, boolean startsWithVowel, char FirstVowel, String currentWord) {
		this.start = start;
		this.end = end;
		this.hasVowel = hasVowel;
		this.startsWithVowel = startsWithVowel;
		this.firstVowel = FirstVowel;
		this.currentWord = currentWord;
	}
	public Word(){

	}

	public boolean isStartsWithVowel() {
		return startsWithVowel;
	}

	public void setStartsWithVowel(boolean startsWithVowel) {
		this.startsWithVowel = startsWithVowel;
	}

	public boolean isHasVowel() {
		return hasVowel;
	}

	public void setHasVowel(boolean hasVowel) {
		this.hasVowel = hasVowel;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public char getFirstVowel() {
		return firstVowel;
	}

	public void setFirstVowel(char firstVowel) {
		this.firstVowel = firstVowel;
	}

	public boolean isFirstvowell() {
		return isFirstvowell;
	}

	public void setFirstvowell(boolean firstvowell) {
		isFirstvowell = firstvowell;
	}

	public boolean isFirstWord() {
		return isFirstWord;
	}

	public void setFirstWord(boolean firstWord) {
		isFirstWord = firstWord;
	}
	public String getCurrentWord(){
		return currentWord;
	}
}
