import java.awt.Color;
import java.awt.Graphics;

public class bubbleSortPanel extends SortingPanel {
    private int redColumn = -1;
    private int greenColumn = -1;
    protected int size;

    public bubbleSortPanel(String name, int sleepTime, int width, int height, int size) {
        super(name, sleepTime * 4, width, height);
        this.size=size;
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
            for (int k = 1; k < list.length && needNextPass; k++) {
                needNextPass = false;
                for (int outer = 1; outer < list.length; outer++) {
                    //steps += 3;
                    //  1 - boundary check of outer loop;
                    //  2 - increment, outer++
                    //  3 - initialization of inner loop
                    for (int inner = 0; inner < list.length - outer; inner++) {
                        redColumn = inner;
                        repaint();
                        Thread.sleep(sleepTime);
                        //steps += 3;
                        //  1 - boundary check of inner loop
                        //  2 - increment, inner++
                        //  3 - if comparison
                        if (list[inner] > list[inner + 1]) {
                            redColumn = inner + 1;
                            int temp = list[inner];
                            list[inner] = list[inner + 1];
                            list[inner + 1] = temp;
                            repaint();
                            Thread.sleep(sleepTime);
                            //steps += 3;    // swap of list[inner] & list[inner + 1]
                        }
                    }

                 greenColumn = size - outer;
                }
                greenColumn = 0;
                redColumn = -1;
            }


        }
        catch(InterruptedException e){
            e.printStackTrace();
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

        for (int i = 0; i < (greenColumn == -1 ? list.length : greenColumn); i++) {
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
