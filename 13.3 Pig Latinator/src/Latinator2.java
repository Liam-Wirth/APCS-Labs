import java.util.ArrayList;
import java.util.Locale;
//this is a rewritten version of my lazy phil's barbeque code, this time it actually works. apparently the only reason that my phil's code didn't work was because my stupid ass
// used an array instead of an arraylist when writing my output lol.


public class Latinator2 { //this is just a take two of my first attempt cause my first attempt literally just doesn't work
		private String input;
		private String[] inputSplit;
		private ArrayList<String> translated = new ArrayList<String>();
		private boolean inputhaspunctuation = false;
		private punctuation punctuation = new punctuation();


		public Latinator2(String input){
			int puncCounter = 0;
			char puncSymbol = 0;
			int puncIndex = 0;
			this.input = input;
			inputSplit = input.split(" ");
			for (int i = 0; i < inputSplit.length; i++) {
				String tempWord = inputSplit[i];
				for (int j = 0; j < tempWord.length(); j++) {
					char tempWordCH = tempWord.charAt(j);
					switch(tempWordCH){
						case '.':
						case '!':
						case '?':
							System.out.println("penis");
							inputhaspunctuation = true;
							puncSymbol = tempWord.charAt(tempWord.length()-1);
							puncIndex  = i;
					}

				}
				if(tempWord.matches("\\W")){
					inputhaspunctuation = true;
					 puncSymbol = tempWord.charAt(tempWord.length()-1);
					 puncIndex  = i;

				}
				}
			if (inputhaspunctuation){
				punctuation.setIndex(puncIndex);
				punctuation.setSymbol(puncSymbol);
			}
			inputSplit = input.split("\\W");
		}
		public void Translate(){
			for (int i = 0; i < inputSplit.length; i++) {
			Word currentWord = wordChecker(inputSplit[i]);
				if (!currentWord.isHasVowel()) {
					translated.add(translateCase1(currentWord.getCurrentWord()));
				}	else if(currentWord.isHasVowel()&& !currentWord.isStartsWithVowel()){
					translated.add(translateCase2(currentWord.getCurrentWord(), currentWord.getStart(), currentWord.getEnd()));
				} else{
					translated.add(translateCase3(currentWord.getCurrentWord()));
				}
			}


			}


		public String genOutput(){
			StringBuilder output = new StringBuilder();

			for (int i = 0; i < translated.size(); i++) {
				String temp = translated.get(i) + " ";
				if(i == 1){
					Character.toUpperCase(temp.charAt(0));
				}
				if(inputhaspunctuation && i ==punctuation.getIndex()){
					output.append(temp);
					output.insert(output.length()-1,punctuation.getSymbol());
				}else output.append(temp);

			}
			return output.toString();
		}
	private String translateCase1(String Word){ //this one will be for if the word has no vowels
		return Word.toLowerCase() + "ay";
	}
	private String translateCase2(String Word, String Start, String End){ //this will be for when the word has a vowel
		String sbTemp = End.toLowerCase() +
				Start +
				"ay";
		return sbTemp;
	}
	private String translateCase3(String Word){ //this is for when the word starts with a vowel
		String temp = Word.toLowerCase();
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
		boolean ran = false;

		//Word Temp = new Word(Word); // almost declared this word in my loop, meaning it would reset for every char lol
		for (int j = 0; j < Word.length(); j++) { //my for loop, allowing this method to loop through the current word, and this method will be looping through
			char cwChar = Word.charAt(j);
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

					}else if (vowelcount == 1) {
						 ran = true;
						firstVowel = cwChar;
						start = cwBuild.toString();  //storing the current instance of the stringbuilder as the start of the word
						cwBuild = new StringBuilder();
						cwBuild.append(cwChar);
						//this is because the parameters for the start of the word are the entirety of the word leading up to it's first vowell
					     //resetting the string builder so that I can then use i
						// t to set the end of of the string when I am outside of the loop.
						wascwBuildReset = true;


					}else{
						cwBuild.append(cwChar);

					}
					break;
				default:
					cwBuild.append(cwChar);

			}//bottom of the switch statement. (I think I should write these small little comments in because these statements are pretty big.)
		} //bottom of the for loop

		if (wascwBuildReset) {
			end+= firstVowel;
			end = cwBuild.toString();
		}
		return new Word(start, end, hasVowel, startsWithVowel, firstVowel, Word);//The return statement of this function is my own custom Word datatype. this will allow me to have

	}


}
