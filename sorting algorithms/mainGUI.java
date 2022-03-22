import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.ComponentOrientation;
import static java.awt.ComponentOrientation.LEFT_TO_RIGHT;
import static java.awt.Toolkit.getDefaultToolkit;
import javax.swing.border.TitledBorder;
import static javax.swing.border.TitledBorder.LEADING;
import static javax.swing.border.TitledBorder.TOP;

public class mainGUI extends JTabbedPane {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea Title;
	private SortingPanel sortingPanel;


	/**
	 * Create the panel.
	 */
	public mainGUI(SortingPanel SortingPanel) {
		this.sortingPanel = SortingPanel;
		initialize(SortingPanel);
	}

	public mainGUI() {

	}

	private void initialize(SortingPanel SortingPanel) {
		setVisible(true);
		setInheritsPopupMenu(true);
		setBorder(new TitledBorder(null, "VisualSortingAlgorithmsByLiam", LEADING, TOP, null, null));
		setOpaque(false);
		Dimension screenSize = new Dimension(getDefaultToolkit().getScreenSize());
		setPreferredSize(screenSize);
                add(Title);
                setVisible(true);
				addTab("Visualization", SortingPanel);


	}

	public static void main(String[] args) {

	}

	private void createUIComponents() {
		// TODO: place custom component creation code here
	}

	public SortingPanel getSortingPanel() {
		return sortingPanel;
	}

	public void setSortingPanel(SortingPanel sortingPanel) {
		this.sortingPanel = sortingPanel;
	}
}
