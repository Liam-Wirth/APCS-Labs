
//this is now a defunct class because my code didn't work. I wrote all this code while I was chilling at a phil's barbeque and I didn't test it while I wrote it. I literally was
// just like "aight I'm finna write this whole shit in one go and hope it runs" and then did. The only preparation I had was writing the control structure on phil's barbeque
// napkin.
public class Latinator {
	private String rawInput; //this string is just going to hold the raw user input, I don't think it's really necessary to have this saved in this class, but maybe it will be
							// useful later down the line idunno
	private String[] formattedInput;  //taking advantage of string.split method cause it's cool, but regex is hard to understand :/
	private String[] translatedInput;
	private boolean isFirstVowell;

	public Latinator(String rawInput){
		this.rawInput = rawInput;
	}
	public void Translate(){
		this.formattedInput = rawInput.split(" "); //this is a stringsplitter, I just learned about it but it should split everything to an array, that I can THEN use to write
		// my code lol.
		for (int i = 0; i < formattedInput.length; i++) {
		String currentWord = formattedInput[i];
		Word temp = wordChecker(currentWord);
			if (!temp.isHasVowel()) translatedInput[i] = translateCase1(temp.getCurrentWord());
			else if(temp.isHasVowel()&& !temp.isStartsWithVowel()){
				translatedInput[i]=translateCase2(temp.getCurrentWord(), temp.getStart(), temp.getEnd());
			} else{
				translatedInput[i] = translateCase3(temp.getCurrentWord());
			}
		}

	}
	public String output(){ // this method takes my array that I built in the translate method, and then pushes it to an output that i can call from my tester
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < translatedInput.length; i++) {
		String temp = translatedInput[i]+ " ";
			output.append(temp);
		}
		return output.toString();
	}
	//three separate cases for the three different ways you have to translate a word into pig latin aptly named case1 case2 and case3 I don't know why i whent for the structure
	// with all of these helper methods, but I decided that this would be the best way to go about doing this, deal with it.
	private String translateCase1(String Word){ //this one will be for if the word has no vowels
		return Word + "ay";
	}
	private String translateCase2(String Word, String Start, String End){ //this will be for when the word has a vowel
		String sbTemp = End +
				Start +
				"ay";
		return sbTemp;
	}
	private String translateCase3(String Word){ //this is for when the word starts with a vowel
		String temp = Word;
		temp += "yay";
		return temp;
	}
	private Word wordChecker(String Word) {
		//cw is just current word, so anything that starts with cw is reffering to the current word I am working on, I'm shooting for the EC rn just cause.
		StringBuilder cwBuild = new StringBuilder();
		int vowelcount = 0;
		boolean hasVowel = false;
		boolean wascwBuildReset = false;
		boolean startsWithVowel =false;
		char firstVowel = 0;
		String start = null;
		String end = null;
		//Word Temp = new Word(Word); // almost declared this word in my loop, meaning it would reset for every char lol
		for (int j = 0; j < Word.length(); j++) { //my for loop, allowing this method to loop through the current word, and this method will be looping through
			char cwChar = Word.charAt(j++);
			switch (cwChar) {
				case 'a':                                    //just learned that you can merge switch statement cases, thanks intellij
				case 'e':                                    //just learned that you can merge switch statement cases, thanks intellij
				case 'i':                                    //just learned that you can merge switch statement cases, thanks intellij
				case 'o':                                    //just learned that you can merge switch statement cases, thanks intellij
				case 'u':                                    //just learned that you can merge switch statement cases, thanks intellij
				case 'A':                                    //just learned that you can merge switch statement cases, thanks intellij
				case 'E':                                    //just learned that you can merge switch statement cases, thanks intellij
				case 'I':                                    //just learned that you can merge switch statement cases, thanks intellij
				case 'O':                                    //just learned that you can merge switch statement cases, thanks intellij
				case 'U':                                    //just learned that you can merge switch statement cases, thanks intellij
					hasVowel=true;
					vowelcount++;
					if (cwBuild.length() == 0) {        //another conditional to check and see if the word starts with a vowell
						startsWithVowel=true;     //Modifying my Word datatype to have the HasStartingvalue conditional set to true.

					}
					if (vowelcount == 1) {
						firstVowel = cwChar;
						start=cwBuild.toString();  //storing the current instance of the stringbuilder as the start of the word
						//this is because the parameters for the start of the word are the entirety of the word leading up to it's first vowell
						cwBuild = new StringBuilder();      //resetting the string builder so that I can then use i
						// t to set the end of of the string when I am outside of the loop.
						wascwBuildReset = true;

					}
					break;
			} //bottom of the switch statement. (I think I should write these small little comments in because these statements are pretty big.)
			cwBuild.append(cwChar);
		} //bottom of the for loop
		if (wascwBuildReset) {
			 end = cwBuild.toString();
		}
		return new Word(start, end, hasVowel, startsWithVowel, firstVowel, Word);//The return statement of this function is my own custom Word datatype. this will allow me to have

	}








}


