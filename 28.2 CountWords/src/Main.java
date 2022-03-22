import chn.util.FileInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static int TotalWordCount;
    private static ArrayList<String> allTheWords;
    private static Word[] temp;
    public static void main(String[] args) throws FileNotFoundException {
    loadFile();
    }
    public static void loadFile() throws FileNotFoundException {
        //A FileInput object, inFile
        File inFile = new File("src/speech.txt");
        Scanner reader = new Scanner(inFile);
            allTheWords = new ArrayList<String>();
        // gonna use this hash set to retrieve the unique values when I'm sorting stuff
      while(reader.hasNextLine()){
          String temp = reader.nextLine();
          StringTokenizer ballsack = new StringTokenizer(temp, " , . ? !");
          while(ballsack.hasMoreTokens()){
              String tempWord = ballsack.nextToken().toLowerCase(Locale.ROOT);
              allTheWords.add(tempWord);
          }
      }
       ArrayList<Word> wordArray = new ArrayList<Word>();
        HashSet<String> hset = new HashSet<String>(allTheWords);
        for (String s : hset){ //foreach loop, or an enhanced for loop, name seems to change depending on who you ask.
            int temp = findAllOccurences(s);
            wordArray.add(new Word(s,temp));
        }
        temp = wordArray.toArray(new Word[0]); //casting the arraylist to a fixed array so I can reuse bubblesort code cause I don't want to tweak the algorithm for an arraylist
        bubbleSort(temp);
        ArrayList<Word> sortedWordArray = new ArrayList<Word>(Arrays.asList(temp));
        Collections.reverse(sortedWordArray);
        List<Word> top30 =
            sortedWordArray.subList(0,29);
        for (Word w: top30) {
            System.out.println("Word: "+ w.getWord() + "\n\r   " + " Frequency: " + w.getFrequency());

        }
        System.out.println("Total Word Count " + TotalWordCount);

    }

    public static int findAllOccurences(String WordToFind){
        List<Integer> allIndexes =
                IntStream.range(0, allTheWords.size()).boxed()
                        .filter(i -> allTheWords.get(i).equals(WordToFind))
                        .collect(Collectors.toList());
        TotalWordCount+=allIndexes.size()+1;
        return allIndexes.size()+1;
    }
    static void bubbleSort (Word a[])    //using bubblesort cause too lazy to write out an algorithm that's efficient
    {
        int n = a.length;
        int i, j;
        Word temp;
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (a[j].getFrequency() < a[i].getFrequency()) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    }

