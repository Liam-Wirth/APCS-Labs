import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class bubbleSortPanel extends SortingPanel {
    private int redColumn = -1;
    private int greenColumn = -1;
    protected int size;
    protected int instrumentnum = 10;
    beeper beeper;

    public bubbleSortPanel(String name, int sleepTime, int width, int height, int size) throws MidiUnavailableException {
        super(name, sleepTime * 4, width, height);
        this.size=size;
        this.beeper = super.beeper;

    }

    @Override
    public void reset() {
        redColumn = -1;
        greenColumn = -1;
    }

    @Override
    public void run() {
        try {
            boolean needNextPass = true;
            int count = 0;
            for (int k = 1; k < list.length && needNextPass; k++) {
                needNextPass = false;
                count = 0;
                for (int outer = 1; outer < list.length; outer++) {

                    System.out.print("cum ");
                    System.out.println(outer);
                    //steps += 3;
                    //  1 - boundary check of outer loop;
                    //  2 - increment, outer++
                    //  3 - initialization of inner loop
                            count++;
                            int i =1;
                    for (int inner = 0; inner < list.length - outer; inner++) {
                        count++;
                        if(count>70){
                            count /= 10;
                        }else if (count>100){
                            count /=10000;
                        }
                        redColumn = inner;
                        beeper.noteOnScale(list[count]);
                        System.out.println(list[inner]);
                        repaint();
                        Thread.sleep(sleepTime);
                        //steps += 3;
                        //  1 - boundary check of inner loop
                        //  2 - increment, inner++
                        //  3 - if comparison
                        if (list[inner] > list[inner + 1]) {
                            redColumn = inner + 1;
                            int temp = list[inner];
                            System.out.print("balls");
                            System.out.println(temp);
                            list[inner] = list[inner + 1];
                            list[inner + 1] = temp;
                            repaint();

                            //steps += 3;    // swap of list[inner] & list[inner + 1]
                        }
                    }

                 greenColumn = size - outer;
                    int temp = 0;
                }

                beeper.allNotesOff();
                greenColumn = 0;
                redColumn = -1;
            }


        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.length; i++) {
            beeper.noteOnScale(i);
            redColumn=i;
            try {
                Thread.sleep(sleepTime*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            repaint();
        }
        repaint();
    }
    protected int rectY(int i, int columnHeight){
        return getHeight()-i*columnHeight-2 * BORDER_WIDTH;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int columnWidth = (getWidth() - BORDER_WIDTH) / size;
        int columnHeight = (getToolkit().getScreenSize().height - BORDER_WIDTH)/size;

        for (int i = 0; i < ((greenColumn == -1) ? list.length : greenColumn); i++) {
            g.setColor(Color.WHITE);
            g.fillRect(2 * BORDER_WIDTH + columnWidth * i, rectY(list[i],columnHeight), columnWidth, list[i] * columnHeight);
            g.setColor(Color.BLACK);
            g.drawRect(2 * BORDER_WIDTH + columnWidth * i, rectY(list[i],columnHeight), columnWidth, list[i] * columnHeight);
        }
        if(greenColumn != -1) {
            for (int i = greenColumn; i < list.length; i++) {
                g.setColor(Color.GREEN);
                g.fillRect(2 * BORDER_WIDTH + columnWidth * i, rectY(list[i],columnHeight), columnWidth, list[i] * columnHeight);
                g.setColor(Color.BLACK);
                g.drawRect(2 * BORDER_WIDTH + columnWidth * i, rectY(list[i],columnHeight), columnWidth, list[i] * columnHeight);
            }
        }
        if(redColumn != -1) {
            g.setColor(Color.RED);
            g.fillRect(2 * BORDER_WIDTH + columnWidth * redColumn, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
            g.setColor(Color.BLACK);
            g.drawRect(2 * BORDER_WIDTH + columnWidth * redColumn, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
        }
    }

}
//TODO Document this code too
