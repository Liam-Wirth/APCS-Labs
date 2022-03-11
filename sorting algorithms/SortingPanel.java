import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Arrays;

import javax.sound.midi.*;
import javax.swing.JPanel;
public class SortingPanel extends JPanel implements Runnable{
    // I'm making an extension of Jpanel so that I can manipulate the super methods to act under my will (muahahaha)
    // I'm following a guide for Jpanel and java graphics rn so I don't fully understand why I have to implement
    // runnable just yet but I'll get there. and when I do I'll explain it, not for anyone to read ofc, but so I
    // can understand it >:)
    private static final long serialVersionUID = 1L;     //fsj;lsfdj
    protected static final int BORDER_WIDTH = 10;
    private Dimension prefferedDimension;               //
    protected int size;                                 //
    protected int[] list;                               //the list of ints to sort
    protected int sleepTime;                            //this will basically be the framerate it runs at
    private String name;                                //name of the jpanel
    protected beeper beeper;

    public SortingPanel(String name, int sleepTime, int panelWidth, int panelHeight) throws MidiUnavailableException { //constructor
        prefferedDimension = new Dimension(panelWidth, panelHeight);
        this.name = name;
        this.sleepTime = sleepTime;
        setBackground(Color.BLACK);
        this.beeper = new beeper();
        beeper.setKey("c");
        beeper.setInstrument(0,9); //128 120
        System.out.println(Arrays.toString(beeper.getInstruments()));


    }
    public void setList(int[] list){
        this.size = list.length;
        this.list = list;
    }
    @Override
    public Dimension getPreferredSize() {
        return prefferedDimension;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        //draw the border of the panel
        g.setColor(Color.PINK);
        g.drawRect(BORDER_WIDTH, BORDER_WIDTH, getWidth()-2 * BORDER_WIDTH, getHeight()-2 * BORDER_WIDTH);

        //title da window
        Font nameFont = new Font(Font.MONOSPACED, Font.BOLD, 18);
        FontMetrics nameFontMetrix = getFontMetrics(nameFont);
        g.fillRect((getWidth()-nameFontMetrix.stringWidth(name)) / 2, 0,nameFontMetrix.stringWidth(name), BORDER_WIDTH + nameFontMetrix.getAscent() / 3);
        g.setColor(Color.WHITE);
        g.setFont(nameFont);
        g.drawString(name, (getWidth() - nameFontMetrix.stringWidth(name)) / 2, BORDER_WIDTH + nameFontMetrix.getAscent() / 3);

    }
    @Override
    public void run() {

    }
    public void reset() {}

    }


