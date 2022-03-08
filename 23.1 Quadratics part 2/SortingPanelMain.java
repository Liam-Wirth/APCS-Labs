import javax.swing.*;
//todo modify this class to make worky
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//Visualization and Comparison of Sorting Algorithms
public class SortingPanelMain extends JRootPane{

    private static final long serialVersionUID = 1L;
    private SortingPanel sortPanel;
    private static int size = 100;
    private int sleepTime = 2;
    private String animationName = "";

    public SortingPanelMain() {
        setLayout(new GridLayout(1, 1, 0, 0));
        SortPanelsHolder sortPanelHolder = new SortPanelsHolder();
        sortPanelHolder.setLayout(new  GridLayout(0, 3, 0, 0));
        sortPanelHolder.setBackground(Color.BLACK);
        sortPanelHolder.setForeground(Color.BLACK);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.setSize(1000,1000);
        int width = 1000;
        int height= 1000;
        int choice = 1; //gonna have it so the main menu actually affects that variable, like the choice out of
                        //the drop down menu that will then corelate to this switch statement
        switch (choice){
            case 1:
                this.sortPanel = new bubbleSortPanel(" Bubble Sort ", sleepTime, width, height,size);
                sortPanelHolder.setPreferredSize(screenSize);
                sortPanelHolder.add(sortPanel);
                add(sortPanelHolder);
            break;

        }

       // sortPanels[0] = new SelectionSortPanel(" Selection Sort ", sleepTime, width, height);
       // sortPanels[1] = new ShellSortPanel(" Shell Sort ", sleepTime, width, height);
       // sortPanels[2] = new InsertionSortPanel(" Insertion Sort ", sleepTime, width, height);
       // sortPanels[3] = new MergeSortPanel(" Merge Sort ", sleepTime, width, height);
       // sortPanels[4] = new QuickSortPanel(" Quick Sort ", sleepTime, width, height);
       // sortPanels[5] = new HeapSortPanel(" Heap Sort ", sleepTime, width, height);
       // sortPanels[6] = new BubbleSortPanel(" Bubble Sort ", sleepTime, width, height);
       // sortPanels[7] = new CombSortPanel(" Comb Sort ", sleepTime, width, height);
       // sortPanels[8] = new CocktailSortPanel(" Cocktail Sort ", sleepTime, width, height);



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
            executor.shutdown();
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
        SortingPanelMain main = new SortingPanelMain();
        main.setVisible(true);
        frame.add(main);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        int[] list = new int[size];

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

        //for (int i = 0; i < list.length; i++) {
        //    list[i] = (1 + i / (size / 4) ) * (size / 4);
        //}
        //for (int i = 0; i < list.length; i++) {
        //    int index = (int) (Math.random() * list.length);
        //    int temp = list[i];
        //    list[i] = list[index];
        //    list[index] = temp;
        //}
        //main.beginAnimation("Few Unique", list);
//
//
        //for (int i = 0; i < list.length; i++) {
        //    list[i] = size - i;
        //}
        //main.beginAnimation("Reversed", list);
//
        //
        //for (int i = 0; i < list.length / 2; i++) {
        //    list[i] = i + 1;
        //}
        //for (int i = list.length / 2; i < list.length; i++) {
        //    list[i] = i + 2;
        //}
        //list[list.length - 1] = list.length / 2 + 1;
        //main.beginAnimation("Almost Sorted", list);
    }
}