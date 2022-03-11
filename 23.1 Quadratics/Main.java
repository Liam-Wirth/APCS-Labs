import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class amain {
    public amain() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        var panel1 = new JPanel();
        panel1.setBackground(SystemColor.textHighlight);
        panel1.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 0, 764, 443);
        panel1.add(tabbedPane);
        
        JPanel Menu = new JPanel();
        Menu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Menu.setForeground(SystemColor.inactiveCaptionText);
        Menu.setBackground(SystemColor.desktop);
        tabbedPane.addTab("Main Menu", null, Menu, null);
        Menu.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Liam's Sorting Algorithms");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 10, 739, 48);
        lblNewLabel.setForeground(SystemColor.window);
        lblNewLabel.setLabelFor(tabbedPane);
        lblNewLabel.setFont(new Font("JetBrainsMono NF", Font.BOLD, 38));
        Menu.add(lblNewLabel);
        
        JMenu mnNewMenu = new JMenu("Choose a sorting algorithm");
        mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
        mnNewMenu.setForeground(SystemColor.text);
        mnNewMenu.setBounds(84, 86, 173, 21);
        Menu.add(mnNewMenu);
        
        JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("New radio item");
        mnNewMenu.add(rdbtnmntmNewRadioItem);
        
        JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("New radio item");
        mnNewMenu.add(rdbtnmntmNewRadioItem_1);
        PopupMenu algs = new PopupMenu();
        MenuItem bubbleSort = new MenuItem("Bubble Sort");
        bubbleSort.setActionCommand(null);
        
        JPanel Graphs = new JPanel();
        tabbedPane.addTab("New tab", null, Graphs, null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
