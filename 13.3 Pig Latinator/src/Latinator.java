public class Latinator {
	private String rawInput; //this string is just going to hold the raw user input, I don't think it's really necessary to have this saved in this class, but maybe it will be
							// useful later down the line idunno
	private String[] formattedInput;  //taking advantage of string.split method cause it's cool, but regex is hard to understand :/
	private String[] translatedInput;
	private boolean isFirstVowell;

	public Latinator(String rawInput){
		this.rawInput = rawInput;
		this.formattedInput = rawInput.split("\\W"); //this is a stringsplitter, I just learned about it but it should split everything to an array, that I can THEN use to write
		// my code lol.
		Translate();
	}
	private void Translate(){
		boolean hasVowell;
		String currentWord;
		for (int i = 0; i < formattedInput.length; i++) {
			currentWord = formattedInput[i];
			Word temp =	wordChecker(currentWord); //throwing the currentword into my word checker loop, and initializing that as a datatype "Word" called temp
			if (!temp.isHasVowel()){
				translatedInput[i]=translateCase1(currentWord);
			}else if(temp.isHasVowel()&& !temp.isStartsWithVowel()){
				translatedInput[i]=translateCase2(currentWord, temp.getStart(), temp.getEnd());
			}else{
				translatedInput[i] = translateCase3(currentWord);
			}



		}

	}
	public String output(){
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < translatedInput.length; i++) {
		String temp;
			if (i==translatedInput.length-1 &&translatedInput.length>1){ //if it is the end of the array and the array has multiple words (therefore is a sentence)
				temp = translatedInput[i]+'.';
			}else{
				temp = translatedInput[i] + " ";
			}
			output.append(temp);
		}
		return output.toString();
	}
	//three separate cases for the three different ways you have to translate a word into pig latin aptly named case1 case2 and case3 I don't know why i whent for the structure
	// with all of these helper methods, but I decided that this would be the best way to go about doing this, deal with it.
	private String translateCase1(String Word){ //this one will be for if the word has no vowels
		String temp = Word;
		temp += "ay";
		return temp;
	}
	private String translateCase2(String Word, String Start, String End){ //this will be for when the word has a vowel
		String temp = Word;

		return temp;
	}
	private String translateCase3(String Word){ //this is for when the word starts with a vowel
		String temp = null;
		return temp;
	}
	private Word wordChecker(String Word) {
		//cw is just current word, so anything that starts with cw is reffering to the current word I am working on, I'm shooting for the EC rn just cause.
		StringBuilder cwBuild = new StringBuilder();
		int vowelcount = 0;
		boolean wascwBuildReset = false;
		Word Temp = new Word(); // almost declared this word in my loop, meaning it would reset for every char lol
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
					Temp.setHasVowel(true);
					vowelcount++;
					if (cwBuild.length() == 0) {        //another conditional to check and see if the word starts with a vowell
						Temp.setStartsWithVowel(true);     //Modifying my Word datatype to have the HasStartingvalue conditional set to true.

					}
					if (vowelcount == 1) { /// TODO: 11/11/2021 I need to remember how if and if else works when i get home and get an internet connection again. I forgor if  an else if will still run after the first if statement ran. If not I'll need to swap their order.
						Temp.setFirstVowel(cwChar);
						Temp.setStart(cwBuild.toString());  //storing the current instance of the stringbuilder as the start of the word
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
			Temp.setEnd(cwBuild.toString());
		}
		return Temp; //The return statement of this function is my own custom Word datatype. this will allow me to have multiple special things about this return in my code that
		// I can then use to translate the word and then push it to a new array that will then be the return of my translator helper method. I'm in so deep lol
	}








}


