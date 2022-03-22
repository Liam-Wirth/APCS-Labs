public class Word {
    private String word;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    private int frequency;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    Word(String word, int frequency){
        this.frequency = frequency;
        this.word=word;

    }
    Word(){

    }

}
