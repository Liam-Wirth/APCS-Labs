

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//Visualization and Comparison of Sorting Algorithms
public class SortingPanelMain extends JRootPane {

    private static final long serialVersionUID = 1L;
    private static SortingPanel sortPanel;
    private static int size = 100;
    private int sleepTime = 1;
    private String animationName = "";


    public SortingPanelMain() throws MidiUnavailableException {
        setLayout(new GridLayout(1, 1, 0, 0)); //see if the layout causes the problem
        SortPanelsHolder sortPanelHolder = new SortPanelsHolder();
        sortPanelHolder.setBackground(Color.BLACK);
        sortPanelHolder.setForeground(Color.BLACK);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension defaultDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 100;
        int height = 100;
        int choice = 0;
        switch(choice){
            case 0:
                this.sortPanel = new bubbleSortPanel(" Bubble Sort ", sleepTime, 1920, 1080, size);
                sortPanelHolder.add(sortPanel);
                sortPanelHolder.add(sortPanel);
                //sortPanelHolder.remove(GridLayout);
                add(sortPanelHolder);
                repaint();
                break;
            case 1:
                add(sortPanelHolder);
                break;

        }
    }

    class SortPanelsHolder extends JPanel {
        private static final long serialVersionUID = 1L;
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            Font animationNameFont = new Font(Font.MONOSPACED, Font.BOLD, 150);
            FontMetrics animationNameFontFontMetrix = getFontMetrics(animationNameFont);
            g.setFont(animationNameFont);
            int x = (getWidth() - animationNameFontFontMetrix.stringWidth(animationName)) / 2;
            int y = (getHeight() - animationNameFontFontMetrix.getLeading()) / 2;
            g.drawString(animationName, x, y);
        }
    }

    public void beginAnimation(String animationName, int[] list) {
        try {
            this.animationName = animationName;
            repaint();
            Thread.sleep(2000);
            this.animationName = "";
            repaint();
            sortPanel.setList(list);
            sortPanel.setVisible(true);

            Thread.sleep(1000);
            ExecutorService executor = Executors.newFixedThreadPool(1);
            executor.execute(sortPanel);
            while(!executor.isTerminated()) {
                Thread.sleep(100);
            }
            Thread.sleep(1000);
                sortPanel.setVisible(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Algorithm Animations");
        JLayeredPane pane = new JLayeredPane();
        SortingPanelMain main = null;
        try {
            main = new SortingPanelMain();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        frame.setLayeredPane(pane);
        frame.setContentPane(sortPanel);
        frame.setUndecorated(false);
        frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        pane.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        pane.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        sortPanel.setVisible(true);
        pane.setVisible(true);
        frame.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);



        int[] list = new int[size];
            Random randGen = new Random();
            for (int loop = 0; loop < list.length; loop++)
            {
                list[loop] = randGen.nextInt(size) + 1;
            }

        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }
        for (int i = 0; i < list.length; i++) {
            int index = (int) (Math.random() * list.length);
            int temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }
        main.beginAnimation("Random", list);
    }
}